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

## Quick smoke flow

1. Open http://localhost:8080/assignments
2. Seed data already includes Cascadia State University, professors, and student Sam Rivera
3. Click **Suggest professors** → Accept a Drools-ranked assignment
4. Optionally create a review under **Reviews**

## Drools starter rules

See `docs/plans/03-drools-assignment-rules.md` and `backend/src/main/resources/rules/assignment-rules.drl`.
