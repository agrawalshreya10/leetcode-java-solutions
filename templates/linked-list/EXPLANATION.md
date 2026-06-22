# Linked List

## When (Trigger)

Use when data is a **singly/doubly linked list** and you must:

- Traverse with **carry / merge** (add numbers, merge sorted lists)
- Detect **cycles** or find middle (fast/slow)
- **Reverse** segments or entire list

**Signal phrases:** "linked list", "nodes", "reverse", "merge", "cycle", "kth from end".

## Core (Skeleton)

### Traversal with dummy head

```java
ListNode dummy = new ListNode();
ListNode tail = dummy;
while (l1 != null || l2 != null /* || carry */) {
    int value = /* compute */;
    tail.next = new ListNode(value);
    tail = tail.next;
    // advance pointers
}
return dummy.next;
```

**Invariant:** `dummy.next` is the head of the built result; `tail` is last node.

### Fast / slow pointers

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow at middle (or cycle detection logic)
```

## Variations

| Variant | Technique |
|---------|-----------|
| Add with carry | Dummy + single loop |
| Reverse list | Iterative three-pointer |
| Remove nth from end | Fast/slow offset by n |
| Merge k lists | Heap / divide-conquer |

## Anti-patterns

- **Losing head reference** — always use dummy node when building new list.
- **Not handling trailing carry** — loop condition must include `carry != 0`.
- **Null dereference** — check `node != null` before `node.next`.

## Linked Problems

| Problem | Technique |
|---------|-----------|
| LC 2 Add Two Numbers | Merge + carry |
| LC 21 Merge Two Sorted Lists | Dummy merge |
| LC 141 Linked List Cycle | Fast/slow |
| LC 206 Reverse Linked List | Iterative reverse |

## SDET in the Wild

**Event chain validation:** Test reports linked as a singly-linked audit trail — walk nodes verifying ordering and carry-forward state between pipeline stages.

**Retry chain merge:** Merge two ordered failure queues into one prioritized retry list — identical merge pattern.

**Session token lists:** Walk a token refresh chain detecting cycles (infinite refresh loops) — fast/slow detection.
