// LC-283 | Category: array | Difficulty: easy | Patterns: two-pointers | Plans: leetcode-75
package leetcode.array.movezeroes;

/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }

            while (j < n) {
                nums[j] = 0;
                j++;
            }
        }
    }
}
// @lc code=end
