# 11 — Container With Most Water

## Summary

Given heights of vertical lines, choose two lines that with the x-axis form a container holding the **maximum** water. Area = `min(height[i], height[j]) * (j - i)`.

## Complexity

| | |
|---|---|
| **Time** | O(n) — each pointer moves at most n times |
| **Space** | O(1) |

## Pattern

**Converging two pointers** — see [`templates/two-pointers/EXPLANATION.md`](../../../templates/two-pointers/EXPLANATION.md).

- Start at widest: `i = 0`, `j = n - 1`.
- Track a **global** `maxArea` (not the last computed area).
- Each step: compute area for `(i, j)`, then move the **shorter** wall inward (either when equal).
- Invariant: every discarded side cannot improve on the best area already seen for that width class.

Inline comments in `Solution.java` label pointer roles and the move rule.

## SDET Review

### Correctness

- Examples: `[1,8,6,2,5,4,8,3,7] → 49`, `[1,1] → 1`.
- Two elements: width `1`, height `min` of the pair.
- Equal heights: moving either side is fine; width shrinks until pointers meet.

### Efficiency

- O(n) is optimal for a single pass over the array.
- Brute force all pairs is O(n²) — common first idea, too slow for interview expectations here.

### Pitfalls (from earlier attempts)

- Do **not** `break` when neighbors are not “taller enough” — that stops the search early.
- Do **not** overwrite `area` without `max` — later pairs can erase a better earlier answer.
- Width is always `j - i`, recomputed each iteration.

## Key learnings

- Area is limited by the shorter wall; shrinking from that side is the only move that can raise the limiting height.
- Running maximum + unconditional pointer advance (until `i >= j`) is the full story.

## Status

✅ Checkpointed — local tests added.
