# Data Model

PostgreSQL tables for the review platform. Flyway scripts live in `apps/review-platform/backend/src/main/resources/db/migration`.

## ER diagram

```
UNIVERSITY 1───* PROFESSOR
UNIVERSITY 1───* STUDENT
STUDENT    1───* STUDENT_REVIEW
PROFESSOR  1───* STUDENT_REVIEW   (subject of the review)
STUDENT    1───* REVIEW_ASSIGNMENT
PROFESSOR  1───* REVIEW_ASSIGNMENT
```

## Tables

### `university`

| Column | Type | Notes |
|---|---|---|
| id | BIGSERIAL PK | |
| name | VARCHAR(255) NOT NULL | Unique |
| code | VARCHAR(32) | Short code, unique when present |
| country | VARCHAR(64) | |
| deleted | BOOLEAN NOT NULL DEFAULT FALSE | Soft delete |
| created_at / updated_at | TIMESTAMPTZ | |
| created_by / updated_by | VARCHAR(128) | |
| version | INT NOT NULL | Optimistic lock |

Maps conceptually from legacy `ACADEMIC_INSTITUTION` (`AI_NAME`, `AI_DELETE_FLAG`, `AI_NEXT_REVIEW_YEAR`).

### `professor`

| Column | Type | Notes |
|---|---|---|
| id | BIGSERIAL PK | |
| university_id | BIGINT FK → university | Required |
| first_name / last_name | VARCHAR(128) | |
| email | VARCHAR(255) UNIQUE | |
| department | VARCHAR(128) | Used by Drools matching |
| research_areas | VARCHAR(512) | Comma-separated or JSON later |
| seniority | VARCHAR(32) | JUNIOR / SENIOR / TENURED |
| max_active_reviews | INT DEFAULT 5 | Workload cap |
| active_review_count | INT DEFAULT 0 | Denormalized for rules |
| deleted | BOOLEAN | Soft delete |
| audit + version | | Same pattern as university |

### `student`

| Column | Type | Notes |
|---|---|---|
| id | BIGSERIAL PK | |
| university_id | BIGINT FK → university | Required |
| first_name / last_name | VARCHAR(128) | |
| email | VARCHAR(255) UNIQUE | |
| department | VARCHAR(128) | Preferred match field |
| year_level | INT | 1–6 / grad band |
| interests | VARCHAR(512) | Topic tags for matching |
| deleted | BOOLEAN | |
| audit + version | | |

### `student_review`

| Column | Type | Notes |
|---|---|---|
| id | BIGSERIAL PK | |
| student_id | BIGINT FK → student | Reviewer |
| professor_id | BIGINT FK → professor | Subject |
| university_id | BIGINT FK → university | Denormalized for filters |
| title | VARCHAR(255) | |
| body | TEXT | |
| rating | SMALLINT | 1–5 |
| status | VARCHAR(32) | DRAFT / SUBMITTED / PUBLISHED |
| submitted_at | TIMESTAMPTZ | |
| deleted | BOOLEAN | |
| audit + version | | |

Unique partial idea (enforce in service for v1): one active review per (student, professor) unless status is DRAFT superseded.

### `review_assignment`

| Column | Type | Notes |
|---|---|---|
| id | BIGSERIAL PK | |
| student_id | BIGINT FK | Who will write the review |
| professor_id | BIGINT FK | Who they are assigned to review |
| university_id | BIGINT FK | |
| status | VARCHAR(32) | SUGGESTED / ACCEPTED / REJECTED / COMPLETED |
| score | DECIMAL(8,2) | Drools ranking score |
| rule_trace | TEXT | Which rules fired (debug aid) |
| reason | VARCHAR(512) | Human-readable summary |
| created_at | TIMESTAMPTZ | |
| version | INT | |

## Indexes

- `professor(university_id, department)`
- `student(university_id, department)`
- `student_review(student_id)`, `student_review(professor_id)`
- `review_assignment(student_id, status)`

## Soft-delete convention

All list endpoints filter `deleted = false` by default. Hard deletes are admin-only and out of scope for v1.
