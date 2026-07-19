package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.web.dto.ApiDtos.ProfessorRequest;
import org.acs.cprs.review.web.dto.ApiDtos.ProfessorResponse;
import org.acs.cprs.review.web.dto.ApiDtos.StudentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.StudentResponse;
import org.acs.cprs.review.web.dto.ApiDtos.UniversityRequest;
import org.acs.cprs.review.web.dto.ApiDtos.UniversityResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
class EntityCrudServiceTest {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private StudentService studentService;

    @Test
    void universityProfessorStudentCrudHappyPath() {
        long n = System.nanoTime();
        UniversityResponse university = universityService.create(
                new UniversityRequest("Crud U " + n, "CU" + (n % 100000), "US")
        );
        assertThat(university.id()).isNotNull();
        assertThat(universityService.list()).anyMatch(u -> u.id().equals(university.id()));
        assertThat(universityService.require(university.id()).getName()).contains("Crud U");

        ProfessorResponse professor = professorService.create(new ProfessorRequest(
                university.id(),
                "Avery",
                "Stone",
                "avery.stone." + n + "@crud.edu",
                "Physics",
                "optics,lasers",
                Seniority.SENIOR,
                6
        ));
        assertThat(professor.universityId()).isEqualTo(university.id());
        assertThat(professorService.list(university.id())).extracting(ProfessorResponse::id)
                .contains(professor.id());

        StudentResponse student = studentService.create(new StudentRequest(
                university.id(),
                "Blake",
                "Nguyen",
                "blake.nguyen." + n + "@crud.edu",
                "Physics",
                3,
                "optics"
        ));
        assertThat(student.yearLevel()).isEqualTo(3);
        assertThat(studentService.list(university.id())).extracting(StudentResponse::id)
                .contains(student.id());
    }

    @Test
    void requireUnknownUniversityThrowsNotFound() {
        assertThatThrownBy(() -> universityService.require(987654321L))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("University not found");
    }

    @Test
    void createProfessorForMissingUniversityFails() {
        assertThatThrownBy(() -> professorService.create(new ProfessorRequest(
                987654321L,
                "No",
                "Uni",
                "no.uni@example.edu",
                "CS",
                null,
                Seniority.JUNIOR,
                5
        ))).isInstanceOf(ResponseStatusException.class);
    }
}
