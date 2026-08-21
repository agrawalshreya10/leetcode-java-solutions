// LC-611 | Category: array | Difficulty: medium | Patterns: two-pointers | Plans: senior-sdet-interview-prep
package leetcode.array.validtrianglenumber;

/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

import java.util.*;

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        int numOfTriplets = 0;
        Arrays.sort(nums);                                  
        for (int index = nums.length - 1; index > 1; index--){
            int i = 0;
            int j = index - 1;
            while (i < j){
                int sum = nums[i] + nums[j];
                if (nums[index] < sum){
                    numOfTriplets+= j-i;
                    j--;
                } else{
                    i++;
                }
                
            } 
        }
        return numOfTriplets;
    }
}
// @lc code=end
