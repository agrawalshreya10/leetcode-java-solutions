#!/bin/bash
# Stage solution/sql changes, commit with an appropriate message
# Push also runs automatically via .githooks/post-commit when hooks are installed.

set -euo pipefail

REPO_ROOT="$(git rev-parse --show-toplevel)"
cd "$REPO_ROOT"

git add solutions/ sql/ INDEX.md templates/ pom.xml scripts/ .githooks/

if git diff --cached --quiet; then
    echo "No staged changes in solutions/, sql/, or repo scaffolding."
    exit 0
fi

PROBLEM_NAME=""
while IFS= read -r file; do
    if [[ "$file" =~ solutions/[^/]+/([^/]+)/ ]]; then
        PROBLEM_NAME="${BASH_REMATCH[1]}"
        break
    fi
    if [[ "$file" =~ sql/([^/]+)/ ]]; then
        PROBLEM_NAME="${BASH_REMATCH[1]}"
        break
    fi
done < <(git diff --cached --name-only)

if [[ -n "$PROBLEM_NAME" ]]; then
    git commit -m "Solved: ${PROBLEM_NAME}"
else
    git commit -m "Update: practice repo scaffolding"
fi

echo "Committed on branch $(git rev-parse --abbrev-ref HEAD). Push runs via post-commit hook."
