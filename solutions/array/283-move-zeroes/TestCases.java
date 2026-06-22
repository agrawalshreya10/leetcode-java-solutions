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
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void singleElement_nonZero() {
        int[] nums = {1};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    void singleElement_zero() {
        int[] nums = {0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    void allZeros() {
        int[] nums = {0, 0, 0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{0, 0, 0}, nums);
    }

    @Test
    void noZeros() {
        int[] nums = {1, 2, 3};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    void emptyArray() {
        int[] nums = {};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] input, int[] expected) {
        solution.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1}, new int[]{1, 0, 0}),
                Arguments.of(new int[]{1, 0, 0, 2, 0, 3}, new int[]{1, 2, 3, 0, 0, 0})
        );
    }
}
