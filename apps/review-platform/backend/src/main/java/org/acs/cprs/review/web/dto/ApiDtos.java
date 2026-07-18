package org.acs.cprs.review.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acs.cprs.review.domain.AssignmentStatus;
import org.acs.cprs.review.domain.ReviewStatus;
import org.acs.cprs.review.domain.Seniority;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public final class ApiDtos {

    private ApiDtos() {
    }

    public record UniversityRequest(
            @NotBlank String name,
            String code,
            String country
    ) {
    }

    public record UniversityResponse(
            Long id,
            String name,
            String code,
            String country,
            Instant createdAt
    ) {
    }

    public record ProfessorRequest(
            @NotNull Long universityId,
            @NotBlank String firstName,
            @NotBlank String lastName,
            @NotBlank @Email String email,
            String department,
            String researchAreas,
            Seniority seniority,
            @Min(1) Integer maxActiveReviews
    ) {
    }

    public record ProfessorResponse(
            Long id,
            Long universityId,
            String firstName,
            String lastName,
            String email,
            String department,
            String researchAreas,
            Seniority seniority,
            int maxActiveReviews,
            int activeReviewCount
    ) {
    }

    public record StudentRequest(
            @NotNull Long universityId,
            @NotBlank String firstName,
            @NotBlank String lastName,
            @NotBlank @Email String email,
            String department,
            @Min(1) @Max(10) Integer yearLevel,
            String interests
    ) {
    }

    public record StudentResponse(
            Long id,
            Long universityId,
            String firstName,
            String lastName,
            String email,
            String department,
            Integer yearLevel,
            String interests
    ) {
    }

    public record StudentReviewRequest(
            @NotNull Long studentId,
            @NotNull Long professorId,
            @NotBlank String title,
            String body,
            @Min(1) @Max(5) Integer rating,
            ReviewStatus status
    ) {
    }

    public record StudentReviewResponse(
            Long id,
            Long studentId,
            Long professorId,
            Long universityId,
            String title,
            String body,
            Integer rating,
            ReviewStatus status,
            Instant submittedAt
    ) {
    }

    public record SuggestAssignmentRequest(
            @NotNull Long studentId,
            @Min(1) @Max(20) Integer maxResults
    ) {
    }

    public record SuggestionResponse(
            Long professorId,
            String professorName,
            double score,
            String reason
    ) {
    }

    public record SuggestAssignmentResponse(
            Long studentId,
            List<SuggestionResponse> suggestions
    ) {
    }

    public record AcceptAssignmentRequest(
            @NotNull Long studentId,
            @NotNull Long professorId,
            Double score,
            String reason
    ) {
    }

    public record AssignmentResponse(
            Long id,
            Long studentId,
            Long professorId,
            Long universityId,
            AssignmentStatus status,
            BigDecimal score,
            String reason,
            String ruleTrace
    ) {
    }
}
