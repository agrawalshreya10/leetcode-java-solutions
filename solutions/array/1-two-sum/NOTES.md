# 1 — Two Sum

Structured hint sidecar (extension): [`1.hint`](1.hint).

## Summary

Return the indices of the two numbers in `nums` that add up to `target`. Exactly one solution; same element may not be used twice; order of indices does not matter.

## Complexity

| | |
|---|---|
| **Time** | O(n) — one pass over `nums` with average O(1) map ops |
| **Space** | O(n) — map stores up to `n` value→index entries |

## Pattern

**Hash map (value → index)** — see [`templates/hash-map/EXPLANATION.md`](../../../templates/hash-map/EXPLANATION.md).

- Before inserting `nums[i]`, look up `target - nums[i]`.
- If present at a different index, return that pair.
- Else store `(nums[i] → i)`.
- Invariant: after index `i` is processed (put or return), every prior value’s latest index is in the map.

## SDET Review

### Correctness

- Examples `[2,7,11,15]`, `[3,2,4]`, `[3,3]` — covered by local tests.
- Duplicate values: put happens only when complement is missing; second copy can pair with the first (`[3,3] → [0,1]`).
- `lookUpMap.get(...) != i` is redundant while you put **after** a miss (current `i` is not in the map yet) — harmless guard, useful interview talking point.

### Efficiency

- Optimal O(n) time / O(n) space for unsorted input needing **original indices**.
- Continues the loop after finding a pair (fills `indexPair`, no early `return`). Guaranteed unique answer, so last/first assignment both work; **Improvement:** `return new int[]{..., i}` on hit for clearer intent and slightly better best-case.

### Readability

- `lookUpMap` / `indexPair` name the roles clearly.
- **Improvement:** prefer `Map.get` once into a local `Integer` instead of calling `containsKey` + `get` + `get` again.

### Alternative approach

| Approach | Time | Space | When |
|----------|------|-------|------|
| Nested loops (brute force) | O(n²) | O(1) | Interview baseline only |
| Sort + two pointers | O(n log n) | O(1)–O(n) | Fine for **values**; needs index pairs if original indices required — fussier than a map for LC 1 |
| **One-pass hash map (yours)** | O(n) | O(n) | Default senior answer for unsorted + indices |

## Production / automation analogy

**Correlation by id:** Given a list of event codes and a required “pair sum” (e.g. request id + response id encoding), a map from seen codes → first occurrence index is the same pattern as joining two sides of a log without a nested scan.

## Key learnings

- Two Sum asks for **indices** → sorting alone loses positions.
- One-pass map: lookup complement **before** insert so duplicates and self-pairs are handled cleanly.
- Brute force is fine to mention first; map is the submit-worthy finish.

## Status

✅ Checkpointed — local tests passing.
