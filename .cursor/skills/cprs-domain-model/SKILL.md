---
name: cprs-domain-model
description: Maintain the Review Platform relational domain (universities, professors, students, student reviews, review assignments). Use when adding columns, entities, Flyway migrations, or relating new concepts to legacy CPRS AcademicInstitution.
---

# CPRS Domain Model

## Canonical entities

| Entity | Table | Legacy analogue |
|---|---|---|
| University | `university` | `ACADEMIC_INSTITUTION` |
| Professor | `professor` | (new) |
| Student | `student` | (new) |
| StudentReview | `student_review` | (new) |
| ReviewAssignment | `review_assignment` | (new; Drools output) |

## Rules

1. Every mutable business table has: `deleted`, `created_at`, `updated_at`, `created_by`, `updated_by`, `version`.
2. Schema changes **only** via Flyway: `db/migration/V{n}__{desc}.sql`.
3. FK deletes are restricted; soft-delete parents instead of cascading hard deletes.
4. Naming: snake_case columns, singular table names.
5. Enums stored as VARCHAR strings (`JUNIOR`, `DRAFT`, …) matching Java enums.
6. When mapping from legacy CPRS, preserve semantic meaning of `AI_DELETE_FLAG` → `deleted` and institution name → `university.name`.

## Adding a field

1. Flyway migration
2. JPA entity field + column
3. DTO / request validation updates
4. Angular model + form if user-facing
5. If used by Drools matching, copy into the fact class and document scoring impact

## Do not

- Reintroduce ExtJS `mapOK` / `mapError` response envelopes.
- Put Drools scoring fields on `StudentReview` — use `review_assignment` instead.
