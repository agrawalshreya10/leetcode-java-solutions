/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        while (n > 0) {
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    if ((i == 0 || flowerbed[i - 1] == 0) &&
                            ((i + 1) == flowerbed.length || flowerbed[i + 1] == 0)) {
                        flowerbed[i] = 1;
                        n -= 1;
                    }
                }
                if (n <= 0)
                    return true;
            }
            if (n > 0)
                return false;
            else
                return true;
        }
        return true;
    }
}
// @lc code=end
