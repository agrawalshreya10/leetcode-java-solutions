package leetcode.array.findpivotindex;

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
        assertEquals(3, solution.pivotIndex(new int[]{1, 2, 3, 8, 6}));
    }

    @Test
    void example2() {
        assertEquals(3, solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    void example3_noPivot() {
        assertEquals(-1, solution.pivotIndex(new int[]{1, 2, 3}));
    }

    @Test
    void singleElement() {
        assertEquals(0, solution.pivotIndex(new int[]{5}));
    }

    @Test
    void pivotAtStart() {
        assertEquals(2, solution.pivotIndex(new int[]{10, -10, 5}));
    }

    @Test
    void emptyArray() {
        assertEquals(-1, solution.pivotIndex(new int[]{}));
    }

    @Test
    void allZeros() {
        assertEquals(0, solution.pivotIndex(new int[]{0, 0, 0, 0}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int expected) {
        assertEquals(expected, solution.pivotIndex(nums));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, -1}, 0),
                Arguments.of(new int[]{-1, -1, -1, 0, 1, 1}, 0),
                Arguments.of(new int[]{1, 0, 1, 0, 1}, 2)
        );
    }
}
