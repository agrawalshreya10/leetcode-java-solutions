# Prefix Sum

## When (Trigger)

Use when you need **range totals** or **running aggregates** over a static array:

- Sum of subarray `[i, j]` in O(1) after O(n) preprocess
- Check if a **split point** balances left/right sums
- Track **running max/min** of cumulative totals

**Signal phrases:** "sum of subarray", "balance point", "cumulative", "running total", "altitude", "profit over time".

## Core (Skeleton)

### One-pass running total + max

```java
int running = 0, best = initialValue;
for (int x : nums) {
    running += x;
    best = Math.max(best, running);
}
```

### Two-pass pivot / balance

```java
int total = 0;
for (int x : nums) total += x;

int left = 0;
for (int i = 0; i < nums.length; i++) {
    int right = total - left - nums[i];
    if (left == right) return i;
    left += nums[i];
}
return -1;
```

### Full prefix array (range queries)

```java
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++) {
    prefix[i + 1] = prefix[i] + nums[i];
}
// sum(i, j) = prefix[j + 1] - prefix[i]
```

## Variations

| Variant | Space | Use when |
|---------|-------|----------|
| Running variable only | O(1) | Single query, max/min of prefix |
| Prefix array | O(n) | Many range queries |
| Prefix + hash map | O(n) | Subarray sum equals k |

## Anti-patterns

- **Prefix array for single pivot check** — O(1) space two-pass is enough.
- **Forgetting initial state** in max problems (e.g. altitude starts at 0).
- **Integer overflow** on large sums — use `long` in production metrics.

## Linked Problems

| Problem | Variant |
|---------|---------|
| LC 724 Find Pivot Index | Two-pass balance |
| LC 1732 Highest Altitude | Running max of prefix |
| LC 303 Range Sum Query | Prefix array |
| LC 560 Subarray Sum Equals K | Prefix + hashmap |

## SDET in the Wild

**CI timing dashboards:** Cumulative stage durations — peak prefix sum identifies worst pipeline segment.

**Metrics regression:** Compare prefix sums of error counts over build windows to detect when a regression started.

**Resource accounting:** Split infrastructure costs at a pivot day — prefix totals left vs right of a cutover date.
