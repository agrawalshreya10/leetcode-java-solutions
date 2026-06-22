# 2 — Add Two Numbers

## Summary

Add two numbers represented as reversed linked lists (each node = one digit). Return the sum as a linked list in the same format.

## Complexity (target)

| | |
|---|---|
| **Time** | O(max(m, n)) — traverse both lists once |
| **Space** | O(max(m, n)) for output list; O(1) extra if output not counted |

## Pattern

**Linked list traversal with carry** — see [`templates/linked-list/EXPLANATION.md`](../../templates/linked-list/EXPLANATION.md).

## SDET Review (placeholder)

### Current state

- `ListNode` defined locally for local testing (LeetCode provides it on submit).
- `addTwoNumbers` returns `null` — not yet implemented.
- Tests are `@Disabled` until implementation is complete.

### Implementation checklist

1. Dummy head node simplifies tail append.
2. Loop while `l1 != null || l2 != null || carry != 0`.
3. Sum digits + carry, append `sum % 10`, carry `sum / 10`.
4. Advance pointers.

### Production / automation analogy

**Version chain merge:** Combining two ordered event streams (build IDs as digits) with carry-like overflow into the next significance level — same walk-and-merge structure.

## Status

🚧 Placeholder — awaiting implementation.
