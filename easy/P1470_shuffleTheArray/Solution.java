/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        int index = 0;
        for (int i = 0; i < n; i++){
            result[index++] = nums[i];
            result[index++] = nums[i+n];
        }      
        return result;
    }
}
// @lc code=end

