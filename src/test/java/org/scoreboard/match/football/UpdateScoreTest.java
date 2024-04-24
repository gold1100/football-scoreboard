package org.scoreboard.match.football;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.scoreboard.impl.FootballMatch;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpdateScoreTest {

    public static Stream<Arguments> negativeScoreArguments() {
        return Stream.of(
                Arguments.of(
                        -1, 3
                ),
                Arguments.of(
                        3, -1
                ),
                Arguments.of(-1, -1)
        );
    }

    @Test
    void shouldCorrectlyUpdateScore() {
        //given
        int updatedHomeScore = 3;
        int updatedAwayScore = 2;
        FootballMatch match = new FootballMatch("home", "away");

        //when
        match.updateScore(updatedHomeScore, updatedAwayScore);

        //then
        assertEquals(updatedHomeScore, match.getHomeTeamScore());
        assertEquals(updatedAwayScore, match.getAwayTeamScore());
    }

    @ParameterizedTest
    @MethodSource("negativeScoreArguments")
    void shouldThrowIllegalArgumentExceptionWhenScoreIsNegative(int newHomeScore, int newAwayScore) {
        //given
        FootballMatch match = new FootballMatch("home", "away");

        //then
        assertThrows(IllegalArgumentException.class, () -> match.updateScore(newHomeScore, newAwayScore));
    }
}
