# Implementation Roadmap

Phased delivery. Prefer vertical slices over big-bang UI.

## Phase 0 — Foundation (this PR)

- [x] Project plan docs under `docs/plans/`
- [x] Cursor skills + rules for the stack
- [x] Spring Boot scaffold with entities, Flyway, REST stubs
- [x] Drools starter DRL + assignment endpoint
- [x] Angular shell with feature folders and API services

## Phase 1 — Core CRUD

1. University CRUD (API + Angular list/form)
2. Professor CRUD scoped by university
3. Student CRUD scoped by university
4. Student review create/list with rating validation
5. Seed data / demo script

## Phase 2 — Assignment engine

1. Stabilize Drools scoring with unit tests per rule
2. `POST /assignments/suggest` wired to UI wizard
3. Accept/reject suggestions → `review_assignment` rows
4. Completing an assignment opens a draft `student_review`

## Phase 3 — Hardening

1. AuthN/AuthZ (Spring Security + JWT or session)
2. PostgreSQL in Docker Compose; drop H2 for shared envs
3. OpenAPI-driven Angular client generation (optional)
4. Observability (Actuator + structured logs)
5. Rule threshold configuration without redeploy (later)

## Phase 4 — Legacy bridge (optional)

1. Map legacy `ACADEMIC_INSTITUTION` → `university` migration job
2. Retire ExtJS modules incrementally
3. Keep Roo WAR frozen until cutover

## Definition of done (v1 slice)

- Student can be assigned to eligible professors via Drools suggestions
- At least one review can be created from an accepted assignment
- Skills document how agents should extend rules and entities
- Backend tests cover rule gates + one happy-path scoring case
