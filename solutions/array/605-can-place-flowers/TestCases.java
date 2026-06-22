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
        assertTrue(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }

    @Test
    void example2() {
        assertFalse(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    @Test
    void zeroFlowersRequired() {
        assertTrue(solution.canPlaceFlowers(new int[]{1, 1, 1}, 0));
    }

    @Test
    void emptyFlowerbed() {
        assertTrue(solution.canPlaceFlowers(new int[]{}, 0));
        assertFalse(solution.canPlaceFlowers(new int[]{}, 1));
    }

    @Test
    void singlePlot_empty() {
        assertTrue(solution.canPlaceFlowers(new int[]{0}, 1));
    }

    @Test
    void singlePlot_occupied() {
        assertFalse(solution.canPlaceFlowers(new int[]{1}, 1));
    }

    @Test
    void allEmpty_largeBed() {
        assertTrue(solution.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 2));
        assertFalse(solution.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 3));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] flowerbed, int n, boolean expected) {
        assertTrue(expected == solution.canPlaceFlowers(flowerbed, n));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0}, 1, true),
                Arguments.of(new int[]{0, 1, 0}, 1, false),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0}, 3, true)
        );
    }
}
