package P1732_findHighestAltitude;
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
      for (int i = 0; i < gain.length; i++){
        currentAlt = currentAlt + gain[i];
        if (currentAlt > highestAlt)
            highestAlt = currentAlt;
      }
      return highestAlt;  
    }
}
// @lc code=end

