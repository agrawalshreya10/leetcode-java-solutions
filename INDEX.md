# LeetCode Practice Index

Master index for solutions, patterns, and revision notes.

## Repo layout

```text
solutions/leetcode/[category]/[compact]/
  Solution.java      ← package leetcode.[category].[compact]; (matches folders)
  TestCases.java     ← JUnit local verification
  NOTES.md           ← SDET review + complexity + learnings
  {id}.hint          ← optional extension analysis JSON
sql/[id-kebab-name]/
  solution.sql
  TestCases.sql
templates/[pattern]/
  EXPLANATION.md
  Template.java
INDEX.md             ← this file (ID column keeps the LeetCode number)
```

**Category** is the Java package segment (`array`, `string`, `linkedlist`, …) — must be a legal identifier (no hyphens).  
**Compact** is the LeetCode `titleSlug` with hyphens removed (`sort-colors` → `sortcolors`, `meeting-rooms-ii` → `meetingroomsii`) so sequels stay unique without putting the numeric id in the path.  
**Plans** and **patterns** live in the header comment on `Solution.java`.  
**Packages** match the folder path under `solutions/` so the IDE and `mvn test` agree. Remove the `package` line before pasting to LeetCode submit.

## Problems



### Array


| ID   | Problem                                                                        | Plan                       | Pattern      | Status | Notes                                                                  |
| ---- | ------------------------------------------------------------------------------ | -------------------------- | ------------ | ------ | ---------------------------------------------------------------------- |
| 283  | [Move Zeroes](solutions/leetcode/array/movezeroes/NOTES.md)                        | leetcode-75                | two-pointers | ✅      | [NOTES](solutions/leetcode/array/movezeroes/NOTES.md)                      |
| 605  | [Can Place Flowers](solutions/leetcode/array/canplaceflowers/NOTES.md)            | leetcode-75                | greedy       | ✅      | [NOTES](solutions/leetcode/array/canplaceflowers/NOTES.md)                |
| 724  | [Find Pivot Index](solutions/leetcode/array/findpivotindex/NOTES.md)              | leetcode-75                | prefix-sum   | ✅      | [NOTES](solutions/leetcode/array/findpivotindex/NOTES.md)                 |
| 1732 | [Find Highest Altitude](solutions/leetcode/array/findhighestaltitude/NOTES.md)   | leetcode-75                | prefix-sum   | ✅      | [NOTES](solutions/leetcode/array/findhighestaltitude/NOTES.md)           |
| 485  | [Max Consecutive Ones](solutions/leetcode/array/maxconsecutiveones/NOTES.md)      | quest-problems             | single-pass  | ✅      | [NOTES](solutions/leetcode/array/maxconsecutiveones/NOTES.md)             |
| 1470 | [Shuffle the Array](solutions/leetcode/array/shufflethearray/NOTES.md)           | quest-problems             | interleaving | ✅      | [NOTES](solutions/leetcode/array/shufflethearray/NOTES.md)               |
| 1929 | [Concatenation of Array](solutions/leetcode/array/concatenationofarray/NOTES.md) | quest-problems             | array-basics | ✅      | [NOTES](solutions/leetcode/array/concatenationofarray/NOTES.md)          |
| 217  | [Contains Duplicate](solutions/leetcode/array/containsduplicate/NOTES.md)          | senior-sdet-interview-prep | hash-set     | ✅      | [NOTES](solutions/leetcode/array/containsduplicate/NOTES.md)               |
| 1    | [Two Sum](solutions/leetcode/array/twosum/NOTES.md)                                  | senior-sdet-interview-prep | hash-map     | ✅      | [NOTES](solutions/leetcode/array/twosum/NOTES.md)                            |
| 167  | [Two Sum II](solutions/leetcode/array/twosumii/NOTES.md)    | senior-sdet-interview-prep | two-pointers | ✅      | [NOTES](solutions/leetcode/array/twosumii/NOTES.md) |
| 15   | [3Sum](solutions/leetcode/array/threesum/NOTES.md)                                       | senior-sdet-interview-prep | two-pointers | ✅      | [NOTES](solutions/leetcode/array/threesum/NOTES.md)                              |
| 611  | [Valid Triangle Number](solutions/leetcode/array/validtrianglenumber/NOTES.md)    | senior-sdet-interview-prep | two-pointers | ✅      | [NOTES](solutions/leetcode/array/validtrianglenumber/NOTES.md)            |
| 75   | [Sort Colors](solutions/leetcode/array/sortcolors/NOTES.md)                         | senior-sdet-interview-prep | three-pointers | ✅    | [NOTES](solutions/leetcode/array/sortcolors/NOTES.md)                       |
| 11   | [Container With Most Water](solutions/leetcode/array/containerwithmostwater/NOTES.md) | senior-sdet-interview-prep | two-pointers | ✅ | [NOTES](solutions/leetcode/array/containerwithmostwater/NOTES.md)         |

### String


| ID  | Problem                                                                                | Plan        | Pattern      | Status | Notes                                                             |
| --- | -------------------------------------------------------------------------------------- | ----------- | ------------ | ------ | ----------------------------------------------------------------- |
| 345 | [Reverse Vowels of a String](solutions/leetcode/string/reversevowelsofastring/NOTES.md) | leetcode-75 | two-pointers | 🚧     | [NOTES](solutions/leetcode/string/reversevowelsofastring/NOTES.md) |




