package leetcode.linkedlist.addtwonumbers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestCases {

    private final Solution solution = new Solution();

    private static ListNode list(int... values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static int[] toArray(ListNode head) {
        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }
        int[] values = new int[size];
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            values[i] = node.val;
            node = node.next;
        }
        return values;
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void example1() {
        ListNode result = solution.addTwoNumbers(list(2, 4, 3), list(5, 6, 4));
        assertEquals(new int[]{7, 0, 8}, toArray(result));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void example2_zeroNodes() {
        ListNode result = solution.addTwoNumbers(list(0), list(0));
        assertEquals(new int[]{0}, toArray(result));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void unequalLengths_withCarry() {
        ListNode result = solution.addTwoNumbers(list(9, 9, 9, 9, 9, 9, 9), list(9, 9, 9, 9));
        assertEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, toArray(result));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void oneListNull_returnsOther() {
        ListNode l2 = list(1, 2, 3);
        assertEquals(new int[]{1, 2, 3}, toArray(solution.addTwoNumbers(null, l2)));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void bothNull() {
        assertNull(solution.addTwoNumbers(null, null));
    }
}
