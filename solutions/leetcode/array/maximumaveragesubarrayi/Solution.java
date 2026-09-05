// LC-643 | Category: array | Difficulty: easy | Patterns: sliding-window | Plans: senior-sdet-interview-prep
package leetcode.array.maximumaveragesubarrayi;

/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double n = nums.length;
        double maxSum;  // best window sum so far (avg = sum / k)
        int sum = 0;    // current fixed-size window sum

        // seed window: first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;

        // slide: add right edge, drop left edge — O(1) per step
        for (int j = k; j < n; j++) {
            sum += nums[j];
            sum -= nums[j - k];
            maxSum = (sum > maxSum) ? sum : maxSum;  // keep global best sum
        }

        // max average == max sum / k (same k for every window)
        return Double.valueOf(maxSum / k);
    }
}
// @lc code=end
