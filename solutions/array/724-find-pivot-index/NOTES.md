# 724 — Find Pivot Index

## Summary

Return the leftmost index where the sum of elements to the left equals the sum to the right. Return `-1` if none exists.

## Complexity

| | |
|---|---|
| **Time** | O(n) — one pass for total, one pass for pivot search |
| **Space** | O(1) — only running sums stored |

## Pattern

**Prefix sum / running total** — see [`templates/prefix-sum/EXPLANATION.md`](../../templates/prefix-sum/EXPLANATION.md).

- Precompute `totalSum`.
- At index `j`: `rightSum = totalSum - leftSum - nums[j]`.
- Compare `leftSum == rightSum`.

## SDET Review

### Correctness

- Empty array: first loop leaves `totalSum = 0`, second loop never runs → returns `-1`. Correct.
- Single element: `leftSum = 0`, `rightSum = 0` at index 0 → returns 0. Correct.
- Removed unused reassignment of `rightSum` on line 20 in original (was declared then overwritten immediately) — cleaner now.

### Efficiency

- Two-pass O(n) is optimal for unsorted arrays without preprocessing.
- Could use one pass with prefix array O(n) space for repeated queries — overkill for single-query problem.

### Readability & modularity

- Variable names map directly to problem vocabulary (`leftSum`, `totalSum`).
- **Improvement:** Use enhanced for-loop for total sum; keep index loop for pivot search.
- **Improvement:** Add `@DisplayName` in tests when pivot is at boundary — aids CI failure triage.

### Production / automation analogy

**Load balancer pivot:** Given per-server request counts, find a split point where traffic left and right of a cut point is balanced — same prefix/total decomposition used in shard rebalancing checks.

## Key learnings

- `rightSum` derived from total avoids a second full scan per index.
- First valid pivot returned — problem asks for leftmost; loop order guarantees that.

## Status

✅ Complete — local tests passing.
