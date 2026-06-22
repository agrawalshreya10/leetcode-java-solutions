# 1470 — Shuffle the Array

## Summary

Given `nums` of length `2n`, interleave the first half `nums[0..n-1]` with the second half `nums[n..2n-1]` into a new array: `x1, y1, x2, y2, ...`.

## Complexity

| | |
|---|---|
| **Time** | O(n) — one pass, two writes per iteration |
| **Space** | O(n) — output array of size `2n` (required by problem) |

## Pattern

**Interleaving / dual-index merge** — related to [`templates/two-pointers/EXPLANATION.md`](../../templates/two-pointers/EXPLANATION.md) (write-pointer variant).

- `i` walks `0..n-1` over the first half.
- `index` advances twice per step: first half value, then second half value.
- Invariant: after `i` iterations, `result[0..2i)` holds the correctly interleaved prefix.

## SDET Review

### Correctness

- Loop bound `i < n` is correct — each iteration consumes one element from each half.
- `index` starts at 0 and increments twice per `i`; final length is `2n`.
- Handles `n == 0` (empty input) without special casing — loop skipped, returns empty array.

### Efficiency

- Optimal O(n) time for building the output.
- No unnecessary allocations beyond `result`.
- Removed unused `import java.util.ArrayList` from the migrated solution.

### Readability & modularity

- Straightforward interleaving logic — easy to explain in an interview.
- **Improvement:** `result[2 * i] = nums[i]; result[2 * i + 1] = nums[i + n];` avoids a separate `index` variable and makes the interleave formula explicit.
- **Improvement:** Rename `n` parameter to `halfLength` if you want self-documenting signatures in test utilities.

### Production / automation analogy

**Zip-merge two ordered streams:** When merging parallel test result arrays (e.g., baseline vs candidate run IDs) into an alternating comparison list, the same dual-write loop applies — one element from stream A, one from stream B, repeat.

## Key learnings

- Interleaving two fixed halves is a single-loop pattern — no nested loops needed.
- When output size is `2n`, you can index directly with `2 * i` instead of a running write head.

## Status

✅ Complete — local tests passing.
