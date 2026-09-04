# 1929 — Concatenation of Array

## Summary

Return a new array that is `nums` appended to itself: `[nums[0], ..., nums[n-1], nums[0], ..., nums[n-1]]`.

## Complexity

| | |
|---|---|
| **Time** | O(n) — single pass over `nums` |
| **Space** | O(n) — output array of size `2n` |

## Pattern

**Array basics / copy-to-output** — foundational loop before prefix-sum or two-pointer patterns.

- One read index `i` over the source.
- Two write positions: `i` (first copy) and `i + n` (second copy).

## SDET Review

### Correctness

- `n == 0` yields empty `ans` — correct.
- Single-element and multi-element cases mirror the same loop — no off-by-one.
- Negative values copy correctly (no sign assumptions).

### Efficiency

- Optimal single-pass O(n); each source element written exactly twice.
- Alternative: `System.arraycopy(nums, 0, ans, 0, n)` twice — fewer lines, same complexity; JVM may optimize bulk copy.

### Readability & modularity

- Clear intent: duplicate the array end-to-end.
- **Improvement:** Use `System.arraycopy` for production-style clarity:

  ```java
  System.arraycopy(nums, 0, ans, 0, n);
  System.arraycopy(nums, 0, ans, n, n);
  ```

- **Improvement:** Consistent naming — `result` instead of `ans` to match other solutions in the repo.

### Production / automation analogy

**Duplicate test fixture data:** When a load test needs the same request batch run twice back-to-back, concatenating a baseline array onto itself is the same O(n) copy pattern used in data setup utilities.

## Key learnings

- Appending a copy of an array to itself is a single loop with offset `i + n` — simpler than interleaving (compare LC 1470).
- Good warm-up problem before array manipulation patterns get subtler.

## Status

✅ Complete — local tests passing.
