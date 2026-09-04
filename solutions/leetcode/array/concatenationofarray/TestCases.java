package leetcode.array.concatenationofarray;

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
        assertArrayEquals(
                new int[]{1, 2, 1, 2},
                solution.getConcatenation(new int[]{1, 2})
        );
    }

    @Test
    void example2() {
        assertArrayEquals(
                new int[]{1, 3, 2, 1, 3, 2},
                solution.getConcatenation(new int[]{1, 3, 2})
        );
    }

    @Test
    void singleElement() {
        assertArrayEquals(
                new int[]{5, 5},
                solution.getConcatenation(new int[]{5})
        );
    }

    @Test
    void emptyArray() {
        assertArrayEquals(new int[]{}, solution.getConcatenation(new int[]{}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int[] expected) {
        assertArrayEquals(expected, solution.getConcatenation(nums));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0}, new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{-1, 2, -3}, new int[]{-1, 2, -3, -1, 2, -3})
        );
    }
}
