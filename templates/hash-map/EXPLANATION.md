# Hash Map / Hash Set

## About the pattern

A **hash map** stores key → value for average O(1) lookup, insert, and delete. A **hash set** is the membership-only variant (key → present). Both trade memory for avoiding nested scans when you need “have I seen X?” or “where did I see X?”

## When (Trigger)

- Unsorted array/string and you need a **complement**, duplicate, or prior index in one pass
- Counting frequencies, grouping anagrams, or joining two streams by key
- Signal phrases: “two sum”, “contains duplicate”, “first unique”, “group by”, “seen before”

## Core (Skeleton)

### Variation A — Set (membership / duplicate)

```java
Set<Integer> seen = new HashSet<>();
for (int x : nums) {
    if (!seen.add(x)) {
        // x was already present
    }
}
```

**Invariant:** after index `i`, `seen` holds distinct values from `nums[0..i]`.

### Variation B — Map value → index (Two Sum style)

```java
Map<Integer, Integer> indexByValue = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int need = target - nums[i];
    if (indexByValue.containsKey(need)) {
        return new int[]{indexByValue.get(need), i};
    }
    indexByValue.put(nums[i], i);
}
```

**Invariant:** map holds values from indices `[0, i)` (put after lookup).

### Variation C — Frequency map

```java
Map<Integer, Integer> freq = new HashMap<>();
for (int x : nums) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
```

## Variations

| Variant | Use |
|---------|-----|
| Set | Existence / duplicate only ([217](../../solutions/array/217-contains-duplicate/NOTES.md)) |
| Value → index | Pair with complement, original indices ([1](../../solutions/array/1-two-sum/NOTES.md)) |
| Sliding window + map | At most K distinct / longest substring without repeat |

## Anti-patterns

- Sorting when you need **original indices** (Two Sum) — loses positions unless you carry index pairs
- Nested O(n²) scan when a map gives O(n) with clear interview narrative
- Forgetting to check “same index twice” when map was filled in a separate first pass

## Linked problems

- [1 Two Sum](../../solutions/array/1-two-sum/NOTES.md) — value → index
- [217 Contains Duplicate](../../solutions/array/217-contains-duplicate/NOTES.md) — set size vs length
- Related: 219 Contains Duplicate II, 242 Valid Anagram, 49 Group Anagrams

## SDET use case

**Log / event join:** Map request id → first timestamp, then on response compute latency in one pass — same “seen key → metadata” structure as Two Sum’s value → index map.
