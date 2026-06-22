/**
 * Two-pointer templates (adapt method signature to the problem).
 */
class TwoPointerTemplates {

    // Write-pointer compaction
    void compact(int[] nums) {
        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (keep(nums[read])) {
                nums[write++] = nums[read];
            }
        }
    }

    // Converging pointers
    void converge(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // advance left/right, then apply action
            left++;
            right--;
        }
    }

    private boolean keep(int value) {
        return value != 0;
    }
}
