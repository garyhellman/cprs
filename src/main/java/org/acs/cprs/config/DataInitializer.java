package org.acs.cprs.config;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.acs.cprs.model.AcademicInstitution;
import org.acs.cprs.model.Contact;
import org.acs.cprs.repository.AcademicInstitutionRepository;
import org.acs.cprs.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AcademicInstitutionRepository academicInstitutionRepository;
    private final ContactRepository contactRepository;

    public DataInitializer(AcademicInstitutionRepository academicInstitutionRepository,
                           ContactRepository contactRepository) {
        this.academicInstitutionRepository = academicInstitutionRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (academicInstitutionRepository.count() == 0) {
            seedAcademicInstitutions();
        }
        if (contactRepository.count() == 0) {
            seedContacts();
        }
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
