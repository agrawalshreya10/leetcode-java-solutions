# 283 — Move Zeroes

## Summary

In-place rearrangement: all non-zero elements move to the front, preserving order; remaining slots are zero-filled.

## Complexity

| | |
|---|---|
| **Time** | O(n) — single pass to compact non-zeros, single pass to fill zeros |
| **Space** | O(1) — no auxiliary array |

## Pattern

**Two pointers (write pointer)** — see [`templates/two-pointers/EXPLANATION.md`](../../templates/two-pointers/EXPLANATION.md).

- `i` scans the array.
- `j` marks the next position for a non-zero value.
- Invariant: `[0, j)` holds all non-zeros in original relative order.

## SDET Review

### Correctness

- Handles empty and single-element arrays via `n > 1` guard (redundant but safe).
- Zero-fill loop correctly handles the case where all elements are non-zero (`j == n`, inner loop skipped).

### Efficiency

- Optimal O(n) time and O(1) space for this constraint set.
- Avoids swap-based approaches that add unnecessary writes.

### Readability & modularity

- Clear separation: compact phase, then fill phase.
- **Improvement:** Drop the `n > 1` guard — the loops behave correctly for `n <= 1` without it, reducing branching noise.
- **Improvement:** Rename `j` → `writeIndex` for self-documenting test-utility style.

### Production / automation analogy

**Log buffer compaction:** When a streaming test reporter drops filtered events (e.g., keep only `ERROR`), you often compact an in-memory ring buffer in place — read index scans, write index tracks the next retained slot. Same invariant as move-zeroes.

## Key learnings

- Two-pointer "write head" pattern is the go-to for in-place filter/reorder problems.
- Order preservation implies **copy/compaction**, not swap-from-both-ends.

## Status

✅ Complete — local tests passing.
