---
name: angular-review-ui
description: Implement Angular SPA features for the Review Platform. Use when building or changing UI under apps/review-platform/frontend for universities, professors, students, reviews, or Drools-backed assignments.
---

# Angular Review UI

## Stack

- Angular **20** (standalone components) under `apps/review-platform/frontend`
- Feature folders under `src/app/features/`
- Typed HTTP services in `core` or feature `data` folders
- Production: Maven packages the SPA into the Boot JAR (`classpath:/static`); open `http://localhost:8080/`
- Dev proxy: `npm start` → Angular on `:4200` proxies `/api` to Boot `:8080`
- Do **not** revive ExtJS under `src/main/webapp`

## Layout

```
frontend/src/app/
  core/           api base, models, interceptors
  shared/         reusable presentational pieces
  features/
    universities/
    professors/
    students/
    reviews/
    assignments/  suggest + accept flows
```

## Conventions

1. One feature folder = routes + pages + feature service.
2. Prefer signals for local UI state; keep server state in services.
3. Do not invent a design system of cards/stat strips for admin CRUD — keep lists and forms clear and sparse.
4. Match API DTOs as TypeScript interfaces in `core/models` (or feature models).
5. All API calls go through Angular `HttpClient` services — no raw `fetch` in components.
6. Forms: reactive forms with validators mirroring backend constraints.
7. Empty/loading/error states on every list page.

## Assignment wizard (Drools)

1. Select student → call `POST /api/v1/assignments/suggest`.
2. Show ranked professors with score + reason list.
3. User accepts → `POST /api/v1/assignments`.
4. Optionally navigate to create review draft.

## Do not

- Bundle ExtJS or copy legacy CPRS UI patterns.
- Hardcode API host in components (use environment + proxy).
