package leetcode.array.threesum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCases {

    private final Solution solution = new Solution();

    private static void assertTripletsEqual(List<List<Integer>> expected, List<List<Integer>> actual) {
        Set<List<Integer>> exp = new HashSet<>(expected);
        Set<List<Integer>> act = new HashSet<>(actual);
        assertEquals(exp, act, () -> "expected " + exp + " but got " + act);
    }

    @Test
    void example1() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1));
        assertTripletsEqual(expected, solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    @Test
    void example2() {
        assertTrue(solution.threeSum(new int[]{0, 1, 1}).isEmpty());
    }

    @Test
    void example3() {
        List<List<Integer>> expected = List.of(Arrays.asList(0, 0, 0));
        assertTripletsEqual(expected, solution.threeSum(new int[]{0, 0, 0}));
    }

    @Test
    void fewerThanThreeElements() {
        assertTrue(solution.threeSum(new int[]{1, 2}).isEmpty());
        assertTrue(solution.threeSum(new int[]{}).isEmpty());
    }

    @Test
    void allPositive() {
        assertTrue(solution.threeSum(new int[]{1, 2, 3, 4}).isEmpty());
    }

    @Test
    void duplicateValuesSingleTriplet() {
        List<List<Integer>> expected = List.of(Arrays.asList(-2, 0, 2));
        assertTripletsEqual(expected, solution.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] nums, List<List<Integer>> expected) {
        assertTripletsEqual(expected, solution.threeSum(nums));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1}, List.of(Arrays.asList(-1, 0, 1))),
                Arguments.of(new int[]{3, -2, 1, 0}, List.of())
        );
    }
}
