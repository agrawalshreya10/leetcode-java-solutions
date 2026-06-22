# 1732 — Find the Highest Altitude

## Summary

Given net altitude gains between consecutive points (starting altitude 0), return the maximum altitude reached at any point including the start.

## Complexity

| | |
|---|---|
| **Time** | O(n) — single pass over `gain` |
| **Space** | O(1) — running totals only |

## Pattern

**Prefix sum (running aggregate)** — see [`templates/prefix-sum/EXPLANATION.md`](../../templates/prefix-sum/EXPLANATION.md).

`currentAlt` is the prefix sum of gains; track the maximum seen.

## SDET Review

### Correctness

- Initializes `highestAlt = 0` — correctly captures that starting altitude counts.
- Handles empty `gain`: loop skipped, returns 0. Correct.

### Efficiency

- Single-pass O(n) is optimal — every gain must be applied at least once.
- `currentAlt = currentAlt + gain[i]` can be `currentAlt += gain[i]` — minor style.

### Readability & modularity

- Names `highestAlt` / `currentAlt` are domain-aligned.
- **Improvement:** Enhanced for-loop reduces index noise:

  ```java
  for (int delta : gain) {
      currentAlt += delta;
      highestAlt = Math.max(highestAlt, currentAlt);
  }
  ```

- `Math.max` signals intent better than `if` for peak tracking — common in test metrics utilities.

### Production / automation analogy

**Cumulative latency tracking:** In CI pipeline timing, each stage adds a delta; track peak cumulative duration to find the bottleneck segment — identical running-max over prefix sums.

## Key learnings

- Always seed running-max problems with the initial state (altitude 0 before any movement).
- Prefix sum does not require a separate array when only the aggregate max is needed.

## Status

✅ Complete — local tests passing.
