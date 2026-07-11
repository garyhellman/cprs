package org.acs.cprs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acs.cprs.model.Reviewer;
import org.acs.cprs.model.Student;
import org.acs.cprs.model.StudentReviewerAssignment;
import org.acs.cprs.repository.ReviewerRepository;
import org.acs.cprs.repository.StudentRepository;
import org.acs.cprs.service.ReviewerAssignmentService;
import org.acs.cprs.util.ExtJSReturn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewerAssignmentController {

    private final ReviewerAssignmentService assignmentService;
    private final ReviewerRepository reviewerRepository;
    private final StudentRepository studentRepository;

    public ReviewerAssignmentController(ReviewerAssignmentService assignmentService,
                                        ReviewerRepository reviewerRepository,
                                        StudentRepository studentRepository) {
        this.assignmentService = assignmentService;
        this.reviewerRepository = reviewerRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/reviewer/view.action")
    public Map<String, ?> listReviewers() {
        List<Reviewer> reviewers = reviewerRepository.findAll();
        return ExtJSReturn.mapOK(reviewers, reviewers.size());
    }

    @RequestMapping("/student/view.action")
    public Map<String, ?> listStudents() {
        List<Student> students = studentRepository.findAll();
        return ExtJSReturn.mapOK(students, students.size());
    }

    @RequestMapping("/assignment/view.action")
    public Map<String, ?> listAssignments() {
        List<StudentReviewerAssignment> assignments = assignmentService.getAssignments();
        return ExtJSReturn.mapOK(assignments, assignments.size());
    }

    @PostMapping("/assignment/run.action")
    public Map<String, ?> runAssignments() {
        try {
            List<StudentReviewerAssignment> assignments = assignmentService.runAssignmentRules();
            return ExtJSReturn.mapOK(assignments, assignments.size());
        } catch (Exception ex) {
            return ExtJSReturn.mapError("Error running Drools reviewer assignment rules.");
        }
    }

    @RequestMapping("/reviewer/assignments.action")
    public Map<String, ?> assignmentsByReviewer(@RequestParam Long reviewerId) {
        if (reviewerId == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", "reviewerId is required");
            return error;
        }
        List<StudentReviewerAssignment> assignments = assignmentService.getAssignmentsForReviewer(reviewerId);
        return ExtJSReturn.mapOK(assignments, assignments.size());
    }
}
