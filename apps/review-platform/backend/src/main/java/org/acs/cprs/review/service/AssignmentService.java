package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.AssignmentStatus;
import org.acs.cprs.review.domain.Professor;
import org.acs.cprs.review.domain.ReviewAssignment;
import org.acs.cprs.review.domain.Student;
import org.acs.cprs.review.domain.StudentReview;
import org.acs.cprs.review.drools.facts.AssignmentRequest;
import org.acs.cprs.review.drools.facts.AssignmentSuggestion;
import org.acs.cprs.review.drools.facts.ExistingReviewLink;
import org.acs.cprs.review.drools.facts.ProfessorCandidate;
import org.acs.cprs.review.drools.service.AssignmentRulesEngine;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.repository.ReviewAssignmentRepository;
import org.acs.cprs.review.repository.StudentReviewRepository;
import org.acs.cprs.review.web.dto.ApiDtos.AcceptAssignmentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.AssignmentResponse;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestAssignmentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestAssignmentResponse;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    private final StudentService studentService;
    private final ProfessorService professorService;
    private final ProfessorRepository professorRepository;
    private final StudentReviewRepository studentReviewRepository;
    private final ReviewAssignmentRepository reviewAssignmentRepository;
    private final AssignmentRulesEngine assignmentRulesEngine;

    public AssignmentService(
            StudentService studentService,
            ProfessorService professorService,
            ProfessorRepository professorRepository,
            StudentReviewRepository studentReviewRepository,
            ReviewAssignmentRepository reviewAssignmentRepository,
            AssignmentRulesEngine assignmentRulesEngine
    ) {
        this.studentService = studentService;
        this.professorService = professorService;
        this.professorRepository = professorRepository;
        this.studentReviewRepository = studentReviewRepository;
        this.reviewAssignmentRepository = reviewAssignmentRepository;
        this.assignmentRulesEngine = assignmentRulesEngine;
    }

    @Transactional(readOnly = true)
    public SuggestAssignmentResponse suggest(SuggestAssignmentRequest request) {
        Student student = studentService.require(request.studentId());
        // Pool all professors; Drools AvoidSameUniversity drops same-school candidates
        List<Professor> professors = professorRepository.findByDeletedFalseOrderByLastNameAsc();

        AssignmentRequest factRequest = new AssignmentRequest();
        factRequest.setStudentId(student.getId());
        factRequest.setUniversityId(student.getUniversity().getId());
        factRequest.setDepartment(student.getDepartment());
        factRequest.setYearLevel(student.getYearLevel());
        factRequest.setInterests(student.getInterests());
        if (request.maxResults() != null) {
            factRequest.setMaxResults(request.maxResults());
        }

        List<ProfessorCandidate> candidates = new ArrayList<>();
        for (Professor professor : professors) {
            ProfessorCandidate candidate = new ProfessorCandidate();
            candidate.setProfessorId(professor.getId());
            candidate.setUniversityId(professor.getUniversity().getId());
            candidate.setDepartment(professor.getDepartment());
            candidate.setResearchAreas(professor.getResearchAreas());
            candidate.setSeniority(professor.getSeniority().name());
            candidate.setMaxActiveReviews(professor.getMaxActiveReviews());
            candidate.setActiveReviewCount(professor.getActiveReviewCount());
            candidates.add(candidate);
        }

        List<ExistingReviewLink> links = studentReviewRepository.findByStudentIdAndDeletedFalse(student.getId())
                .stream()
                .map(this::toLink)
                .toList();

        List<AssignmentSuggestion> suggestions = assignmentRulesEngine.evaluate(factRequest, candidates, links);
        Map<Long, Professor> byId = professors.stream()
                .collect(Collectors.toMap(Professor::getId, Function.identity()));

        List<SuggestionResponse> responseItems = suggestions.stream()
                .map(suggestion -> {
                    Professor professor = byId.get(suggestion.getProfessorId());
                    String name = professor == null
                            ? "Professor " + suggestion.getProfessorId()
                            : professor.getFirstName() + " " + professor.getLastName();
                    return new SuggestionResponse(
                            suggestion.getProfessorId(),
                            name,
                            suggestion.getScore(),
                            suggestion.getReason()
                    );
                })
                .toList();

        return new SuggestAssignmentResponse(student.getId(), responseItems);
    }

    @Transactional
    public AssignmentResponse accept(AcceptAssignmentRequest request) {
        Student student = studentService.require(request.studentId());
        Professor professor = professorService.require(request.professorId());
        if (student.getUniversity().getId().equals(professor.getUniversity().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Student and professor must be from different universities"
            );
        }

        ReviewAssignment assignment = new ReviewAssignment();
        assignment.setStudent(student);
        assignment.setProfessor(professor);
        assignment.setUniversity(student.getUniversity());
        assignment.setStatus(AssignmentStatus.ACCEPTED);
        double score = request.score() == null ? 0.0 : request.score();
        assignment.setScore(BigDecimal.valueOf(score).setScale(2, RoundingMode.HALF_UP));
        assignment.setReason(request.reason());
        assignment.setRuleTrace(request.reason());
        assignment.setCreatedBy("system");
        assignment.setUpdatedBy("system");

        professor.setActiveReviewCount(professor.getActiveReviewCount() + 1);
        return toResponse(reviewAssignmentRepository.save(assignment));
    }

    @Transactional(readOnly = true)
    public List<AssignmentResponse> listForStudent(Long studentId) {
        studentService.require(studentId);
        return reviewAssignmentRepository.findByStudentIdOrderByScoreDesc(studentId).stream()
                .map(this::toResponse)
                .toList();
    }

    private ExistingReviewLink toLink(StudentReview review) {
        return new ExistingReviewLink(
                review.getStudent().getId(),
                review.getProfessor().getId(),
                review.getSubmittedAt() != null ? review.getSubmittedAt() : review.getCreatedAt()
        );
    }

    private AssignmentResponse toResponse(ReviewAssignment assignment) {
        return new AssignmentResponse(
                assignment.getId(),
                assignment.getStudent().getId(),
                assignment.getProfessor().getId(),
                assignment.getUniversity().getId(),
                assignment.getStatus(),
                assignment.getScore(),
                assignment.getReason(),
                assignment.getRuleTrace()
        );
    }
}
