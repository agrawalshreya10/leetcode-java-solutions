# 1729 — Find Followers Count (SQL)

## Summary

SQL problem — count followers per user from a `followers` table.

## Approach (target)

`GROUP BY user_id` with `COUNT(follower_id)`.

## Complexity

| | |
|---|---|
| **Time** | O(n) table scan with hash aggregation (engine-dependent) |
| **Space** | O(distinct users) for aggregation |

## Status

🚧 Placeholder — implement in LeetCode SQL editor or local DB when ready.

## Local practice options

1. **LeetCode SQL editor** — simplest; no repo tooling required.
2. **SQLite file in repo** — add `seed.sql` + run `sqlite3 test.db < TestCases.sql` for offline runs.
3. **Separate repo** — only if you add Dockerized Postgres + migration tooling at scale.

For now, keep under `sql/` in this repo.
