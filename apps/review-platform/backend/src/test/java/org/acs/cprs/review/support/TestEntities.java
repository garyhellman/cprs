package org.acs.cprs.review.support;

import org.acs.cprs.review.domain.Professor;
import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.domain.Student;
import org.acs.cprs.review.domain.University;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.repository.StudentRepository;
import org.acs.cprs.review.repository.UniversityRepository;

public final class TestEntities {

    private TestEntities() {
    }

    public static University university(UniversityRepository repo, String name, String code) {
        University university = new University();
        university.setName(name);
        university.setCode(code);
        university.setCountry("US");
        university.setCreatedBy("test");
        university.setUpdatedBy("test");
        return repo.save(university);
    }

    public static Professor professor(
            ProfessorRepository repo,
            University university,
            String first,
            String last,
            String email,
            String department,
            Seniority seniority,
            int max,
            int active
    ) {
        Professor professor = new Professor();
        professor.setUniversity(university);
        professor.setFirstName(first);
        professor.setLastName(last);
        professor.setEmail(email);
        professor.setDepartment(department);
        professor.setResearchAreas("ai,systems");
        professor.setSeniority(seniority);
        professor.setMaxActiveReviews(max);
        professor.setActiveReviewCount(active);
        professor.setCreatedBy("test");
        professor.setUpdatedBy("test");
        return repo.save(professor);
    }

    public static Student student(
            StudentRepository repo,
            University university,
            String first,
            String last,
            String email,
            String department,
            int year
    ) {
        Student student = new Student();
        student.setUniversity(university);
        student.setFirstName(first);
        student.setLastName(last);
        student.setEmail(email);
        student.setDepartment(department);
        student.setYearLevel(year);
        student.setInterests("ai,ml");
        student.setCreatedBy("test");
        student.setUpdatedBy("test");
        return repo.save(student);
    }
}
