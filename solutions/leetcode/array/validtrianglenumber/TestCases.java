package leetcode.array.validtrianglenumber;

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
        assertEquals(3, solution.triangleNumber(new int[]{2, 2, 3, 4}));
    }

    @Test
    void example2() {
        assertEquals(4, solution.triangleNumber(new int[]{4, 2, 3, 4}));
    }

    @Test
    void fewerThanThree() {
        assertEquals(0, solution.triangleNumber(new int[]{1, 2}));
        assertEquals(0, solution.triangleNumber(new int[]{}));
    }

    @Test
    void noValidTriangles() {
        // largest side dominates every pair
        assertEquals(0, solution.triangleNumber(new int[]{1, 2, 3, 10}));
    }

    @Test
    void threeOnesAndLarge() {
        // only (1,1,1) works; 1+1 <= 10
        assertEquals(1, solution.triangleNumber(new int[]{1, 1, 1, 10}));
    }

    @Test
    void allEqual() {
        // every triplet of equal sides forms a triangle
        assertEquals(1, solution.triangleNumber(new int[]{5, 5, 5}));
        assertEquals(4, solution.triangleNumber(new int[]{2, 2, 2, 2}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int expected) {
        assertEquals(expected, solution.triangleNumber(nums));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{1, 2, 3}, 0),
                Arguments.of(new int[]{2, 3, 4, 5, 6}, 7)
        );
    }
}
