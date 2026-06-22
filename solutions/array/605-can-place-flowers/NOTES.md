# 605 — Can Place Flowers

## Summary

Determine whether `n` new flowers can be planted in a flowerbed (represented as 0/1) without violating the no-adjacent-flowers rule.

## Complexity

| | |
|---|---|
| **Time** | O(n) — single left-to-right scan |
| **Space** | O(1) — mutates input in place (acceptable per problem; copy first if immutability matters in tests) |

## Pattern

**Greedy (local decision)** — see [`templates/greedy/EXPLANATION.md`](../../templates/greedy/EXPLANATION.md).

Plant whenever a plot and both neighbors are empty; mark planted immediately so later indices see updated state.

## SDET Review

### Correctness

- Early return when `n == 0` is correct and avoids unnecessary work.
- Boundary checks (`i == 0`, `i == length - 1`) correctly model "no neighbor outside bed."
- **Side effect:** Method mutates `flowerbed`. Tests pass fresh arrays each call — good. In a shared test fixture, clone the array before invoking.

### Efficiency

- O(n) with early exit when `n` reaches 0 — optimal for this greedy strategy.
- Alternative O(n) without mutation: treat out-of-bounds as empty without writing `1`s — useful when input must remain immutable (production config snapshots).

### Readability & modularity

- `emptyLeft` / `emptyRight` booleans mirror the problem statement — excellent for interview narration.
- Comments explain intent without restating syntax — production-appropriate level.
- **Improvement:** Extract `canPlantAt(flowerbed, i)` private helper if this logic is reused across multiple "spacing constraint" validators.

### Production / automation analogy

**Resource slot allocation:** Scheduling parallel test workers on a grid where adjacent slots cannot both run GPU-heavy jobs — greedy left-to-right placement with immediate reservation matches this pattern.

## Key learnings

- Greedy works when planting at the earliest valid slot never blocks a better future arrangement.
- Mutating input simplifies state tracking but must be documented in API contracts.

## Status

✅ Complete — local tests passing.
