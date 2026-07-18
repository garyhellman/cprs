package org.acs.cprs.review.web;

import jakarta.validation.Valid;
import org.acs.cprs.review.service.StudentReviewService;
import org.acs.cprs.review.web.dto.ApiDtos.StudentReviewRequest;
import org.acs.cprs.review.web.dto.ApiDtos.StudentReviewResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class StudentReviewController {

    private final StudentReviewService studentReviewService;

    public StudentReviewController(StudentReviewService studentReviewService) {
        this.studentReviewService = studentReviewService;
    }

    @GetMapping
    public List<StudentReviewResponse> list() {
        return studentReviewService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentReviewResponse create(@Valid @RequestBody StudentReviewRequest request) {
        return studentReviewService.create(request);
    }
}
