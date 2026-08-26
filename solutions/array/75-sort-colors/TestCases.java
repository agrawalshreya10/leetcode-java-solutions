package leetcode.array.sortcolors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestCases {

    private final Solution solution = new Solution();

    private void assertSorted(int[] input, int[] expected) {
        solution.sortColors(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void example1() {
        assertSorted(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2});
    }

    @Test
    void example2() {
        assertSorted(new int[]{2, 0, 1}, new int[]{0, 1, 2});
    }

    @Test
    void alreadySorted() {
        assertSorted(new int[]{0, 1, 2}, new int[]{0, 1, 2});
    }

    @Test
    void allSame() {
        assertSorted(new int[]{1, 1, 1}, new int[]{1, 1, 1});
        assertSorted(new int[]{0, 0}, new int[]{0, 0});
        assertSorted(new int[]{2}, new int[]{2});
    }

    @Test
    void emptyArray() {
        assertSorted(new int[]{}, new int[]{});
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, int[] expected) {
        assertSorted(Arrays.copyOf(nums, nums.length), expected);
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 0, 0, 1}, new int[]{0, 0, 1, 2, 2}),
                Arguments.of(new int[]{1, 0}, new int[]{0, 1}),
                Arguments.of(new int[]{2, 1}, new int[]{1, 2})
        );
    }
}
