/**
 * Prefix-sum templates.
 */
class PrefixSumTemplates {

    int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = total - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    int maxRunningPrefix(int[] deltas, int initial) {
        int running = initial;
        int best = initial;
        for (int delta : deltas) {
            running += delta;
            best = Math.max(best, running);
        }
        return best;
    }
}
