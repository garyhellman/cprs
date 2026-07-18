package org.acs.cprs.review.service;

import org.acs.cprs.review.domain.Student;
import org.acs.cprs.review.domain.University;
import org.acs.cprs.review.repository.StudentRepository;
import org.acs.cprs.review.web.dto.ApiDtos.StudentRequest;
import org.acs.cprs.review.web.dto.ApiDtos.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UniversityService universityService;

    public StudentService(StudentRepository studentRepository, UniversityService universityService) {
        this.studentRepository = studentRepository;
        this.universityService = universityService;
    }

    @Transactional(readOnly = true)
    public List<StudentResponse> list(Long universityId) {
        List<Student> students = universityId == null
                ? studentRepository.findByDeletedFalseOrderByLastNameAsc()
                : studentRepository.findByUniversityIdAndDeletedFalseOrderByLastNameAsc(universityId);
        return students.stream().map(this::toResponse).toList();
    }

    @Transactional
    public StudentResponse create(StudentRequest request) {
        University university = universityService.require(request.universityId());
        Student student = new Student();
        student.setUniversity(university);
        student.setFirstName(request.firstName().trim());
        student.setLastName(request.lastName().trim());
        student.setEmail(request.email().trim().toLowerCase());
        student.setDepartment(blankToNull(request.department()));
        student.setYearLevel(request.yearLevel());
        student.setInterests(blankToNull(request.interests()));
        student.setCreatedBy("system");
        student.setUpdatedBy("system");
        return toResponse(studentRepository.save(student));
    }

    @Transactional(readOnly = true)
    public Student require(Long id) {
        return studentRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    private StudentResponse toResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getUniversity().getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDepartment(),
                student.getYearLevel(),
                student.getInterests()
        );
    }

    private static String blankToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value.trim();
    }
}
