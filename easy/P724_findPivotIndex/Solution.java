package P724_findPivotIndex;

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
        int rightSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            totalSum += nums[i];
        }
        for (int j = 0; j < n; j++){
            rightSum = totalSum - leftSum - nums[j];
            if (leftSum == rightSum)
                return j;
            else 
                leftSum += nums[j];
        }
        return -1;
    }
}
// @lc code=end

