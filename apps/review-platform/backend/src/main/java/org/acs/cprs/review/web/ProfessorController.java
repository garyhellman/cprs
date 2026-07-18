package org.acs.cprs.review.web;

import jakarta.validation.Valid;
import org.acs.cprs.review.service.ProfessorService;
import org.acs.cprs.review.web.dto.ApiDtos.ProfessorRequest;
import org.acs.cprs.review.web.dto.ApiDtos.ProfessorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<ProfessorResponse> list(@RequestParam(required = false) Long universityId) {
        return professorService.list(universityId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorResponse create(@Valid @RequestBody ProfessorRequest request) {
        return professorService.create(request);
    }
}
