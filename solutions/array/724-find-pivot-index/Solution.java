// LC-724 | Category: array | Difficulty: easy | Patterns: prefix-sum | Plans: leetcode-75

/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        for (int j = 0; j < n; j++) {
            int rightSum = totalSum - leftSum - nums[j];
            if (leftSum == rightSum) {
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }
}
// @lc code=end
