# 75 — Sort Colors

## Summary

Sort an array whose values are only `0`, `1`, and `2` **in-place**, in one pass (Dutch National Flag).

## Complexity

| | |
|---|---|
| **Time** | O(n) — each index is examined a constant number of times |
| **Space** | O(1) — three pointers only |

## Pattern

**Three pointers / Dutch National Flag** — related to [`templates/two-pointers/EXPLANATION.md`](../../../../templates/two-pointers/EXPLANATION.md) (partition / write-pointer family).

Invariant while `mid <= end`:

- `[0, start)` → `0`s  
- `[start, mid)` → `1`s  
- `[mid, end]` → unknown  
- `(end, n)` → `2`s  

| `nums[mid]` | Action |
|-------------|--------|
| `0` | Swap with `start`, then `start++` and `mid++` |
| `1` | `mid++` |
| `2` | Swap with `end`, then `end--` only (**do not** advance `mid`) |

Inline comments in `Solution.java` label the same invariant for quick re-read.

## SDET Review

### Correctness

- Examples: `[2,0,2,1,1,0] → [0,0,1,1,2,2]`, `[2,0,1] → [0,1,2]`.
- Skipping `mid++` on `2` is required: the value swapped in from `end` is still unknown.
- Empty / single-element / all-same arrays terminate correctly (`mid > end` or trivial loop).

### Efficiency

- One pass O(n), O(1) extra — preferred over counting sort’s two passes in interviews when “one pass” is asked.
- **Alternative:** count frequencies then overwrite — simpler to code, still O(n), but two logical passes.

### Readability

- `start` / `mid` / `end` (or `low` / `i` / `high`) are standard DNF names — easy to narrate.
- `switch` on `0/1/2` matches the domain; `if/else` is equally fine in interviews.

## Key learnings

- Three-way partition is the go-to when the alphabet is tiny (`{0,1,2}`) and in-place + one pass is required.
- The classic bug: advancing `mid` after a swap with `end`.

## Status

✅ Checkpointed — local tests added.
