---
name: drools-assignment-rules
description: Author and test Drools 10 rules that assign students to professors for reviews. Use when editing DRL files, assignment facts, KieContainer config, scoring, or assignment suggest/persist APIs.
---

# Drools Assignment Rules

## Stack

- Drools **10.x** via `drools-bom`
- Classpath `KieContainer` (no kie-spring Boot starter)
- Rules: `apps/review-platform/backend/src/main/resources/rules/*.drl`
- Facts: `org.acs.cprs.review.drools.facts`

## Pattern

```
AssignmentService
  → build AssignmentRequest + ProfessorCandidate[] + ExistingReviewLink[]
  → KieSession.insert(...)
  → fireAllRules()
  → collect AssignmentSuggestion (eligible only)
  → sort by score desc, limit maxResults
```

Always `kieSession.dispose()` in `finally`.

## When adding a rule

1. Document it in `docs/plans/03-drools-assignment-rules.md`.
2. Prefer **gates** (ineligible) for hard constraints; **bonuses** for soft preferences.
3. Append a short reason string onto `AssignmentSuggestion.reasons` for UI/debug.
4. Set salience intentionally (gates high, bonuses mid/low).
5. Add a focused unit test that inserts minimal facts and asserts eligibility/score.

## Same-university avoidance

`AvoidSameUniversity` marks candidates ineligible when `professor.universityId == student.universityId`.
Do not reintroduce a same-university *requirement*. Accept/create APIs should also reject same-school pairs.

## Equal load

`EqualizeStudentReviewLoad` uses `WorkloadBalanceStats` (built in `AssignmentRulesEngine`)
to boost professors with fewer `activeReviewCount` values so student-review assignments
stay roughly even across the peer set. Keep this rule when changing scoring weights.

## Fact guidelines

- Keep Drools facts **decoupled** from JPA entities (copy fields into facts).
- Mutable score/eligible fields on `AssignmentSuggestion` or `ProfessorCandidate` are OK.
- Avoid calling repositories from DRL consequences.

## Testing

- Pure JUnit test with `KieServices.Factory.get()` classpath container.
- No Spring context required for rule unit tests.
- Cover: same-university gate, capacity gate, recent-review conflict, one bonus path.

## Refinement later

Thresholds (bonus points, lookback days) should move onto a `RuleConfig` fact rather than magic numbers scattered in DRL — do this when a second environment needs different weights.
