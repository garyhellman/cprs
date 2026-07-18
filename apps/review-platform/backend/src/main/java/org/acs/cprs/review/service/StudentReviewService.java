package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.Professor;
import org.acs.cprs.review.domain.ReviewStatus;
import org.acs.cprs.review.domain.Student;
import org.acs.cprs.review.domain.StudentReview;
import org.acs.cprs.review.repository.StudentReviewRepository;
import org.acs.cprs.review.web.dto.ApiDtos.StudentReviewRequest;
import org.acs.cprs.review.web.dto.ApiDtos.StudentReviewResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;

@Service
public class StudentReviewService {

    private final StudentReviewRepository studentReviewRepository;
    private final StudentService studentService;
    private final ProfessorService professorService;

    public StudentReviewService(
            StudentReviewRepository studentReviewRepository,
            StudentService studentService,
            ProfessorService professorService
    ) {
        this.studentReviewRepository = studentReviewRepository;
        this.studentService = studentService;
        this.professorService = professorService;
    }

    @Transactional(readOnly = true)
    public List<StudentReviewResponse> list() {
        return studentReviewRepository.findByDeletedFalseOrderByCreatedAtDesc().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public StudentReviewResponse create(StudentReviewRequest request) {
        Student student = studentService.require(request.studentId());
        Professor professor = professorService.require(request.professorId());
        if (student.getUniversity().getId().equals(professor.getUniversity().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Student and professor must be from different universities"
            );
        }

        StudentReview review = new StudentReview();
        review.setStudent(student);
        review.setProfessor(professor);
        review.setUniversity(student.getUniversity());
        review.setTitle(request.title().trim());
        review.setBody(request.body());
        review.setRating(request.rating());
        ReviewStatus status = request.status() == null ? ReviewStatus.DRAFT : request.status();
        review.setStatus(status);
        if (status != ReviewStatus.DRAFT) {
            review.setSubmittedAt(Instant.now());
        }
        review.setCreatedBy("system");
        review.setUpdatedBy("system");
        return toResponse(studentReviewRepository.save(review));
    }

    private StudentReviewResponse toResponse(StudentReview review) {
        return new StudentReviewResponse(
                review.getId(),
                review.getStudent().getId(),
                review.getProfessor().getId(),
                review.getUniversity().getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                review.getStatus(),
                review.getSubmittedAt()
        );
    }
}
