// LC-217 | Category: array | Difficulty: easy | Patterns: hash-set | Plans: senior-sdet-interview-prep
package leetcode.array.containsduplicate;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

import java.util.*;

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<Integer>();
        for (int i : nums){
            uniqueElements.add(i);
        }
        return (nums.length > uniqueElements.size()) ? true : false;
    }
}
// @lc code=end
