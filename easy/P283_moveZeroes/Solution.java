/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            int[] indices = new int[n];
            Arrays.fill(indices, -1);
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    indices[j++] = i;
                }
            }
            for (int k = 0; k < n; k++) {
                if (indices[k] != (-1))
                    nums[k] = nums[indices[k]];
                else
                    nums[k] = 0;
            }
        }

    }
}
// @lc code=end

