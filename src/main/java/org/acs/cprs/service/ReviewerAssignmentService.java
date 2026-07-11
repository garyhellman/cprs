package org.acs.cprs.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.acs.cprs.model.Reviewer;
import org.acs.cprs.model.Student;
import org.acs.cprs.model.StudentReviewerAssignment;
import org.acs.cprs.repository.ReviewerRepository;
import org.acs.cprs.repository.StudentRepository;
import org.acs.cprs.repository.StudentReviewerAssignmentRepository;
import org.acs.cprs.rules.model.ReviewerCapacityFact;
import org.acs.cprs.rules.model.StudentAssignmentFact;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewerAssignmentService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewerAssignmentService.class);

    private final KieContainer kieContainer;
    private final StudentRepository studentRepository;
    private final ReviewerRepository reviewerRepository;
    private final StudentReviewerAssignmentRepository assignmentRepository;

    public ReviewerAssignmentService(KieContainer kieContainer,
                                       StudentRepository studentRepository,
                                       ReviewerRepository reviewerRepository,
                                       StudentReviewerAssignmentRepository assignmentRepository) {
        this.kieContainer = kieContainer;
        this.studentRepository = studentRepository;
        this.reviewerRepository = reviewerRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional
    public List<StudentReviewerAssignment> runAssignmentRules() {
        List<Student> students = studentRepository.findAll();
        List<Reviewer> reviewers = reviewerRepository.findAll();

        if (students.isEmpty() || reviewers.isEmpty()) {
            return List.of();
        }

        assignmentRepository.deleteAllInBatch();

        List<StudentAssignmentFact> studentFacts = students.stream()
                .map(this::toStudentFact)
                .collect(Collectors.toCollection(ArrayList::new));

        List<ReviewerCapacityFact> reviewerFacts = reviewers.stream()
                .map(this::toReviewerFact)
                .collect(Collectors.toCollection(ArrayList::new));

        KieSession session = kieContainer.newKieSession("reviewerAssignmentSession");
        try {
            studentFacts.forEach(session::insert);
            reviewerFacts.forEach(session::insert);
            int fired = session.fireAllRules();
            logger.info("Drools fired {} assignment rules", fired);
        } finally {
            session.dispose();
        }

        List<StudentReviewerAssignment> assignments = new ArrayList<>();
        for (StudentAssignmentFact fact : studentFacts) {
            if (!fact.isAssigned()) {
                logger.warn("Student {} remained unassigned after rule execution", fact.getStudentName());
                continue;
            }
            StudentReviewerAssignment assignment = new StudentReviewerAssignment();
            assignment.setStudentId(fact.getStudentId());
            assignment.setStudentName(fact.getStudentName());
            assignment.setReviewerId(fact.getAssignedReviewerId());
            assignment.setReviewerName(fact.getAssignedReviewerName());
            assignment.setMatchedRule(fact.getMatchedRule());
            assignment.setAssignedAt(Instant.now());
            assignments.add(assignmentRepository.save(assignment));
        }

        return assignments;
    }

    @Transactional(readOnly = true)
    public List<StudentReviewerAssignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<StudentReviewerAssignment> getAssignmentsForReviewer(Long reviewerId) {
        return assignmentRepository.findByReviewerId(reviewerId);
    }

    private StudentAssignmentFact toStudentFact(Student student) {
        StudentAssignmentFact fact = new StudentAssignmentFact();
        fact.setStudentId(student.getId());
        fact.setStudentName(student.getName());
        fact.setInstitutionName(student.getInstitutionName());
        fact.setRegion(student.getRegion());
        fact.setSpecialty(student.getSpecialty());
        fact.setAffiliatedSchoolId(student.getAffiliatedSchoolId());
        fact.setAssigned(false);
        return fact;
    }

    private ReviewerCapacityFact toReviewerFact(Reviewer reviewer) {
        ReviewerCapacityFact fact = new ReviewerCapacityFact();
        fact.setReviewerId(reviewer.getId());
        fact.setReviewerName(reviewer.getName());
        fact.setRegion(reviewer.getRegion());
        fact.setSpecialty(reviewer.getSpecialty());
        fact.setMaxCapacity(reviewer.getMaxCapacity());
        fact.setCurrentLoad(0);
        fact.setAffiliatedSchoolIds(parseAffiliatedSchoolIds(reviewer.getAffiliatedSchoolIds()));
        return fact;
    }

    private Set<String> parseAffiliatedSchoolIds(String raw) {
        if (raw == null || raw.isBlank()) {
            return Set.of();
        }
        return Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .collect(Collectors.toCollection(HashSet::new));
    }
}
