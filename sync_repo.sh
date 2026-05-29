#!/bin/bash

# Track all newly created or modified solutions
git add .

# Extract the modified Java file name from git status
MODIFIED_FILE=$(git status --porcelain | grep -E 'P[0-9]+_.*\.java$' | awk '{print $2}' | head -n 1)

if [ -z "$MODIFIED_FILE" ]; then
    echo "⚠️ No new completed Java solutions found to push."
    exit 0
fi

# Parse problem name out of the filepath (e.g., Easy/P1_TwoSum.java -> P1_TwoSum)
PROBLEM_NAME=$(basename "$MODIFIED_FILE" .java)

# Commit and Push
git commit -m "Solved: $PROBLEM_NAME"
git push origin main

echo "🚀 Successfully versioned and pushed $PROBLEM_NAME to GitHub!"