#!/bin/bash
set -euo pipefail

REPO_ROOT="$(git rev-parse --show-toplevel)"
cd "$REPO_ROOT"

git config core.hooksPath .githooks
chmod +x .githooks/post-commit scripts/commit_updates.sh

echo "Git hooks installed. post-commit will push origin HEAD after every commit."
