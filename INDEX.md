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

## LeetCode extension (local setup — not committed)

Add to your **user** settings in Cursor/VS Code (do not commit personal paths to the repo). Set `leetcode.workspaceFolder` to the absolute path of your local clone, or use `${workspaceFolder}` in a local-only `.vscode/settings.json` if this repo is your opened workspace.

```json
{
  "leetcode.workspaceFolder": "/absolute/path/to/your/leetcode-java-2026-clone",
  "leetcode.defaultLanguage": "java",
  "leetcode.filePath": {
    "java": {
      "folder": "solutions/${tag}/${id}-${kebab-case-name}",
      "filename": "Solution.${ext}"
    }
  }
}
```

**Tag mismatch:** LeetCode `${tag}` may be `Array` while our folder is `array`. After creating a file via the extension, move it to the correct category folder if needed; keep the header comment as source of truth.

Sign in: Command Palette → `LeetCode: Sign In`. Submit/Test work on `Solution.java` with `@lc` markers.

## Workflow

1. Pick problem → ensure folder exists under `solutions/[category]/[id-name]/`
2. Implement in `Solution.java`
3. Run `mvn test` against `TestCases.java`
4. Commit → hook pushes current branch
5. Submit via LeetCode extension when ready
6. Ask for annotation → SDET review appended to `NOTES.md`
