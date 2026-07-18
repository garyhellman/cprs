# Review Platform

Spring Boot 4 (Java 25) + **Angular 20** + Drools 10 app for universities, professors,
students, student reviews, and rule-based review assignments.

Plans and Cursor skills live at the repo root:

- `docs/plans/` — architecture, data model, Drools rules, roadmap
- `.cursor/skills/` — agent skills for this stack

> The ExtJS UI under `src/main/webapp` is **legacy and not served**. See `src/main/webapp/LEGACY.md`.

## Run (API + Angular together)

From the **repo root**, Maven builds Angular into the Boot JAR and serves it at `/`:

```bash
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64   # or your JDK 25
mvn spring-boot:run
```

Open **http://localhost:8080/** — Angular SPA  
API: **http://localhost:8080/api/v1**

Skip the frontend build (API-only / faster tests):

```bash
mvn -DskipFrontend=true test
mvn -DskipFrontend=true spring-boot:run
```

Default profile uses in-memory H2. Use `--spring.profiles.active=postgres` for PostgreSQL.

## Frontend-only (hot reload)

```bash
# terminal 1 — API
mvn -DskipFrontend=true spring-boot:run

# terminal 2 — Angular 20 with proxy to :8080
cd apps/review-platform/frontend
npm start
```

Then open http://localhost:4200/

## Demo data (Java Faker / Datafaker)

On startup (default H2 profile), Datafaker loads collections in addition to the Flyway demo row:

| Entity | Default count |
|---|---|
| Universities | 8 (+ Cascadia State from Flyway) |
| Professors | 10 per generated university |
| Students | 25 per generated university |

Configure in `application.yml` under `app.seed.faker` (`enabled`, `universities`, `professors-per-university`, `students-per-university`, `seed`). Disabled on the `postgres` profile by default.

## Quick smoke flow

1. Open http://localhost:8080/assignments
2. Pick a student (faker-generated or Sam Rivera from the Flyway demo)
3. Click **Suggest professors** → Accept a Drools-ranked assignment
4. Optionally create a review under **Reviews**

## Drools starter rules

See `docs/plans/03-drools-assignment-rules.md` and `backend/src/main/resources/rules/assignment-rules.drl`.
