package leetcode.array.shufflethearray;

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
                new int[]{2, 3, 5, 4, 1, 7},
                solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)
        );
    }

    @Test
    void example2() {
        assertArrayEquals(
                new int[]{1, 2, 1, 2},
                solution.shuffle(new int[]{1, 1, 2, 2}, 2)
        );
    }

    @Test
    void singlePair() {
        assertArrayEquals(
                new int[]{5, 10},
                solution.shuffle(new int[]{5, 10}, 1)
        );
    }

    @Test
    void emptyInput() {
        assertArrayEquals(new int[]{}, solution.shuffle(new int[]{}, 0));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int n, int[] expected) {
        assertArrayEquals(expected, solution.shuffle(nums, n));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2, new int[]{1, 3, 2, 4}),
                Arguments.of(new int[]{0, 0, 0, 0}, 2, new int[]{0, 0, 0, 0})
        );
    }
}
