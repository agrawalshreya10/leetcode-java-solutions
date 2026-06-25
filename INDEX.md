# LeetCode Practice Index

Master index for solutions, patterns, and revision notes.

## Repo layout

```text
solutions/[category]/[id-kebab-name]/
  Solution.java      ← LeetCode-ready (header comment tags)
  TestCases.java     ← JUnit 5 local verification
  NOTES.md           ← SDET review + complexity + learnings
sql/[id-kebab-name]/
  solution.sql
  TestCases.sql
templates/[pattern]/
  EXPLANATION.md
  Template.java
INDEX.md             ← this file
```

**Category folders** (`array`, `string`, `linked-list`, …) reflect problem domain.  
**Plans** (e.g. `senior-sdet-interview-prep`) and **patterns** live in the header comment on `Solution.java`.  
**Packages** (`package leetcode.array.movezeroes;`, etc.) are for local `mvn test` only — remove before LeetCode submit.

## Problems

### Array

| ID | Problem | Plan | Pattern | Status | Notes |
|----|---------|------|---------|--------|-------|
| 283 | [Move Zeroes](solutions/array/283-move-zeroes/NOTES.md) | leetcode-75 | two-pointers | ✅ | [NOTES](solutions/array/283-move-zeroes/NOTES.md) |
| 605 | [Can Place Flowers](solutions/array/605-can-place-flowers/NOTES.md) | leetcode-75 | greedy | ✅ | [NOTES](solutions/array/605-can-place-flowers/NOTES.md) |
| 724 | [Find Pivot Index](solutions/array/724-find-pivot-index/NOTES.md) | leetcode-75 | prefix-sum | ✅ | [NOTES](solutions/array/724-find-pivot-index/NOTES.md) |
| 1732 | [Find Highest Altitude](solutions/array/1732-find-highest-altitude/NOTES.md) | leetcode-75 | prefix-sum | ✅ | [NOTES](solutions/array/1732-find-highest-altitude/NOTES.md) |
| 485 | [Max Consecutive Ones](solutions/array/485-max-consecutive-ones/NOTES.md) | quest-problems | single-pass | ✅ | [NOTES](solutions/array/485-max-consecutive-ones/NOTES.md) |
| 1470 | [Shuffle the Array](solutions/array/1470-shuffle-the-array/NOTES.md) | quest-problems | interleaving | ✅ | [NOTES](solutions/array/1470-shuffle-the-array/NOTES.md) |
| 1929 | [Concatenation of Array](solutions/array/1929-concatenation-of-array/NOTES.md) | quest-problems | array-basics | ✅ | [NOTES](solutions/array/1929-concatenation-of-array/NOTES.md) |
| 217 | [Contains Duplicate](solutions/array/217-contains-duplicate/NOTES.md) | senior-sdet-interview-prep | hash-set | ✅ | [NOTES](solutions/array/217-contains-duplicate/NOTES.md) |

### String

| ID | Problem | Plan | Pattern | Status | Notes |
|----|---------|------|---------|--------|-------|
| 345 | [Reverse Vowels of a String](solutions/string/345-reverse-vowels-of-a-string/NOTES.md) | leetcode-75 | two-pointers | 🚧 | [NOTES](solutions/string/345-reverse-vowels-of-a-string/NOTES.md) |

### Linked List

| ID | Problem | Plan | Pattern | Status | Notes |
|----|---------|------|---------|--------|-------|
| 2 | [Add Two Numbers](solutions/linked-list/2-add-two-numbers/NOTES.md) | top-interview-150 | linked-list | 🚧 | [NOTES](solutions/linked-list/2-add-two-numbers/NOTES.md) |

### SQL

| ID | Problem | Plan | Status | Notes |
|----|---------|------|--------|-------|
| 1729 | [Find Followers Count](sql/1729-find-followers-count/NOTES.md) | leetcode-75 | 🚧 | [NOTES](sql/1729-find-followers-count/NOTES.md) |

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

| Mechanism | What it does |
|-----------|----------------|
| **post-commit hook** (`.githooks/post-commit`) | After any commit, runs `git push origin <current-branch>` (exits non-zero on failure) |
| **scripts/commit_updates.sh** | Stages `solutions/` + `sql/`, commits with `Solved: <folder-name>` |

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

| Extension flat file | Repo target (after agent move) |
|---------------------|--------------------------------|
| `solutions/LCexMain217.java` | `solutions/array/217-contains-duplicate/Solution.java` |

Other languages (if used): `solutions/{id}.ts`, etc.

### Solve-first workflow

1. **Solve** in the flat extension file (`LCexMain{id}.java`) — run examples, submit to LeetCode from the problem webview.
2. Say **checkpoint** (or *accepted* / *reorganize*) → agent moves to repo layout, adds `TestCases.java`, `NOTES.md`, moves `{id}.hint`, updates `INDEX.md`.
3. **`mvn test`** on the reorganized folder; `./scripts/commit_updates.sh` (fails if flat `LCexMain*` still present).

Flat extension artifacts (`LCexMain*.java`, `solutions/*.hint`, `.lcex_java_out/`) are **gitignored**. Reorganized `{id}.hint` inside problem folders **is** committed.

**New problems:** `Plans: senior-sdet-interview-prep` in the header comment. Older rows may show `leetcode-75` or `quest-problems` (historical).

**Agent:** checkpoint pipeline on trigger words — preserve solution logic; strip `LCexMain*` on move.

## Workflow

### With extension (recommended)

1. Pick problem from **Senior SDET Interview Prep** in the extension sidebar.
2. Create file → solve in `solutions/LCexMain{id}.java`.
3. Submit from the problem webview (Sign In required for server submit).
4. Agent: **checkpoint** → repo layout + tests + notes + `INDEX.md`.
5. `mvn test` → `./scripts/commit_updates.sh` → hook pushes.

### Without extension

1. Create folder `solutions/[category]/[id-name]/` manually.
2. Implement in `Solution.java`.
3. Ask agent for `TestCases.java` + `NOTES.md` when ready.
4. `mvn test` → commit.
