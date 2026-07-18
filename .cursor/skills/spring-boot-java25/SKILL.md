---
name: spring-boot-java25
description: Implement and extend the Review Platform Spring Boot 4 / Java 25 backend. Use when adding REST endpoints, JPA entities, services, configuration, Flyway migrations, or OpenAPI under apps/review-platform/backend.
---

# Spring Boot Java 25 — Review Platform

## Stack

- Spring Boot **4.x**, Java **25** (`maven.compiler.release=25`)
- Spring Web, Validation, Data JPA, Actuator
- Flyway for schema; PostgreSQL primary, H2 optional `local` profile
- Package root: `org.acs.cprs.review`

## Layout

Root `pom.xml` builds an executable **JAR** (Spring Boot 4). Sources live under:

```
apps/review-platform/backend/src/main/java/org/acs/cprs/review/
  domain/       entities only
  repository/   Spring Data interfaces
  service/      transactional use cases
  web/          controllers + request/response records
  config/       beans (CORS, OpenAPI, Drools wiring lives in drools/)
  drools/       facts + Kie services (see drools-assignment-rules skill)
```

Do not reintroduce WAR packaging, Jetty/Tomcat Maven plugins, AspectJ, Tiles, JSP, or Spring Roo.

## Conventions

1. Prefer **records** for DTOs; never expose JPA entities directly from controllers.
2. Map entities ↔ DTOs in the service layer (manual mapping is fine for v1).
3. Soft-delete: set `deleted=true`; queries must exclude deleted unless explicitly admin.
4. Use `@Transactional` on service methods that write; read-only where possible.
5. API prefix: `/api/v1`.
6. Validation via `jakarta.validation` on request records + `@Valid`.
7. Do **not** add Lombok unless the module already uses it.
8. Do **not** touch legacy Roo/ExtJS under `/workspace/src`.

## Adding an endpoint

1. Entity (+ Flyway if schema changes) — follow `cprs-domain-model` skill.
2. Repository method with clear derived query names.
3. Service method with focused responsibility.
4. Controller returning `ResponseEntity` / appropriate status codes.
5. Integration or slice test for the happy path.

## Drools calls

Assignment logic goes through `AssignmentService` → Drools session. Controllers must not create `KieSession` directly. Load `drools-assignment-rules` when changing scoring.

## Config tips

- Virtual threads: `spring.threads.virtual.enabled=true`
- CORS for Angular dev origin in `WebConfig`
- Keep secrets out of committed `application.yml`; use env vars / profiles
