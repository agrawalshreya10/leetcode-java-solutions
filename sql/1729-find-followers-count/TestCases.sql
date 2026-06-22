-- Expected result sets for manual verification (run against LeetCode SQL editor or local SQLite seed).

-- Case 1: basic counts
-- followers table:
-- | user_id | follower_id |
-- | 1       | 2           |
-- | 1       | 3           |
-- | 2       | 4           |
-- Expected: user_id 1 -> 2 followers, user_id 2 -> 1 follower

-- Case 2: user with no followers should not appear (depends on problem variant — verify statement)

-- Case 3: duplicate follower rows — confirm whether constraints prevent duplicates
