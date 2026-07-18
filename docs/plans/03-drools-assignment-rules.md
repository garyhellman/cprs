# Drools Assignment Rules (Starter Set)

**Goal:** Given a student who needs to create a review, score and filter candidate professors.

Rules will be refined later; this document defines the first working set shipped in
`apps/review-platform/backend/src/main/resources/rules/assignment-rules.drl`.

## Facts

| Fact | Role |
|---|---|
| `AssignmentRequest` | Student + university + optional department/interests + maxResults |
| `ProfessorCandidate` | One professor in the same university pool |
| `ExistingReviewLink` | Prior student↔professor review (conflict detection) |
| `AssignmentSuggestion` | Output written/updated by rules (professorId, score, reasons) |

## Starter rules

| # | Rule name | Salience | Logic | Effect |
|---|---|---|---|---|
| 1 | `SameUniversityRequired` | 100 | Candidate university ≠ student university | Retract candidate / mark ineligible |
| 2 | `DepartmentMatchBonus` | 50 | Same department | +30 score |
| 3 | `InterestOverlapBonus` | 45 | Shared research area / interest token | +20 per overlap (cap +40) |
| 4 | `WorkloadCapacityGate` | 90 | `activeReviewCount >= maxActiveReviews` | Mark ineligible |
| 5 | `LowWorkloadBonus` | 40 | More remaining capacity | + up to 25 based on free slots |
| 6 | `SeniorityForUpperYears` | 35 | Student year ≥ 4 and professor SENIOR/TENURED | +15 |
| 7 | `RecentReviewConflict` | 95 | Existing review between same pair within lookback | Mark ineligible |
| 8 | `JuniorProfessorForLowerYears` | 30 | Student year ≤ 2 and professor JUNIOR | +10 |

## Scoring model (v1)

- Start each eligible candidate at **score = 0**.
- Gates (rules 1, 4, 7) set `eligible = false` (never returned as suggestions).
- Bonuses accumulate; final list sorted by score descending, truncated to `maxResults`.

## Rule refinement workflow

1. Add/adjust DRL in `resources/rules/`.
2. Cover with unit tests using a real `KieSession` (no Spring needed).
3. Capture `rule_trace` on `ReviewAssignment` when persisting.
4. Later: externalize thresholds via system properties or a `RuleConfig` fact.

## Example scenario

Student: CS dept, year 3, interests `ai,ml`, university U1  
Professors at U1:

- A: CS, TENURED, areas `ai`, load 1/5 → high score (dept + interest + capacity)
- B: Math, SENIOR, areas `stats`, load 0/5 → lower (no dept match)
- C: CS, JUNIOR, areas `ai`, load 5/5 → ineligible (capacity)

Drools returns A then B.
