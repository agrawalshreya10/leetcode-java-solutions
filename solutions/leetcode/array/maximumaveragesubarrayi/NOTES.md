# 643 — Maximum Average Subarray I

## Summary

Find a contiguous subarray of length exactly `k` with the maximum average, and return that average.

## Complexity

| | |
|---|---|
| **Time** | O(n) — one pass to seed, one pass to slide |
| **Space** | O(1) — running window sum + best sum |

## Pattern

**Fixed-size sliding window** — maintain the sum of the current length-`k` segment; slide by `+nums[j] - nums[j - k]`.

Max average ≡ max window sum / `k` (same `k` for every window), so track **max sum**, divide once at the end.

Template folder `templates/sliding-window/` not created yet (first problem in this family here) — will add when a second fixed/variable window lands.

## SDET Review

### Correctness

- Seeds `maxSum` from the first window (`maxSum = sum`) — correct for all-negative inputs (initializing to `0` would be wrong).
- Slide updates sum before comparing — invariant: `sum` always equals the current window.

### Efficiency

- O(n) is optimal; recomputing each window from scratch would be O(n·k).

### Readability & modularity

- Comments label seed vs slide clearly — good for interview narration.
- **Improvement (optional):** `return maxSum / k;` is enough; `Double.valueOf(...)` is redundant when the return type is already `double`.
- **Improvement (optional):** use `int n = nums.length` — length need not be `double` (loop still works either way).

### Production / automation analogy

**Rolling SLA / error-rate window:** keep the sum (or count) over the last `k` samples; each new event adds one and drops the oldest — same fixed window.

## Key learnings

- Fixed window: seed once, then O(1) per step.
- Seed best from the **first** window, not `0`, when values can be negative.
- Java: primitives (`double`) are not constructed with `new` — see [java-interview-gotchas](../../../../notes/java-interview-gotchas.md).

## Status

✅ Complete — local tests passing.
