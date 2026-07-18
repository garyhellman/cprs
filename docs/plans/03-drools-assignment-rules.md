# Drools Assignment Rules (Starter Set)

**Goal:** Given a student who needs to create a review, score and filter candidate professors.

Rules will be refined later; this document defines the first working set shipped in
`apps/review-platform/backend/src/main/resources/rules/assignment-rules.drl`.

## Facts

| Fact | Role |
|---|---|
| `AssignmentRequest` | Student + university + optional department/interests + maxResults |
| `ProfessorCandidate` | One professor candidate (typically other universities) |
| `ExistingReviewLink` | Prior student↔professor review (conflict detection) |
| `WorkloadBalanceStats` | Min/max `activeReviewCount` among peers with capacity |
| `AssignmentSuggestion` | Output written/updated by rules (professorId, score, reasons) |

## Starter rules

| # | Rule name | Salience | Logic | Effect |
|---|---|---|---|---|
| 1 | `AvoidSameUniversity` | 100 | Candidate university == student university | Mark ineligible (external review) |
| 2 | `RecentReviewConflict` | 95 | Existing review between same pair within lookback | Mark ineligible |
| 3 | `WorkloadCapacityGate` | 90 | `activeReviewCount >= maxActiveReviews` | Mark ineligible |
| 4 | `EqualizeStudentReviewLoad` | 60 | Prefer professors below peer max load | `+(max - active) * 20` so loads stay even |
| 5 | `DepartmentMatchBonus` | 50 | Same department | +30 score |
| 6 | `InterestOverlapBonus` | 45 | Shared research area / interest token | +20 per overlap (cap +40) |
| 7 | `LowWorkloadBonus` | 40 | More remaining capacity | + up to 25 based on free slots |
| 8 | `SeniorityForUpperYears` | 35 | Student year ≥ 4 and professor SENIOR/TENURED | +15 |
| 9 | `JuniorProfessorForLowerYears` | 30 | Student year ≤ 2 and professor JUNIOR | +10 |

## Same-university avoidance

`AvoidSameUniversity` is a hard gate: a student must not be assigned to review a
professor from their own university. The assignment service pools all professors;
this rule (and accept/create validation) keep suggestions external-only.

## Equal load rule

`EqualizeStudentReviewLoad` pushes assignments toward an **equal number of students
per professor**. Before rules fire, the engine inserts `WorkloadBalanceStats` with the
min/max `activeReviewCount` among professors who still have capacity. Candidates with
fewer assigned students than the current peer maximum receive a large score boost
(`gap * 20`), so the next suggestion fills the lightest loads first.

## Scoring model (v1)

- Start each eligible candidate at **score = 0**.
- Gates set `eligible = false` (never returned as suggestions).
- Bonuses accumulate; final list sorted by score descending, truncated to `maxResults`.

## Rule refinement workflow

1. Add/adjust DRL in `resources/rules/`.
2. Cover with unit tests using a real `KieSession` (no Spring needed).
3. Capture `rule_trace` on `ReviewAssignment` when persisting.
4. Later: externalize thresholds via system properties or a `RuleConfig` fact.

## Example scenario

Student: CS dept, year 3, interests `ai,ml`, university U1  

- A @ U2: CS, TENURED, areas `ai`, load 1/5 → high score (dept + interest + capacity + equalize)
- B @ U2: Math, SENIOR, areas `stats`, load 0/5 → equalize helps, but no dept match
- C @ U1: CS, TENURED, areas `ai`, load 0/5 → **ineligible** (same university)
- D @ U2: CS, JUNIOR, areas `ai`, load 5/5 → ineligible (capacity)

Drools returns A then B.
