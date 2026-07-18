# Architecture

## System context

```
┌─────────────┐     HTTPS/JSON      ┌──────────────────────────┐
│  Angular SPA│ ──────────────────► │  Spring Boot 4 API       │
│  (frontend) │ ◄────────────────── │  /api/v1/...             │
└─────────────┘                     │                          │
                                    │  ┌────────────────────┐  │
                                    │  │ AssignmentService  │  │
                                    │  │   + Drools KieSession│ │
                                    │  └─────────┬──────────┘  │
                                    │            │             │
                                    │  ┌─────────▼──────────┐  │
                                    │  │ JPA / Flyway       │  │
                                    │  │ PostgreSQL         │  │
                                    │  └────────────────────┘  │
                                    └──────────────────────────┘
```

## Backend packages (`org.acs.cprs.review`)

| Package | Responsibility |
|---|---|
| `domain` | JPA entities: University, Professor, Student, StudentReview, ReviewAssignment |
| `repository` | Spring Data JPA repositories |
| `service` | Application services / use cases |
| `web` | REST controllers + DTOs |
| `drools.facts` | Facts inserted into the session (not necessarily JPA entities) |
| `drools.service` | `KieContainer` wiring + fire rules |
| `config` | CORS, OpenAPI, Drools beans |

## API surface (v1)

| Method | Path | Purpose |
|---|---|---|
| GET/POST | `/api/v1/universities` | List / create |
| GET/PUT/DELETE | `/api/v1/universities/{id}` | Read / update / soft-delete |
| GET/POST | `/api/v1/professors` | List / create (filter by university) |
| GET/POST | `/api/v1/students` | List / create (filter by university) |
| GET/POST | `/api/v1/reviews` | List / create reviews |
| POST | `/api/v1/assignments/suggest` | Run Drools; return ranked professor candidates |
| POST | `/api/v1/assignments` | Persist chosen assignment(s) |

## Drools integration pattern

There is **no official Drools 10 Spring Boot starter**. Wire manually:

1. `KieServices` → classpath `KieContainer` from `rules/*.drl`.
2. Per request: create `KieSession`, insert facts, `fireAllRules()`, dispose.
3. Collect `AssignmentSuggestion` facts written by rules.
4. Map suggestions to API DTOs; optionally persist as `ReviewAssignment`.

Prefer **executable model** dependencies (`drools-engine`) over deprecated classic MVEL engine when possible; starter DRLs use standard DRL syntax compatible with Drools 10.

## Frontend structure

Feature-first Angular layout:

- `features/universities|professors|students|reviews|assignments`
- `core` — HTTP interceptors, API base URL, models
- `shared` — table/form helpers

Dev proxy: Angular → `http://localhost:8080`.

## Cross-cutting

- Soft delete via `deleted` flag (mirrors legacy `delete_fl` / `AI_DELETE_FLAG`).
- Audit fields: `createdAt`, `updatedAt`, `createdBy`, `updatedBy`.
- Optimistic locking with `@Version`.
- OpenAPI (springdoc) for contract discovery.
- Virtual threads enabled when running on Java 21+.

## Compatibility notes

| Concern | Guidance |
|---|---|
| Java 25 | Target `maven.compiler.release=25` via root `pom.xml`. |
| Packaging | Executable **JAR** via `spring-boot-maven-plugin` — not WAR/Jetty/Tomcat plugins. |
| Drools 10 | Use `drools-bom` 10.x; avoid old `kie-spring` Boot autoconfig. |
| Angular | Latest stable Angular with standalone components + signals where natural. |
| Legacy CPRS | Root pom no longer compiles Roo/ExtJS under `src/`; leave that tree untouched unless migrating. |
