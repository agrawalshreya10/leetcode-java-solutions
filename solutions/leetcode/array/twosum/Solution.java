// LC-1 | Category: array | Difficulty: easy | Patterns: hash-map | Plans: senior-sdet-interview-prep
package leetcode.array.twosum;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

import java.util.*;

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexPair = new int[2];
        Map<Integer, Integer> lookUpMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
                if (lookUpMap.containsKey(complement) && lookUpMap.get(complement) != i){
                    indexPair[0] = lookUpMap.get(complement).intValue();
                indexPair[1] = i;
            } else
                lookUpMap.put(nums[i], i);
        }
        return indexPair;
    }
}
// @lc code=end
