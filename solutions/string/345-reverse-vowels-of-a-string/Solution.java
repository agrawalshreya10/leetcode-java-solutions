// LC-345 | Category: string | Difficulty: easy | Patterns: two-pointers | Plans: leetcode-75

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        // WIP: two-pointer approach — advance to vowels on both ends, then swap
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // TODO: skip non-vowels, swap vowels at left/right, move pointers
        }
        return s;
    }
}
// @lc code=end
