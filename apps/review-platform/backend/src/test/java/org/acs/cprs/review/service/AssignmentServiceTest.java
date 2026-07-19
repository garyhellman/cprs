package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.AssignmentStatus;
import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.repository.StudentRepository;
import org.acs.cprs.review.repository.UniversityRepository;
import org.acs.cprs.review.support.TestEntities;
import org.acs.cprs.review.web.dto.ApiDtos.AcceptAssignmentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.AssignmentResponse;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestAssignmentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestAssignmentResponse;
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
class AssignmentServiceTest {

    @Autowired
    private AssignmentService assignmentService;

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
        var home = TestEntities.university(universityRepository, "Home U " + n, "HM" + n % 100000);
        var away = TestEntities.university(universityRepository, "Away U " + n, "AW" + n % 100000);
        var student = TestEntities.student(
                studentRepository, home, "Sam", "Test", "sam.test." + n + "@home.edu", "CS", 4);
        var external = TestEntities.professor(
                professorRepository, away, "Dana", "Ext", "dana.ext." + n + "@away.edu",
                "CS", Seniority.TENURED, 5, 1);
        var same = TestEntities.professor(
                professorRepository, home, "Chris", "Local", "chris.local." + n + "@home.edu",
                "CS", Seniority.SENIOR, 5, 0);

        studentId = student.getId();
        externalProfessorId = external.getId();
        sameSchoolProfessorId = same.getId();
    }

    @Test
    void suggestReturnsOnlyExternalProfessors() {
        SuggestAssignmentResponse response = assignmentService.suggest(
                new SuggestAssignmentRequest(studentId, 50)
        );

        assertThat(response.studentId()).isEqualTo(studentId);
        assertThat(response.suggestions()).isNotEmpty();
        assertThat(response.suggestions())
                .noneMatch(s -> s.professorId().equals(sameSchoolProfessorId));
        assertThat(response.suggestions())
                .anyMatch(s -> s.professorId().equals(externalProfessorId));
    }

    @Test
    void acceptPersistsAssignmentAndIncrementsLoad() {
        int before = professorRepository.findById(externalProfessorId).orElseThrow().getActiveReviewCount();

        AssignmentResponse accepted = assignmentService.accept(
                new AcceptAssignmentRequest(studentId, externalProfessorId, 77.0, "balanced external")
        );

        assertThat(accepted.status()).isEqualTo(AssignmentStatus.ACCEPTED);
        assertThat(accepted.professorId()).isEqualTo(externalProfessorId);
        assertThat(accepted.score()).isNotNull();

        int after = professorRepository.findById(externalProfessorId).orElseThrow().getActiveReviewCount();
        assertThat(after).isEqualTo(before + 1);

        assertThat(assignmentService.listForStudent(studentId))
                .anyMatch(a -> a.id().equals(accepted.id()));
    }

    @Test
    void acceptRejectsSameUniversityPair() {
        assertThatThrownBy(() -> assignmentService.accept(
                new AcceptAssignmentRequest(studentId, sameSchoolProfessorId, 1.0, "nope")
        )).isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("different universities");
    }

    @Test
    void suggestFailsForMissingStudent() {
        assertThatThrownBy(() -> assignmentService.suggest(new SuggestAssignmentRequest(999999L, 5)))
                .isInstanceOf(ResponseStatusException.class);
    }
}
