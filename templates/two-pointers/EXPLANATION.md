# Two Pointers

## When (Trigger)

Use when the input is **sequential** (array, string, linked list) and you need to:

- Compare or swap elements from **both ends** moving inward
- **Partition / compact** in-place with a read and write cursor
- Find a pair/subarray satisfying a sum or ordering constraint in **sorted** data

**Signal phrases:** "in-place", "without extra space", "reverse", "palindrome", "remove duplicates", "move zeros", "converging from both sides".

## Core (Skeleton)

### Variation A — Write pointer (compaction)

```java
int write = 0;
for (int read = 0; read < n; read++) {
    if (shouldKeep(a[read])) {
        a[write++] = a[read];
    }
}
// optional: fill remainder (e.g. zeros)
```

**Invariant:** `[0, write)` contains exactly the kept elements in original order.

### Variation B — Converging pointers

```java
int left = 0, right = n - 1;
while (left < right) {
    // advance left/right until condition met, then act (swap, compare, etc.)
}
```

**Invariant:** Everything outside `[left, right]` is already resolved.

## Variations

| Variant | When | Tweaks |
|---------|------|--------|
| Fixed window | Subarray of size `k` | Move `left`/`right` together |
| Dynamic window | Longest/shortest subarray with constraint | Expand `right`, shrink `left` |
| Fast/slow | Cycle detection, middle of list | Different step sizes |

## Anti-patterns

- **Two pointers on unsorted data for pair-sum** without sorting first — use hash map instead.
- **Swapping when compaction suffices** — extra writes (e.g. move zeroes).
- **Off-by-one on empty/single-element** — always trace `n <= 1`.

## Linked Problems

| Problem | Variant |
|---------|---------|
| LC 283 Move Zeroes | Write pointer |
| LC 345 Reverse Vowels | Converging + swap |
| LC 11 Container With Most Water | Converging |
| LC 15 3Sum | Sort + converging (advanced) |
| LC 26 Remove Duplicates | Write pointer |

## SDET in the Wild

**Log parsing:** Find duration between START/END events in a ordered log file — converging or sliding window over timestamps.

**Test result compaction:** Filter failed assertions in a large in-memory array before upload — write-pointer compaction preserves order with O(1) extra space.

**Parallel test scheduling:** Two indices over sorted job queue — assign from both ends for min/max load balancing (variant of converging greedy).
