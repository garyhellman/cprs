# Review Platform — Project Overview

Modern replacement path for the legacy CPRS ExtJS / Spring Roo admin app (`org.acs.cprs`), rebuilt as:

| Layer | Choice | Why |
|---|---|---|
| Backend | **Spring Boot 4 + Java 25** | First-class Java 25 support, virtual threads, modular autoconfigure |
| Rules | **Drools 10** (classic KIE classpath container) | Assign students → professors for review creation; rules stay declarative and evolvable |
| Frontend | **Angular** (standalone components) | Strong typing, routing, forms; clean REST client over the Boot API |
| Database | **PostgreSQL** + Flyway | Relational model for universities / professors / students / reviews |
| Local DB (dev) | **H2** (optional profile) | Fast bootstrap without Docker |

## Goals

1. CRUD and list views for universities, professors, students, and student reviews.
2. Drools-driven **assignment** of a student to one or more professors when creating a review task.
3. Keep the legacy codebase untouched under `src/` while the new app lives in `apps/review-platform/`.
4. Provide Cursor **skills** and **rules** so future agents implement consistently.

## Non-goals (for v1)

- Auth / SSO (stub roles only).
- Migrating ExtJS screens 1:1.
- Full production Drools rule governance UI.
- Real-time notifications.

## Repo layout

```
pom.xml             Spring Boot 4 executable JAR (Java 25 + Drools 10)
apps/review-platform/
  backend/src/      Spring Boot API + Drools sources (built by root pom)
  frontend/         Angular SPA
docs/plans/         Architecture and roadmap
.cursor/skills/     Agent skills for this stack
.cursor/rules/      Always-on coding conventions
```

## Related docs

- [Architecture](01-architecture.md)
- [Data model](02-data-model.md)
- [Drools assignment rules](03-drools-assignment-rules.md)
- [Implementation roadmap](04-implementation-roadmap.md)
- [Cursor skills guide](05-cursor-skills-guide.md)
