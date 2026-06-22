# 485 — Max Consecutive Ones

## Summary

Given a binary array, return the maximum number of consecutive `1`s in any contiguous segment.

## Complexity

| | |
|---|---|
| **Time** | O(n) — single scan |
| **Space** | O(1) — running `counter` and `max` only |

## Pattern

**Single-pass running counter** — variant of sliding window (window resets on `0`).

- On `1`: extend current streak, update global max.
- On `0`: reset streak to 0.
- Invariant: `counter` is the length of the streak ending at index `i`.

Also related to [`templates/two-pointers/EXPLANATION.md`](../../templates/two-pointers/EXPLANATION.md) (dynamic window that shrinks on violation).

## SDET Review

### Correctness

- Empty array: loop skipped, returns `max == 0` — correct.
- All-zeros: `max` stays 0 — correct.
- Streak at end of array: final `max` already captured — no trailing pass needed.

### Efficiency

- Optimal O(n) time, O(1) space — every element examined once.
- Manual `if (max < counter)` update avoids relying on `Math.max` — fine for interview-style code.

### Readability & modularity

- Classic interview pattern — easy to narrate: “running count, reset on break.”
- **Improvement:** Rename `counter` → `currentStreak` for SDET-style self-documenting code.
- **Improvement:** For reusable test utilities, extract `maxConsecutiveMatch(nums, targetValue)` generic helper.

### Production / automation analogy

**Flaky-test streak detection:** Scan a nightly pass/fail timeline (`1` = pass, `0` = fail) to find the longest consecutive pass streak — identical loop structure for SLA / stability reporting.

## Key learnings

- Binary array “longest run” problems almost always use a running counter + reset.
- Sliding window and single-pass counter are equivalent here; pick the vocabulary that matches your template library.

## Status

✅ Complete — local tests passing.
