/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        ArrayList<Integer> finalArray = new ArrayList<>();
        for (int i = 0; i < n; i++){
            finalArray.add(nums[i]);
            finalArray.add(nums[i+n]);
        }
        int[] result = new int[2*n];
        for (int i = 0; i < result.length; i++){
            result[i] = finalArray.get(i);
        }
        return result;
    }
}
// @lc code=end

