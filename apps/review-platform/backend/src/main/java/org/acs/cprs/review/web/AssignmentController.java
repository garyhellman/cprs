package org.acs.cprs.review.web;

import jakarta.validation.Valid;
import org.acs.cprs.review.service.AssignmentService;
import org.acs.cprs.review.web.dto.ApiDtos.AcceptAssignmentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.AssignmentResponse;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestAssignmentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.SuggestAssignmentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/suggest")
    public SuggestAssignmentResponse suggest(@Valid @RequestBody SuggestAssignmentRequest request) {
        return assignmentService.suggest(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssignmentResponse accept(@Valid @RequestBody AcceptAssignmentRequest request) {
        return assignmentService.accept(request);
    }

    @GetMapping("/student/{studentId}")
    public List<AssignmentResponse> listForStudent(@PathVariable Long studentId) {
        return assignmentService.listForStudent(studentId);
    }
}
