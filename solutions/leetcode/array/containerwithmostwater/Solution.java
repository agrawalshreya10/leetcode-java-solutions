// LC-11 | Category: array | Difficulty: medium | Patterns: two-pointers | Plans: senior-sdet-interview-prep
package leetcode.array.containerwithmostwater;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */


// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;                      // left wall
        int j = height.length - 1;      // right wall — start widest

        while (i < j) {
            // area limited by shorter wall; width shrinks as pointers move in
            int minHeight = height[i] < height[j] ? height[i] : height[j];
            int width = j - i;
            int area = minHeight * width;
            maxArea = area > maxArea ? area : maxArea;  // keep global best (not last area)

            // move the shorter side — keeping it can't beat current area with smaller width
            if (height[i] < height[j]) {
                i++;
            } else
                j--;  // height[i] >= height[j]: move right (or either when equal)
        }
        return maxArea;
    }
}
// @lc code=end
