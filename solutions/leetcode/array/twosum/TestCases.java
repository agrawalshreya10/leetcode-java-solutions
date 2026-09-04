package leetcode.array.twosum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCases {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void example2() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    void example3() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    void pairAtEnds() {
        assertArrayEquals(new int[]{0, 3}, solution.twoSum(new int[]{4, 1, 2, 4}, 8));
    }

    @Test
    void negatives() {
        assertArrayEquals(new int[]{0, 2}, solution.twoSum(new int[]{-3, 4, 3, 90}, 0));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int target, int[] expected) {
        int[] actual = solution.twoSum(nums, target);
        assertEquals(2, actual.length);
        assertEquals(target, nums[actual[0]] + nums[actual[1]]);
        assertTrue(actual[0] != actual[1]);
        int[] sortedActual = Arrays.copyOf(actual, 2);
        int[] sortedExpected = Arrays.copyOf(expected, 2);
        Arrays.sort(sortedActual);
        Arrays.sort(sortedExpected);
        assertArrayEquals(sortedExpected, sortedActual);
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 5}, 10, new int[]{1, 2}),
                Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3})
        );
    }
}
