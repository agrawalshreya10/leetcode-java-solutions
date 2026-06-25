# 217 — Contains Duplicate

Structured scored review (extension Analysis panel): [`217.hint`](217.hint).

## Summary

Return `true` if any value appears at least twice in `nums`.

## Complexity

| | |
|---|---|
| **Time** | O(n) average — one `HashSet` insert per element |
| **Space** | O(n) — set holds up to `n` distinct values |

## Pattern

**Hash set membership** — track seen values; duplicates collapse in the set.

- Insert every element into a `HashSet`.
- If `set.size() < nums.length`, at least one value repeated → `true`.
- Invariant: after processing index `i`, the set size equals the count of distinct values in `nums[0..i]`.

## SDET Review

### Correctness

- Single element: sizes equal → `false` — correct.
- All distinct: set size equals array length → `false`.
- Any repeat: set shrinks relative to length → `true`.
- Negative and zero values: `HashSet` handles boxed `Integer` keys — correct.

### Efficiency

- O(n) time is the standard interview answer for unsorted input.
- **Alternative (trade-off):** sort then scan neighbors — O(n log n) time, O(1) extra if in-place sort allowed; worse time, better space.

### Readability

- `uniqueElements` names the intent clearly.
- Ternary `? true : false` is redundant but harmless; `return nums.length > uniqueElements.size()` reads the same.

## Key learnings

- “Have I seen this before?” → set or map; size check after one pass is enough when you only need existence of a duplicate.
- Early exit: `if (!set.add(i)) return true` stops on first repeat (same time class, better best-case).

## Status

✅ Submitted on LeetCode; local tests passing.
