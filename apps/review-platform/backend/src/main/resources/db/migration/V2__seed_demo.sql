INSERT INTO university (name, code, country, deleted, created_by, updated_by, version)
VALUES ('Cascadia State University', 'CSU', 'US', FALSE, 'seed', 'seed', 0);

INSERT INTO professor (
    university_id, first_name, last_name, email, department, research_areas,
    seniority, max_active_reviews, active_review_count, deleted, created_by, updated_by, version
) VALUES
((SELECT id FROM university WHERE code = 'CSU'), 'Ada', 'Lovelace', 'ada@csu.edu', 'CS', 'ai,systems',
 'TENURED', 5, 1, FALSE, 'seed', 'seed', 0),
((SELECT id FROM university WHERE code = 'CSU'), 'Grace', 'Hopper', 'grace@csu.edu', 'CS', 'compilers',
 'SENIOR', 5, 0, FALSE, 'seed', 'seed', 0),
((SELECT id FROM university WHERE code = 'CSU'), 'Alan', 'Turing', 'alan@csu.edu', 'Math', 'stats,logic',
 'SENIOR', 5, 0, FALSE, 'seed', 'seed', 0),
((SELECT id FROM university WHERE code = 'CSU'), 'Barbara', 'Liskov', 'barbara@csu.edu', 'CS', 'ai',
 'JUNIOR', 5, 5, FALSE, 'seed', 'seed', 0);

INSERT INTO student (
    university_id, first_name, last_name, email, department, year_level, interests,
    deleted, created_by, updated_by, version
) VALUES
((SELECT id FROM university WHERE code = 'CSU'), 'Sam', 'Rivera', 'sam@csu.edu', 'CS', 3, 'ai,ml',
 FALSE, 'seed', 'seed', 0);
