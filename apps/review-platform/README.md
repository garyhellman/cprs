# Review Platform

Spring Boot 4 (Java 25) + Angular + Drools 10 app for universities, professors, students, student reviews, and rule-based review assignments.

Plans and Cursor skills live at the repo root:

- `docs/plans/` — architecture, data model, Drools rules, roadmap
- `.cursor/skills/` — agent skills for this stack

## Run backend

The runnable Spring Boot 4 jar is defined by the **repo-root** `pom.xml` (not a WAR).

```bash
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64   # or your JDK 25
cd ../..   # repo root
mvn spring-boot:run
# or: mvn -q package && java -jar target/cprs-0.1.0-SNAPSHOT.jar
```

API: `http://localhost:8080/api/v1`  
Default profile uses in-memory H2. Use `--spring.profiles.active=postgres` for PostgreSQL.

## Run frontend

```bash
cd apps/review-platform/frontend
npm start
```

UI: `http://localhost:4200` (proxies `/api` → `:8080`)

## Quick smoke flow

1. Create a university
2. Create professors (vary department / seniority / capacity)
3. Create a student with matching department/interests
4. Open **Assignments** → Suggest → Accept
5. Optionally create a review for that pair

## Drools starter rules

See `docs/plans/03-drools-assignment-rules.md` and `backend/src/main/resources/rules/assignment-rules.drl`.
