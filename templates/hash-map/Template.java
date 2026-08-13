import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Hash map / hash set skeletons for interview recall.
 * Prefer the smallest structure that answers the question (set vs map).
 */
public class Template {

    /** Membership / “seen before?” — O(n) time, O(n) space. */
    boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) {
                return true;
            }
        }
        return false;
    }

    /** Complement lookup with original indices — O(n) time, O(n) space. */
    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (indexByValue.containsKey(need)) {
                return new int[]{indexByValue.get(need), i};
            }
            indexByValue.put(nums[i], i);
        }
        return new int[0]; // problem usually guarantees a pair
    }
}
