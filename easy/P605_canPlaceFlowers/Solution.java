/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Early exit: if no flowers need to be planted, return true immediately
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // Extract boundary checks for readability and correct evaluation
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1; // Plant the flower
                    n--;              // Properly decrement the target counter

                    // Early exit: stop processing if we've hit our target
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        // If the loop finishes and n is still greater than 0, we failed
        return n <= 0;
    }
}
// @lc code=end
