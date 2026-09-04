package leetcode.string.reversevowelsofastring;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCases {

    private final Solution solution = new Solution();

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void example1() {
        assertEquals("AceEdi", solution.reverseVowels("IceEdi"));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void example2() {
        assertEquals("leotcede", solution.reverseVowels("leetcode"));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void singleChar_vowel() {
        assertEquals("a", solution.reverseVowels("a"));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void singleChar_consonant() {
        assertEquals("b", solution.reverseVowels("b"));
    }

    @Disabled("WIP — enable after Solution is complete")
    @Test
    void emptyString() {
        assertEquals("", solution.reverseVowels(""));
    }

    @Disabled("WIP — enable after Solution is complete")
    @ParameterizedTest
    @MethodSource("edgeCases")
    void parameterizedCases(String input, String expected) {
        assertEquals(expected, solution.reverseVowels(input));
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                Arguments.of("aA", "Aa"),
                Arguments.of("race a car", "race a car"),
                Arguments.of(
                        "Marge, let's \"[went.\" I await ]news[, you?",
                        "Marge, let's \"[went.\" I await ]news[, you?"
                )
        );
    }
}
