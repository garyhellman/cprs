package org.acs.cprs.review.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.repository.StudentRepository;
import org.acs.cprs.review.repository.UniversityRepository;
import org.acs.cprs.review.support.TestEntities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ReviewPlatformApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    private Long studentUniId;
    private Long otherUniId;
    private Long studentId;
    private Long externalProfessorId;
    private Long sameSchoolProfessorId;

    @BeforeEach
    void setUp() {
        long n = System.nanoTime();
        var studentUni = TestEntities.university(universityRepository, "North Test U " + n, "NTU-" + n);
        var otherUni = TestEntities.university(universityRepository, "South Test U " + n, "STU-" + n);
        studentUniId = studentUni.getId();
        otherUniId = otherUni.getId();

        var student = TestEntities.student(
                studentRepository, studentUni, "Pat", "Lee", "pat.lee." + n + "@ntu.edu", "CS", 3);
        var external = TestEntities.professor(
                professorRepository, otherUni, "Casey", "Ng", "casey.ng." + n + "@stu.edu",
                "CS", Seniority.SENIOR, 5, 0);
        var sameSchool = TestEntities.professor(
                professorRepository, studentUni, "Riley", "Kim", "riley.kim." + n + "@ntu.edu",
                "CS", Seniority.TENURED, 5, 0);

        studentId = student.getId();
        externalProfessorId = external.getId();
        sameSchoolProfessorId = sameSchool.getId();
    }

    @Test
    void createsAndListsUniversity() throws Exception {
        String code = "API-" + System.nanoTime();
        mockMvc.perform(post("/api/v1/universities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"API University %s","code":"%s","country":"CA"}
                                """.formatted(code, code)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("API University " + code))
                .andExpect(jsonPath("$.code").value(code));

        mockMvc.perform(get("/api/v1/universities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))));
    }

    @Test
    void createsProfessorAndStudent() throws Exception {
        long n = System.nanoTime();
        mockMvc.perform(post("/api/v1/professors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "universityId": %d,
                                  "firstName": "Alex",
                                  "lastName": "Rivera",
                                  "email": "alex.rivera.%d@example.edu",
                                  "department": "Math",
                                  "researchAreas": "stats",
                                  "seniority": "JUNIOR",
                                  "maxActiveReviews": 4
                                }
                                """.formatted(otherUniId, n)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.department").value("Math"))
                .andExpect(jsonPath("$.seniority").value("JUNIOR"));

        mockMvc.perform(post("/api/v1/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "universityId": %d,
                                  "firstName": "Jamie",
                                  "lastName": "Ortiz",
                                  "email": "jamie.ortiz.%d@example.edu",
                                  "department": "CS",
                                  "yearLevel": 2,
                                  "interests": "ai"
                                }
                                """.formatted(studentUniId, n)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.yearLevel").value(2));
    }

    @Test
    void suggestExcludesSameUniversityProfessor() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/v1/assignments/suggest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"studentId": %d, "maxResults": 20}
                                """.formatted(studentId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentId").value(studentId))
                .andReturn();

        JsonNode suggestions = objectMapper.readTree(result.getResponse().getContentAsString())
                .path("suggestions");
        assertThat(suggestions.isArray()).isTrue();

        boolean sawExternal = false;
        for (JsonNode suggestion : suggestions) {
            long professorId = suggestion.path("professorId").asLong();
            assertThat(professorId).isNotEqualTo(sameSchoolProfessorId);
            if (professorId == externalProfessorId) {
                sawExternal = true;
            }
        }
        assertThat(sawExternal).isTrue();
    }

    @Test
    void acceptAssignmentAndListForStudent() throws Exception {
        mockMvc.perform(post("/api/v1/assignments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "studentId": %d,
                                  "professorId": %d,
                                  "score": 55.5,
                                  "reason": "external match"
                                }
                                """.formatted(studentId, externalProfessorId)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("ACCEPTED"))
                .andExpect(jsonPath("$.professorId").value(externalProfessorId));

        mockMvc.perform(get("/api/v1/assignments/student/" + studentId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].studentId").value(studentId));
    }

    @Test
    void rejectAcceptWhenSameUniversity() throws Exception {
        mockMvc.perform(post("/api/v1/assignments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "studentId": %d,
                                  "professorId": %d,
                                  "score": 10,
                                  "reason": "should fail"
                                }
                                """.formatted(studentId, sameSchoolProfessorId)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createReviewForExternalProfessor() throws Exception {
        mockMvc.perform(post("/api/v1/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "studentId": %d,
                                  "professorId": %d,
                                  "title": "Great mentor",
                                  "body": "Helpful feedback",
                                  "rating": 5,
                                  "status": "SUBMITTED"
                                }
                                """.formatted(studentId, externalProfessorId)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Great mentor"))
                .andExpect(jsonPath("$.status").value("SUBMITTED"));

        mockMvc.perform(get("/api/v1/reviews"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))));
    }

    @Test
    void rejectReviewWhenSameUniversity() throws Exception {
        mockMvc.perform(post("/api/v1/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "studentId": %d,
                                  "professorId": %d,
                                  "title": "Invalid",
                                  "rating": 3,
                                  "status": "DRAFT"
                                }
                                """.formatted(studentId, sameSchoolProfessorId)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void validationRejectsBlankUniversityName() throws Exception {
        mockMvc.perform(post("/api/v1/universities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"","code":"X","country":"US"}
                                """))
                .andExpect(status().isBadRequest());
    }
}
