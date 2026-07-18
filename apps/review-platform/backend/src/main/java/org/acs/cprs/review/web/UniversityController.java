package org.acs.cprs.review.web;

import jakarta.validation.Valid;
import org.acs.cprs.review.service.UniversityService;
import org.acs.cprs.review.web.dto.ApiDtos.UniversityRequest;
import org.acs.cprs.review.web.dto.ApiDtos.UniversityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<UniversityResponse> list() {
        return universityService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UniversityResponse create(@Valid @RequestBody UniversityRequest request) {
        return universityService.create(request);
    }
}
