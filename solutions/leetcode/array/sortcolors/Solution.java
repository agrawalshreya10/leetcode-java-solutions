// LC-75 | Category: array | Difficulty: medium | Patterns: three-pointers | Plans: senior-sdet-interview-prep
package leetcode.array.sortcolors;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

import java.util.*;

// @lc code=start
class Solution {

    public void sortColors(int[] nums) {
        // Dutch National Flag — three partitions in one pass:
        // [0, start) = 0s | [start, mid) = 1s | [mid, end] = unknown | (end, n) = 2s
        int start = 0;              // next write slot for a 0
        int mid = 0;                // current candidate under inspection
        int end = nums.length - 1;  // next write slot for a 2

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    // swap into the 0-region; mid++ is safe — came from known [start, mid) or is 0
                    nums[mid] = nums[start];
                    nums[start] = 0;
                    start++;
                    mid++;
                    break;
                case 1:
                    // already in the middle band
                    mid++;
                    break;
                case 2:
                    // swap with end; do NOT mid++ — value pulled from end is still unknown
                    nums[mid] = nums[end];
                    nums[end] = 2;
                    end--;
                    break;
            }
        }
    }
}
// @lc code=end
