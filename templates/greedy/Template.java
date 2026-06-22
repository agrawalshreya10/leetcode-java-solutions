/**
 * Greedy template — adapt predicates to the problem.
 */
class GreedyTemplates {

    boolean canPlace(int[] slots, int required) {
        if (required == 0) {
            return true;
        }

        for (int i = 0; i < slots.length; i++) {
            if (isAvailable(slots, i) && neighborsFree(slots, i)) {
                slots[i] = 1;
                required--;
                if (required == 0) {
                    return true;
                }
            }
        }
        return required <= 0;
    }

    private boolean isAvailable(int[] slots, int i) {
        return slots[i] == 0;
    }

    private boolean neighborsFree(int[] slots, int i) {
        boolean leftFree = (i == 0) || (slots[i - 1] == 0);
        boolean rightFree = (i == slots.length - 1) || (slots[i + 1] == 0);
        return leftFree && rightFree;
    }
}
