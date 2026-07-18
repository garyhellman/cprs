package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.University;
import org.acs.cprs.review.repository.UniversityRepository;
import org.acs.cprs.review.web.dto.ApiDtos.UniversityRequest;
import org.acs.cprs.review.web.dto.ApiDtos.UniversityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Transactional(readOnly = true)
    public List<UniversityResponse> list() {
        return universityRepository.findByDeletedFalseOrderByNameAsc().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public UniversityResponse create(UniversityRequest request) {
        University university = new University();
        university.setName(request.name().trim());
        university.setCode(blankToNull(request.code()));
        university.setCountry(blankToNull(request.country()));
        university.setCreatedBy("system");
        university.setUpdatedBy("system");
        return toResponse(universityRepository.save(university));
    }

    @Transactional(readOnly = true)
    public University require(Long id) {
        return universityRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found"));
    }

    private UniversityResponse toResponse(University university) {
        return new UniversityResponse(
                university.getId(),
                university.getName(),
                university.getCode(),
                university.getCountry(),
                university.getCreatedAt()
        );
    }

    private static String blankToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value.trim();
    }
}
