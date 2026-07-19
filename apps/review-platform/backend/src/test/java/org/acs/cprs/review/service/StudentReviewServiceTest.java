package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.ReviewStatus;
import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.repository.StudentRepository;
import org.acs.cprs.review.repository.UniversityRepository;
import org.acs.cprs.review.support.TestEntities;
import org.acs.cprs.review.web.dto.ApiDtos.StudentReviewRequest;
import org.acs.cprs.review.web.dto.ApiDtos.StudentReviewResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
class StudentReviewServiceTest {

    @Autowired
    private StudentReviewService studentReviewService;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    private Long studentId;
    private Long externalProfessorId;
    private Long sameSchoolProfessorId;

    @BeforeEach
    void setUp() {
        long n = System.nanoTime();
        var home = TestEntities.university(universityRepository, "Review Home " + n, "RH" + n % 100000);
        var away = TestEntities.university(universityRepository, "Review Away " + n, "RA" + n % 100000);
        studentId = TestEntities.student(
                studentRepository, home, "Taylor", "Quinn", "taylor.q." + n + "@home.edu", "Biology", 2
        ).getId();
        externalProfessorId = TestEntities.professor(
                professorRepository, away, "Morgan", "Lee", "morgan.l." + n + "@away.edu",
                "Biology", Seniority.SENIOR, 5, 0
        ).getId();
        sameSchoolProfessorId = TestEntities.professor(
                professorRepository, home, "Jordan", "Park", "jordan.p." + n + "@home.edu",
                "Biology", Seniority.JUNIOR, 5, 0
        ).getId();
    }

    @Test
    void createsSubmittedReviewForExternalProfessor() {
        StudentReviewResponse review = studentReviewService.create(new StudentReviewRequest(
                studentId,
                externalProfessorId,
                "Solid course",
                "Clear lectures",
                4,
                ReviewStatus.SUBMITTED
        ));

        assertThat(review.id()).isNotNull();
        assertThat(review.status()).isEqualTo(ReviewStatus.SUBMITTED);
        assertThat(review.submittedAt()).isNotNull();
        assertThat(studentReviewService.list()).anyMatch(r -> r.id().equals(review.id()));
    }

    @Test
    void rejectsSameUniversityReview() {
        assertThatThrownBy(() -> studentReviewService.create(new StudentReviewRequest(
                studentId,
                sameSchoolProfessorId,
                "Nope",
                null,
                2,
                ReviewStatus.DRAFT
        ))).isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("different universities");
    }
}
