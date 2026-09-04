// LC-167 | Category: array | Difficulty: medium | Patterns: two-pointers | Plans: senior-sdet-interview-prep
package leetcode.array.twosumii;

/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int indexPair[] = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                indexPair[0] = i + 1;
                indexPair[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else
                j--;
        }
        return indexPair;
    }
}
// @lc code=end
