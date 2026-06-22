# 345 — Reverse Vowels of a String

## Summary

Reverse only the vowels in a string (`a, e, i, o, u` — case insensitive). Consonants stay in place.

## Complexity (target)

| | |
|---|---|
| **Time** | O(n) — each pointer moves at most n steps |
| **Space** | O(n) if using `char[]` / `StringBuilder`; O(1) extra if mutating char array in place |

## Pattern

**Two pointers (converging)** — see [`templates/two-pointers/EXPLANATION.md`](../../templates/two-pointers/EXPLANATION.md).

## SDET Review (in-progress)

### Current state

- Two-pointer skeleton is started but incomplete — returns original string unchanged.
- Syntax errors from draft removed so the project compiles; tests are `@Disabled` until implementation is done.

### Next steps

1. Convert to `char[]` for in-place swaps (strings are immutable in Java).
2. Advance `left` / `right` until both point to vowels (use `vowels.indexOf(c) >= 0` or a `Set<Character>`).
3. Swap and shrink window.
4. Remove `@Disabled` from tests and run `mvn test`.

### Production / automation analogy

**Selective field reversal in log lines:** When normalizing test output, you may reverse only delimiter-tagged segments while keeping structure fixed — converging pointers over a char buffer.

## Status

🚧 In progress — tests scaffolded, implementation incomplete.
