package leetcode.array.maxconsecutiveones;

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
        assertEquals(3, solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    void example2() {
        assertEquals(2, solution.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    @Test
    void allOnes() {
        assertEquals(4, solution.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1}));
    }

    @Test
    void allZeros() {
        assertEquals(0, solution.findMaxConsecutiveOnes(new int[]{0, 0, 0}));
    }

    @Test
    void singleOne() {
        assertEquals(1, solution.findMaxConsecutiveOnes(new int[]{1}));
    }

    @Test
    void singleZero() {
        assertEquals(0, solution.findMaxConsecutiveOnes(new int[]{0}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, solution.findMaxConsecutiveOnes(new int[]{}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int expected) {
        assertEquals(expected, solution.findMaxConsecutiveOnes(nums));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 1, 1}, 2),
                Arguments.of(new int[]{1, 0, 0, 1}, 1)
        );
    }
}
