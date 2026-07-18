package org.acs.cprs.review.config;

import net.datafaker.Faker;
import org.acs.cprs.review.domain.Professor;
import org.acs.cprs.review.domain.Seniority;
import org.acs.cprs.review.domain.Student;
import org.acs.cprs.review.domain.University;
import org.acs.cprs.review.repository.ProfessorRepository;
import org.acs.cprs.review.repository.StudentRepository;
import org.acs.cprs.review.repository.UniversityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

/**
 * Loads collections of universities, professors, and students via Datafaker
 * (maintained Java Faker API) after Flyway migrations.
 */
@Component
@Order(100)
@EnableConfigurationProperties(FakerSeedProperties.class)
public class FakerDataSeeder implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(FakerDataSeeder.class);

    private static final String[] DEPARTMENTS = {
            "CS", "Math", "Physics", "Biology", "Chemistry", "Economics", "History", "Psychology"
    };

    private static final String[] TOPICS = {
            "ai", "ml", "systems", "compilers", "security", "databases", "networks",
            "stats", "logic", "graphics", "hci", "robotics", "nlp", "vision"
    };

    private final FakerSeedProperties properties;
    private final UniversityRepository universityRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public FakerDataSeeder(
            FakerSeedProperties properties,
            UniversityRepository universityRepository,
            ProfessorRepository professorRepository,
            StudentRepository studentRepository
    ) {
        this.properties = properties;
        this.universityRepository = universityRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        if (!properties.isEnabled()) {
            log.info("Faker seed disabled (app.seed.faker.enabled=false)");
            return;
        }

        long existingUniversities = universityRepository.count();
        // Flyway V2 seeds 1 university; only generate when still at that footprint
        if (existingUniversities > 1) {
            log.info("Skipping faker seed — {} universities already present", existingUniversities);
            return;
        }

        Faker faker = new Faker(Locale.ENGLISH, new Random(properties.getSeed()));
        Set<String> usedEmails = new LinkedHashSet<>();
        Set<String> usedCodes = new LinkedHashSet<>();
        usedCodes.add("CSU"); // reserved by Flyway demo seed

        int uniCount = Math.max(0, properties.getUniversities());
        int profPerUni = Math.max(0, properties.getProfessorsPerUniversity());
        int studentPerUni = Math.max(0, properties.getStudentsPerUniversity());

        List<University> createdUniversities = new ArrayList<>();
        for (int i = 0; i < uniCount; i++) {
            University university = new University();
            university.setName(uniqueUniversityName(faker, i));
            university.setCode(uniqueCode(faker, usedCodes));
            university.setCountry(faker.address().countryCode());
            university.setCreatedBy("faker");
            university.setUpdatedBy("faker");
            createdUniversities.add(universityRepository.save(university));
        }

        int professorTotal = 0;
        int studentTotal = 0;
        for (University university : createdUniversities) {
            String domain = university.getCode().toLowerCase(Locale.ROOT) + ".edu";
            for (int p = 0; p < profPerUni; p++) {
                Professor professor = new Professor();
                professor.setUniversity(university);
                professor.setFirstName(faker.name().firstName());
                professor.setLastName(faker.name().lastName());
                professor.setEmail(uniqueEmail(faker, usedEmails, professor.getFirstName(), professor.getLastName(), domain));
                professor.setDepartment(faker.options().option(DEPARTMENTS));
                professor.setResearchAreas(joinTopics(faker, 2, 4));
                professor.setSeniority(faker.options().option(Seniority.class));
                professor.setMaxActiveReviews(faker.number().numberBetween(3, 8));
                professor.setActiveReviewCount(faker.number().numberBetween(0, professor.getMaxActiveReviews()));
                professor.setCreatedBy("faker");
                professor.setUpdatedBy("faker");
                professorRepository.save(professor);
                professorTotal++;
            }
            for (int s = 0; s < studentPerUni; s++) {
                Student student = new Student();
                student.setUniversity(university);
                student.setFirstName(faker.name().firstName());
                student.setLastName(faker.name().lastName());
                student.setEmail(uniqueEmail(faker, usedEmails, student.getFirstName(), student.getLastName(), domain));
                student.setDepartment(faker.options().option(DEPARTMENTS));
                student.setYearLevel(faker.number().numberBetween(1, 6));
                student.setInterests(joinTopics(faker, 1, 3));
                student.setCreatedBy("faker");
                student.setUpdatedBy("faker");
                studentRepository.save(student);
                studentTotal++;
            }
        }

        log.info(
                "Faker seed complete: {} universities, {} professors, {} students (seed={})",
                createdUniversities.size(),
                professorTotal,
                studentTotal,
                properties.getSeed()
        );
    }

    private static String uniqueUniversityName(Faker faker, int index) {
        String base = faker.university().name();
        if (base == null || base.isBlank()) {
            base = faker.educator().university();
        }
        return base + " #" + (index + 1);
    }

    private static String uniqueCode(Faker faker, Set<String> used) {
        for (int attempt = 0; attempt < 50; attempt++) {
            String code = faker.letterify("???", true) + faker.number().digits(2);
            code = code.toUpperCase(Locale.ROOT);
            if (used.add(code)) {
                return code;
            }
        }
        String fallback = "U" + used.size() + faker.number().digits(4);
        used.add(fallback);
        return fallback;
    }

    private static String uniqueEmail(
            Faker faker,
            Set<String> used,
            String firstName,
            String lastName,
            String domain
    ) {
        String local = (sanitize(firstName) + "." + sanitize(lastName)).toLowerCase(Locale.ROOT);
        for (int n = 0; n < 100; n++) {
            String email = n == 0
                    ? local + "@" + domain
                    : local + n + "@" + domain;
            if (used.add(email)) {
                return email;
            }
        }
        String email = local + "." + faker.number().digits(6) + "@" + domain;
        used.add(email);
        return email;
    }

    private static String sanitize(String value) {
        return value == null ? "user" : value.replaceAll("[^A-Za-z0-9]", "");
    }

    private static String joinTopics(Faker faker, int min, int max) {
        int count = faker.number().numberBetween(min, max + 1);
        Set<String> picked = new LinkedHashSet<>();
        while (picked.size() < count) {
            picked.add(faker.options().option(TOPICS));
        }
        return String.join(",", picked);
    }
}
