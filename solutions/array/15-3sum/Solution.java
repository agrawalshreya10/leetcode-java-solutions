// LC-15 | Category: array | Difficulty: medium | Patterns: two-pointers | Plans: senior-sdet-interview-prep
package leetcode.array.threesum;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

import java.util.*;

// @lc code=start
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set <List<Integer>> listOfTriplets = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        int sum;
        for (int i = 0; i < (n-2); i++){
            int left = i + 1;
            int right = n - 1;

            while (left < right){
                sum = nums[i] + nums[left] + nums[right];

                if (sum == 0){
                    listOfTriplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                    else
                    right--;
            }
        }
        return new ArrayList<>(listOfTriplets);
    }
}
// @lc code=end
