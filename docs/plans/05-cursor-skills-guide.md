# Cursor Skills Guide

This repo ships project-local skills under `.cursor/skills/`. Agents should load the matching skill before implementing work in that area.

## Available skills

| Skill | Path | Use when |
|---|---|---|
| Spring Boot / Java 25 | `.cursor/skills/spring-boot-java25/SKILL.md` | Backend packages, REST, JPA, Boot config |
| Angular review UI | `.cursor/skills/angular-review-ui/SKILL.md` | SPA features, services, forms, proxy |
| Drools assignment rules | `.cursor/skills/drools-assignment-rules/SKILL.md` | DRL changes, facts, KieSession tests |
| CPRS domain model | `.cursor/skills/cprs-domain-model/SKILL.md` | Entities, Flyway, naming, soft-delete |

## Always-on rules

`.cursor/rules/review-platform.mdc` — layout conventions, do-not-touch legacy ExtJS, API versioning.

## How to ask an agent

Good prompts:

- "Using the drools-assignment-rules skill, add a rule that penalizes professors outside the student's department by 10 points."
- "Using spring-boot-java25 and cprs-domain-model, add a `research_center` field to Professor with Flyway migration."
- "Using angular-review-ui, build the assignments suggest wizard against `/api/v1/assignments/suggest`."

## Skill maintenance

When the stack choice changes (e.g. Drools Rule Units migration, Angular SSR), update the skill file in the same PR as the code change so future agents stay aligned.
