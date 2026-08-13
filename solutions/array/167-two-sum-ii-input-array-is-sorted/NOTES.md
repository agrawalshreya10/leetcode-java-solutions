# 167 — Two Sum II (Input Array Is Sorted)

## Summary

Given a **1-indexed** sorted array `numbers`, return the two indices `(index1, index2)` such that `numbers[index1] + numbers[index2] == target`. Exactly one solution; same element may not be used twice. Constant extra space is expected.

## Complexity

| | |
|---|---|
| **Time** | O(n) — each pointer moves at most `n` times |
| **Space** | O(1) — two indices plus the required 2-slot result |

## Pattern

**Two pointers (converging)** — see [`templates/two-pointers/EXPLANATION.md`](../../../templates/two-pointers/EXPLANATION.md).

- `i` starts at the left (smallest), `j` at the right (largest).
- Sum too small → `i++` (need a larger left value).
- Sum too large → `j--` (need a smaller right value).
- Hit → store **1-based** indices (`i + 1`, `j + 1`) and `break`.
- Invariant: if a pair exists, it lies in `[i, j]`; everything outside is already ruled out.

## SDET Review

### Correctness

- LeetCode examples: `[2,7,11,15]/9 → [1,2]`, `[2,3,4]/6 → [1,3]`, `[-1,0]/-1 → [1,2]`.
- Sorted non-decreasing order is what makes the move rule sound — you never skip a feasible pair.
- 1-based output is easy to miss in interviews; your `+ 1` is the right contract.

### Efficiency

- Optimal for this constraint set (sorted + O(1) extra space).
- Hash map (LC 1) is also O(n) time but O(n) space — **worse** here when the problem asks for constant space.

### Readability

- `i` / `j` are fine; **Improvement:** `left` / `right` matches the template vocabulary.
- Brace style on the `else j--` branch is valid; wrapping both branches in braces is a common interview-hygiene tweak (not required).

### Alternative approach

| Approach | Time | Space | When |
|----------|------|-------|------|
| Nested loops | O(n²) | O(1) | Baseline only |
| Hash map (LC 1 style) | O(n) | O(n) | Unsorted Two Sum; extra space vs this problem’s O(1) ask |
| **Converging two pointers (yours)** | O(n) | O(1) | Sorted input — default senior answer |

Contrast: [1 Two Sum](https://leetcode.com/problems/two-sum/) needs original indices on an **unsorted** array → map. This problem is sorted → two pointers.

## Production / automation analogy

**Binary-search-free range join:** Two sorted timestamp streams — walk from both ends (or both fronts) to find a pair that sums to a SLA window without building a lookup table. Same monotonic move rule.

## Key learnings

- Sorted + pair sum → converging pointers, not a hash map, when extra space is constrained.
- Answers are **1-indexed** — convert only at the return, keep 0-based while looping.
- Interview line: “Because the array is sorted, moving the left pointer increases the sum and moving the right decreases it.”

## Status

✅ Checkpointed — local tests passing.
