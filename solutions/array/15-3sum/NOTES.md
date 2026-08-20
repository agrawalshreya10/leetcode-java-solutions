# 15 — 3Sum

## Summary

Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, `j != k`, and `nums[i] + nums[j] + nums[k] == 0`. The solution set must not contain duplicate triplets.

## Complexity

| | |
|---|---|
| **Time** | O(n²) — sort O(n log n) plus outer index `i` with an inner two-pointer scan |
| **Space** | O(n) — `HashSet` for deduplicated triplets (output can be O(n) in worst case) |

## Pattern

**Sort + fixed first element + converging two pointers** — see [`templates/two-pointers/EXPLANATION.md`](../../../templates/two-pointers/EXPLANATION.md).

- Sort `nums` so the inner pair search is monotonic.
- Fix `nums[i]` as the first value of the triplet; find pairs in `[i+1, n-1]` that sum to `-nums[i]` (same move rule as [167 Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)).
- On `sum == 0`: record the triplet, then move **both** `left` and `right` — that pair is consumed; sorted order means no other partner for those two values can still hit zero.
- `HashSet<List<Integer>>` absorbs duplicate triplets without extra skip logic.

## SDET Review

### Correctness

- LeetCode examples: `[-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]`, `[0,1,1] → []`, `[0,0,0] → [[0,0,0]]`.
- Outer loop stops at `i < n - 2` — need at least two remaining slots for `left` and `right`.
- After a hit, moving both pointers is required; moving only one would leave the loop stuck or miss the next valid pair for the same `i`.

### Efficiency

- O(n²) is the standard target for 3Sum (sort + two pointers). Nested triple loops are O(n³).
- `HashSet` trades a bit of space for simpler duplicate handling vs in-loop skip of equal `i` / `left` / `right`.

### Readability

- `left` / `right` names match the converging-pointer template from LC 167.
- **Improvement:** braces on the `else if` / `else` branches avoid accidental semicolon bugs (e.g. `else if (sum < 0);`).

### Alternative approach

| Approach | Time | Space | When |
|----------|------|-------|------|
| Triple nested loops | O(n³) | O(output) | Baseline only |
| Sort + two pointers + skip duplicates (no set) | O(n²) | O(1) extra beyond output | Interview polish — skip equal `nums[i]`, `nums[left]`, `nums[right]` after hits |
| **Sort + two pointers + HashSet (yours)** | O(n²) | O(n) | Correct and easy to reason about; set hides duplicate triplets |

## Production / automation analogy

**Three-way correlation on sorted metrics:** Given sorted latency samples from three services, find all unique `(a, b, c)` triples that sum to a SLA budget (zero net drift). Sort once, pin the smallest contributor, two-pointer scan the rest — same O(n²) envelope as scanning all pairs for one fixed anchor.

## Key learnings

- 3Sum is **167 on the remaining slice** after fixing the first number; target for the pair is `-nums[i]`.
- Sorting is what makes “too small → `left++`, too large → `right--`” sound.
- Duplicate triplets vs duplicate **values inside** a valid triplet (e.g. two `-1`s in `[-1,-1,2]`) are different — the latter is a real answer; the former is what you dedupe.

## Status

✅ Checkpointed — local tests passing.
