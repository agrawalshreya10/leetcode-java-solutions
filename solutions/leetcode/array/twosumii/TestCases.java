package leetcode.array.twosumii;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestCases {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void example2() {
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(new int[]{2, 3, 4}, 6));
    }

    @Test
    void example3() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{-1, 0}, -1));
    }

    @Test
    void pairAtEnds() {
        assertArrayEquals(new int[]{1, 4}, solution.twoSum(new int[]{1, 2, 3, 9}, 10));
    }

    @Test
    void duplicateValues() {
        assertArrayEquals(new int[]{2, 3}, solution.twoSum(new int[]{1, 3, 3, 7}, 6));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] numbers, int target, int[] expected) {
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{5, 25, 75}, 100, new int[]{2, 3}),
                Arguments.of(new int[]{-5, -3, 0, 2}, -8, new int[]{1, 2})
        );
    }
}
