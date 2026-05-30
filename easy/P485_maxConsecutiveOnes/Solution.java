/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int counter = 0;
       int max = 0;
       for (int i = 0; i < nums.length; i++){
        if (nums[i] == 1){
            counter++;
            if (max < counter)
                max = counter;
        } else 
            counter = 0;
       } 
       return max;
    }
}
// @lc code=end

