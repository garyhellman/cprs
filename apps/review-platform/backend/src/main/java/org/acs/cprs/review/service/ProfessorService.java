package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.Professor;
import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.domain.University;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.web.dto.ApiDtos.ProfessorRequest;
import org.acs.cprs.review.web.dto.ApiDtos.ProfessorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final UniversityService universityService;

    public ProfessorService(ProfessorRepository professorRepository, UniversityService universityService) {
        this.professorRepository = professorRepository;
        this.universityService = universityService;
    }

    @Transactional(readOnly = true)
    public List<ProfessorResponse> list(Long universityId) {
        List<Professor> professors = universityId == null
                ? professorRepository.findByDeletedFalseOrderByLastNameAsc()
                : professorRepository.findByUniversityIdAndDeletedFalseOrderByLastNameAsc(universityId);
        return professors.stream().map(this::toResponse).toList();
    }

    @Transactional
    public ProfessorResponse create(ProfessorRequest request) {
        University university = universityService.require(request.universityId());
        Professor professor = new Professor();
        professor.setUniversity(university);
        professor.setFirstName(request.firstName().trim());
        professor.setLastName(request.lastName().trim());
        professor.setEmail(request.email().trim().toLowerCase());
        professor.setDepartment(blankToNull(request.department()));
        professor.setResearchAreas(blankToNull(request.researchAreas()));
        professor.setSeniority(request.seniority() == null ? Seniority.JUNIOR : request.seniority());
        if (request.maxActiveReviews() != null) {
            professor.setMaxActiveReviews(request.maxActiveReviews());
        }
        professor.setCreatedBy("system");
        professor.setUpdatedBy("system");
        return toResponse(professorRepository.save(professor));
    }

    @Transactional(readOnly = true)
    public Professor require(Long id) {
        return professorRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not found"));
    }

    private ProfessorResponse toResponse(Professor professor) {
        return new ProfessorResponse(
                professor.getId(),
                professor.getUniversity().getId(),
                professor.getFirstName(),
                professor.getLastName(),
                professor.getEmail(),
                professor.getDepartment(),
                professor.getResearchAreas(),
                professor.getSeniority(),
                professor.getMaxActiveReviews(),
                professor.getActiveReviewCount()
        );
    }

    private static String blankToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value.trim();
    }
}
