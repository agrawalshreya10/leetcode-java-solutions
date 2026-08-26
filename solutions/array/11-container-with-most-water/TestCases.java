package leetcode.array.containerwithmostwater;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCases {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void example2() {
        assertEquals(1, solution.maxArea(new int[]{1, 1}));
    }

    @Test
    void twoElementsUnequal() {
        assertEquals(1, solution.maxArea(new int[]{1, 2}));
        assertEquals(1, solution.maxArea(new int[]{2, 1}));
    }

    @Test
    void allEqual() {
        // width n-1, height h → (n-1)*h
        assertEquals(15, solution.maxArea(new int[]{5, 5, 5, 5}));
    }

    @Test
    void strictlyIncreasing() {
        // best is indices 1 and 3: min(2,4)*2 = 4
        assertEquals(4, solution.maxArea(new int[]{1, 2, 3, 4}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] height, int expected) {
        assertEquals(expected, solution.maxArea(height));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{4, 3, 2, 1, 4}, 16),
                Arguments.of(new int[]{1, 2, 1}, 2)
        );
    }
}
