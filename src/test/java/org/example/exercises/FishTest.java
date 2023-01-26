package org.example.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FishTest {

    private static Stream<Arguments> casesOfHowManyTimesFishComeOut() {
        return Stream.of(
                Arguments.of("uuddduudduu", 3),
                Arguments.of("ddduuuudddduuuu", 2),
                Arguments.of("uudddduuudduuuudddduuddduuu", 5),
                Arguments.of("ddddduuuuudduuu", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesOfHowManyTimesFishComeOut")
    void howManyTimesFishComeOut(final String input, int result) {
        Assertions.assertEquals(Fish.howManyTimesFishComeOut(input), result);
    }
}