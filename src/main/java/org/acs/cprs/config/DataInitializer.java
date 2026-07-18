package org.acs.cprs.config;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.acs.cprs.model.AcademicInstitution;
import org.acs.cprs.model.Contact;
import org.acs.cprs.model.Reviewer;
import org.acs.cprs.model.Student;
import org.acs.cprs.repository.AcademicInstitutionRepository;
import org.acs.cprs.repository.ContactRepository;
import org.acs.cprs.repository.ReviewerRepository;
import org.acs.cprs.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AcademicInstitutionRepository academicInstitutionRepository;
    private final ContactRepository contactRepository;
    private final ReviewerRepository reviewerRepository;
    private final StudentRepository studentRepository;

    public DataInitializer(AcademicInstitutionRepository academicInstitutionRepository,
                           ContactRepository contactRepository,
                           ReviewerRepository reviewerRepository,
                           StudentRepository studentRepository) {
        this.academicInstitutionRepository = academicInstitutionRepository;
        this.contactRepository = contactRepository;
        this.reviewerRepository = reviewerRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (academicInstitutionRepository.count() == 0) {
            seedAcademicInstitutions();
        }
        if (contactRepository.count() == 0) {
            seedContacts();
        }
        if (reviewerRepository.count() == 0) {
            seedReviewers();
        }
        if (studentRepository.count() == 0) {
            seedStudents();
        }
    }

    private void seedReviewers() {
        reviewerRepository.saveAll(List.of(
                reviewer("Ruma Banerjee", "1112223456", "RBanerjee@abc.com", "denver", "chemistry", 3, "1,2,3"),
                reviewer("Robert A Copeland", "1112223456", "Copeland@abc.com", "denver", "biology", 4, "1,2"),
                reviewer("Ron W Darbeau", "1112223456", "Darbeau@abc.com", "denver", "chemistry", 2, "3,4"),
                reviewer("Ron C Estler", "1112223456", "Estler@abc.com", "maine", "biology", 3, "5,6"),
                reviewer("Joseph S Francisco", "1112223456", "Francisco@abc.com", "maine", "chemistry", 2, "5"),
                reviewer("Cornelia D Gilyard", "1112223456", "Gilyard@abc.com", "denver", "physics", 5, "1,2,3,4")
        ));
    }

    private void seedStudents() {
        studentRepository.saveAll(List.of(
                student("Alex Carter", "Benton/Franklin Center", "1", "denver", "chemistry", "2011", "July-Denver"),
                student("Bailey Nguyen", "Bancroft Elementary School", "2", "denver", "biology", "2011", "July-Denver"),
                student("Casey Morgan", "Kanford High School", "3", "denver", "chemistry", "2011", "July-Denver"),
                student("Drew Patel", "Kamlakin High School", "4", "denver", "physics", "2011", "July-Denver"),
                student("Emery Brooks", "Brookland Elementary", "6", "maine", "biology", "2011", "June-Maine"),
                student("Finley Ross", "Abilene Christian University", "13", "denver", "chemistry", "2011", "July-Denver"),
                student("Gray Taylor", "Agnes Scott College", "14", "denver", "biology", "2011", "July-Denver"),
                student("Harper Lee", "Alabama A&M University", "15", "denver", "physics", "2011", "July-Denver"),
                student("Indigo Walsh", "Brookland Elementary", "6", "maine", "chemistry", "2011", "June-Maine"),
                student("Jordan Kim", "AAATest", "7", "denver", "biology", "2011", "July-Denver")
        ));
    }

    private Reviewer reviewer(String name, String phone, String email, String region,
                              String specialty, int maxCapacity, String affiliatedSchoolIds) {
        Reviewer reviewer = new Reviewer();
        reviewer.setName(name);
        reviewer.setPhone(phone);
        reviewer.setEmail(email);
        reviewer.setRegion(region);
        reviewer.setSpecialty(specialty);
        reviewer.setMaxCapacity(maxCapacity);
        reviewer.setAffiliatedSchoolIds(affiliatedSchoolIds);
        return reviewer;
    }

    private Student student(String name, String institution, String schoolId, String region,
                            String specialty, String reviewYear, String meetingName) {
        Student student = new Student();
        student.setName(name);
        student.setInstitutionName(institution);
        student.setAffiliatedSchoolId(schoolId);
        student.setRegion(region);
        student.setSpecialty(specialty);
        student.setReviewYear(reviewYear);
        student.setMeetingName(meetingName);
        return student;
    }

    private void seedAcademicInstitutions() throws Exception {
        ClassPathResource resource = new ClassPathResource("schools.csv");
        if (!resource.exists()) {
            AcademicInstitution sample = new AcademicInstitution();
            sample.setName("Sample University");
            sample.setDeptId(1);
            sample.setNextReviewYear(new Date());
            sample.setDeleteFlag("N");
            academicInstitutionRepository.save(sample);
            return;
        }

        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String[] row;
            boolean header = true;
            while ((row = reader.readNext()) != null) {
                if (header) {
                    header = false;
                    continue;
                }
                if (row.length < 2) {
                    continue;
                }
                AcademicInstitution institution = new AcademicInstitution();
                institution.setName(row[0].trim());
                institution.setDeptId(parseInt(row, 1, 0));
                institution.setDeleteFlag("N");
                academicInstitutionRepository.save(institution);
            }
        }
    }

    private void seedContacts() throws Exception {
        ClassPathResource resource = new ClassPathResource("users.csv");
        if (!resource.exists()) {
            Contact sample = new Contact();
            sample.setName("Jane Doe");
            sample.setPhone("(555) 555-0100");
            sample.setEmail("jane.doe@example.com");
            contactRepository.save(sample);
            return;
        }

        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String[] row;
            boolean header = true;
            while ((row = reader.readNext()) != null) {
                if (header) {
                    header = false;
                    continue;
                }
                if (row.length < 3) {
                    continue;
                }
                Contact contact = new Contact();
                contact.setName(row[0].trim());
                contact.setPhone(row[1].trim());
                contact.setEmail(row[2].trim());
                contactRepository.save(contact);
            }
        }
    }

    private int parseInt(String[] row, int index, int defaultValue) {
        if (index >= row.length || row[index] == null || row[index].isBlank()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(row[index].trim());
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }
}
