# Greedy

## When (Trigger)

Use when **locally optimal choices** lead to a global optimum:

- Interval scheduling, minimum resources
- "Can we fit X if we always pick the earliest valid option?"
- Non-overlapping placement with immediate commitment

**Signal phrases:** "maximum number of", "minimum intervals", "can you place", "without overlapping", "earliest finish time".

## Core (Skeleton)

```java
// Sort if needed (by end time, start time, etc.)
int remaining = target;
for (int i = 0; i < n; i++) {
    if (canTake(i) && takingImprovesOrNeeded(i)) {
        applyChoice(i);
        remaining--;
        if (remaining == 0) return true;
    }
}
return remaining <= 0;
```

**Invariant:** After processing index `i`, the partial solution is feasible and maximal among all solutions using only indices `<= i`.

## Variations

| Variant | Sort key | Example |
|---------|----------|---------|
| Earliest finish | end time | Non-overlapping intervals |
| Smallest/largest first | value | Assign cookies |
| Scanline | position | Can place flowers |

## Anti-patterns

- **Greedy without proof** — if local choice can block future better arrangement, use DP or backtracking.
- **Not mutating/reserving state** when problem assumes committed choices (flowerbed planting).
- **Skipping sort** on interval problems where order matters.

## Linked Problems

| Problem | Notes |
|---------|-------|
| LC 605 Can Place Flowers | Linear greedy placement |
| LC 435 Non-overlapping Intervals | Sort by end |
| LC 455 Assign Cookies | Sort both arrays |
| LC 55 Jump Game | Reachability greedy |

## SDET in the Wild

**Test shard packing:** Assign test classes to CI nodes greedily by earliest slot availability — same as interval scheduling.

**Retry budget allocation:** Spend retry attempts on the earliest failing flaky tests that unblock the most downstream jobs.

**License/seat assignment:** Place reservations in the first valid slot that satisfies adjacency constraints (e.g. GPU nodes).
