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
        assertEquals(1, solution.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }

    @Test
    void example2() {
        assertEquals(0, solution.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    @Test
    void emptyGain() {
        assertEquals(0, solution.largestAltitude(new int[]{}));
    }

    @Test
    void singlePositiveGain() {
        assertEquals(5, solution.largestAltitude(new int[]{5}));
    }

    @Test
    void singleNegativeGain() {
        assertEquals(0, solution.largestAltitude(new int[]{-3}));
    }

    @Test
    void peakAtStart() {
        assertEquals(10, solution.largestAltitude(new int[]{10, -5, -5}));
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(int[] gain, int expected) {
        assertEquals(expected, solution.largestAltitude(gain));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{1, -1, 1, -1, 5}, 5),
                Arguments.of(new int[]{-1, -2, -3}, 0)
        );
    }
}
