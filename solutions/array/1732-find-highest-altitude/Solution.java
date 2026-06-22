// LC-1732 | Category: array | Difficulty: easy | Patterns: prefix-sum | Plans: leetcode-75

/*
 * @lc app=leetcode id=1732 lang=java
 *
 * [1732] Find the Highest Altitude
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int highestAlt = 0;
        int currentAlt = 0;

        for (int i = 0; i < gain.length; i++) {
            currentAlt = currentAlt + gain[i];
            if (currentAlt > highestAlt) {
                highestAlt = currentAlt;
            }
        }
        return highestAlt;
    }
}
// @lc code=end