### Linked List


| ID  | Problem                                                             | Plan              | Pattern     | Status | Notes                                                     |
| --- | ------------------------------------------------------------------- | ----------------- | ----------- | ------ | --------------------------------------------------------- |
| 2   | [Add Two Numbers](solutions/leetcode/linkedlist/addtwonumbers/NOTES.md) | top-interview-150 | linked-list | 🚧     | [NOTES](solutions/leetcode/linkedlist/addtwonumbers/NOTES.md) |




### SQL


| ID   | Problem                                                        | Plan        | Status | Notes                                           |
| ---- | -------------------------------------------------------------- | ----------- | ------ | ----------------------------------------------- |
| 1729 | [Find Followers Count](sql/1729-find-followers-count/NOTES.md) | leetcode-75 | 🚧     | [NOTES](sql/1729-find-followers-count/NOTES.md) |




## Pattern library

See [templates/README.md](templates/README.md).

## Commands

```bash
# Run all enabled JUnit tests
mvn test

# Run tests for one problem
mvn test -Dtest=TestCases -Dsurefire.failIfNoSpecifiedTests=false \
  -Dsurefire.includes=**/283-move-zeroes/TestCases.java

# Install git hooks (auto-push current branch after commit)
./scripts/install-hooks.sh

# Stage solutions/sql and commit (push via post-commit hook)
./scripts/commit_updates.sh
```



## Git automation


| Mechanism                                      | What it does                                                                          |
| ---------------------------------------------- | ------------------------------------------------------------------------------------- |
| **post-commit hook** (`.githooks/post-commit`) | After any commit, runs `git push origin <current-branch>` (exits non-zero on failure) |
| **scripts/commit_updates.sh**                  | Stages `solutions/` + `sql/`, commits with `Solved: <folder-name>`                    |


**Git hook vs VS Code task:** Hooks run whenever you commit (terminal or IDE) — true automation. VS Code tasks only run when you trigger them. Hooks are recommended for push-after-commit.

Run `./scripts/install-hooks.sh` once per clone.

## LeetCode Practice extension (optional — not required)

This repo is **solutions-first**: `Solution.java`, `NOTES.md`, `TestCases.java`, and `templates/` are useful without any IDE extension. Extension setup is personal and **not committed** (`.leetcode` is gitignored).

**If you use [LeetCode Practice](https://marketplace.visualstudio.com/items?itemName=NikkyAmresh.leetcode-practice)** (`NikkyAmresh.leetcode-practice`):

1. Create `.leetcode` in the repo root (activates the extension).
2. Primary list: **Senior SDET Interview Prep** — use the list slug from your LeetCode share URL (`problem-list/{slug}/`), not the display name.
3. Recommended local settings: `defaultDirectory: "solutions"`, `fileNamePattern: "id"`, `language: "java"`.
4. Sign in: Command Palette → `LeetCode: Sign In`.



### What `fileNamePattern: "id"` creates (Java)

For **Java**, the extension does **not** create `217.java`. It creates:

```text
solutions/LCexMain217.java
```

Because Java filenames must match a valid class name, the extension uses `LCexMain{id}` and adds a `main()` for **Run Examples** / **Run in Terminal**. LeetCode **Submit** still uses `class Solution`.


| Extension flat file          | Repo target (after agent move)                         |
| ---------------------------- | ------------------------------------------------------ |
| `solutions/LCexMain217.java` | `solutions/leetcode/array/containsduplicate/Solution.java` |


Other languages (if used): `solutions/{id}.ts`, etc.

### Solve-first workflow

1. **Solve** in the flat extension file (`LCexMain{id}.java`) — run examples, submit to LeetCode from the problem webview.
2. Say **checkpoint** (or *accepted* / *reorganize*) → agent moves to repo layout, adds `TestCases.java`, `NOTES.md`, moves `{id}.hint`, updates `INDEX.md`.
3. `mvn test` on the reorganized folder; `./scripts/commit_updates.sh` (fails if flat `LCexMain*` still present).

Flat extension artifacts (`LCexMain*.java`, `solutions/*.hint`, `.lcex_java_out/`) are **gitignored**. Nested `{id}.hint` is committed **only** when it has substantial Analysis/coaching content (empty stubs are dropped).

**New problems:** `Plans: senior-sdet-interview-prep` in the header comment. Older rows may show `leetcode-75` or `quest-problems` (historical).

**Agent:** checkpoint pipeline on trigger words — preserve solution logic; strip `LCexMain`* on move.

## Workflow



### With extension (recommended)

1. Pick problem from **Senior SDET Interview Prep** in the extension sidebar.
2. Create file → solve in `solutions/LCexMain{id}.java`.
3. Submit from the problem webview (Sign In required for server submit).
4. Agent: **checkpoint** → repo layout + tests + notes + `INDEX.md`.
5. `mvn test` → `./scripts/commit_updates.sh` → hook pushes.



### Without extension

1. Create folder `solutions/leetcode/[category]/[compact]/` manually (compact = titleSlug without hyphens).
2. Implement in `Solution.java` with matching `package leetcode.[category].[compact];`.
3. Ask agent for `TestCases.java` + `NOTES.md` when ready.
4. `mvn test` → commit.

