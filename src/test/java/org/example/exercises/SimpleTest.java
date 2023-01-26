package org.example.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

class SimpleTest {

    private static Stream<Arguments> casesOfPalindromes() {
        return Stream.of(
                Arguments.of("Anne I vote more cars race Rome to Vienna", true),
                Arguments.of("Hello World!", false),
                Arguments.of("Kayak", true),
                Arguments.of("Java", false)
        );
    }

    private static Stream<Arguments> casesOfLetterThatOccursMostOften() {
        return Stream.of(
                Arguments.of("baobab", 'b'),
                Arguments.of("long sentence with spaces", 'e'),
                Arguments.of("Hello World!", 'l')
        );
    }

    private static Stream<Arguments> casesOfReverseWordsInText() {
        return Stream.of(
                Arguments.of("Ala ma kota", "alA am atok"),
                Arguments.of("Kot ma ale", "toK am ela"),
                Arguments.of("Java is powerful!", "avaJ si !lufrewop")
        );
    }

    private static Stream<Arguments> casesOfThreeItemsInArrayAddUpToGivenNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(20, 303, 3, 4, 25), 49, true),
                Arguments.of(Arrays.asList(7, 3, 1), 10, false),
                Arguments.of(Arrays.asList(10, 30, 55, 25, 100), 140, true)
        );
    }

    private static Stream<Arguments> casesOfHowManyTimesEachLetterOccurInText() {
        return Stream.of(
                Arguments.of("Ala ma kota", new HashMap<Character, Integer>() {{
                    put('a', 4);
                    put('l', 1);
                    put('m', 1);
                    put('k', 1);
                    put('o', 1);
                    put('t', 1);
                }}),
                Arguments.of("Hello", new HashMap<Character, Integer>() {{
                    put('h', 1);
                    put('e', 1);
                    put('l', 2);
                    put('o', 1);
                }})
        );
    }

    @ParameterizedTest
    @MethodSource("casesOfPalindromes")
    void isPalindromeTest(final String input, boolean result) {
        Assertions.assertEquals(Simple.isPalindrome(input), result);
    }

    @ParameterizedTest
    @MethodSource("casesOfLetterThatOccursMostOften")
    void letterThatOccursMostOftenTest(final String input, char result) {
        Assertions.assertEquals(Simple.letterThatOccursMostOften(input), result);
    }

    @ParameterizedTest
    @MethodSource("casesOfReverseWordsInText")
    void reverseWordsInTextTest(final String input, final String result) {
        Assertions.assertEquals(Simple.reverseWordsInText(input), result);
    }

    @ParameterizedTest
    @MethodSource("casesOfThreeItemsInArrayAddUpToGivenNumber")
    void threeItemsInArrayAddUpToGivenNumberTest(List<Integer> list, int sum, boolean result) {
        Assertions.assertEquals(Simple.threeItemsInArrayAddUpToGivenNumber(list, sum), result);
    }

    @ParameterizedTest
    @MethodSource("casesOfHowManyTimesEachLetterOccurInText")
    void printHowManyTimesEachLetterOccurInText(final String input, HashMap<Character, Integer> result) {
        Assertions.assertEquals(Simple.printHowManyTimesEachLetterOccurInText(input), result);
    }
}