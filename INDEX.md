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
**Study plans** (`leetcode-75`, `top-interview-150`) and **patterns** live in the header comment on `Solution.java`.  
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

1. Create an empty `.leetcode` file in the repo root (activates the extension).
2. Configure language, study plan, and paths in `.leetcode` or local `.vscode/settings.json` — see extension docs for `leetcodePractice.*` keys.
3. Sign in: Command Palette → `LeetCode: Sign In`.
4. Submit/Test against `Solution.java` with `@lc` markers.

**Layout mismatch:** the extension generates flat files (e.g. `solutions/485.java`). This repo uses `solutions/[category]/[id-kebab-name]/Solution.java`. After creating a file via the extension, **move it** into the correct category folder and rename to `Solution.java`. Header comment tags are the source of truth for category, pattern, and plan.

**Agent:** when the user creates a problem via the extension, reorganize the flat file into repo layout automatically (folder, rename, package, header, `INDEX.md` row) — do not ask each time.

## Workflow

1. Pick problem → ensure folder exists under `solutions/[category]/[id-name]/`
2. Implement in `Solution.java`
3. Run `mvn test` against `TestCases.java`
4. Commit → hook pushes current branch
5. Submit via LeetCode extension when ready
6. Ask for annotation → SDET review appended to `NOTES.md`
