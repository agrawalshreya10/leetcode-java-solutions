package leetcode.array.containsduplicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCases {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    void example2() {
        assertFalse(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void example3() {
        assertTrue(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    void singleElement() {
        assertFalse(solution.containsDuplicate(new int[]{42}));
    }

    @Test
    void adjacentDuplicate() {
        assertTrue(solution.containsDuplicate(new int[]{7, 7}));
    }

    @Test
    void negativeValuesNoDuplicate() {
        assertFalse(solution.containsDuplicate(new int[]{-1, -2, -3}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, boolean expectedDuplicate) {
        if (expectedDuplicate) {
            assertTrue(solution.containsDuplicate(nums));
        } else {
            assertFalse(solution.containsDuplicate(nums));
        }
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, false),
                Arguments.of(new int[]{-5, 10, -5}, true)
        );
    }
}
