# 611 — Valid Triangle Number

Structured scored review (extension Analysis panel): [`611.hint`](611.hint) — fill via Ask Agent — Analyze when ready.

## Summary

Given side lengths in `nums`, return how many triplets can form a valid triangle (`a + b > c` for sorted sides).

## Complexity

| | |
|---|---|
| **Time** | O(n²) — sort O(n log n), then fix largest side and scan with two pointers |
| **Space** | O(1) extra (or O(log n) for sort) |

## Pattern

**Sort + fix largest side + converging two pointers** — see [`templates/two-pointers/EXPLANATION.md`](../../../templates/two-pointers/EXPLANATION.md).

- Sort so the only inequality that matters is `nums[i] + nums[j] > nums[index]` (with `i < j < index`).
- Fix `index` as the longest side; search pairs in `[0, index - 1]`.
- If sum is large enough: every left index in `[i, j)` also works with this `j` → add `(j - i)`, then `j--`.
- If sum is too small: `i++`.

## SDET Review

### Correctness

- Examples: `[2,2,3,4] → 3`, `[4,2,3,4] → 4`.
- Outer loop `index > 1` ensures at least three indices.
- Zeros / degenerate sides: sorted + inequality correctly yields `0` for `[0,0,0]` and `[1,2,3]`.

### Efficiency

- O(n²) is the standard interview target (better than O(n³) triple loops).
- The `(j - i)` batch count is the key win of sorting — do not count only one pair per hit.

### Readability

- Clear `index` / `i` / `j` roles once narrated in interview.
- **Cosmetic note at checkpoint:** flat file had `(while i < j)` — parentheses were corrected to `while (i < j)` so the class compiles; algorithm unchanged.

## Key learnings

- After sort, triangle check collapses to one inequality on the largest side.
- When `nums[i] + nums[j] > nums[k]`, all of `i..j-1` work with `j` — that is why you add `j - i`.

## Status

✅ Checkpointed — local tests added.
