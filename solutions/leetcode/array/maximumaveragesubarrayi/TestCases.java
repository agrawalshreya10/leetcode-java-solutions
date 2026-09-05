package leetcode.array.maximumaveragesubarrayi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCases {

    private static final double EPS = 1e-5;

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals(12.75, solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), EPS);
    }

    @Test
    void example2() {
        assertEquals(5.0, solution.findMaxAverage(new int[]{5}, 1), EPS);
    }

    @Test
    void entireArrayIsWindow() {
        assertEquals(2.5, solution.findMaxAverage(new int[]{1, 2, 3, 4}, 4), EPS);
    }

    @Test
    void negativeWindows() {
        // best of [-1,-2]=-1.5 and [-2,-3]=-2.5 → -1.5
        assertEquals(-1.5, solution.findMaxAverage(new int[]{-1, -2, -3}, 2), EPS);
    }

    @Test
    void kEqualsOne() {
        assertEquals(50.0, solution.findMaxAverage(new int[]{1, 12, -5, 50}, 1), EPS);
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int k, double expected) {
        assertEquals(expected, solution.findMaxAverage(nums, k), EPS);
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0, 0}, 2, 0.0),
                Arguments.of(new int[]{9, 7, 3, 5, 6}, 2, 8.0),
                Arguments.of(new int[]{-6, -5, -4}, 3, -5.0)
        );
    }
}
