package org.scoreboard.scoreboard.football;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.scoreboard.impl.FootballScoreboard;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StartMatchTest {
    FootballScoreboard scoreboard = new FootballScoreboard();

    @Test
    void shouldStartNewMatch() {
        //given
        String homeTeam = "home";
        String awayTeam = "away";

        //when
        var result = scoreboard.startMatch(homeTeam, awayTeam);

        //then
        var matchId = result.getId();
        assertTrue(scoreboard.getMatches().containsKey(matchId));
        assertEquals(scoreboard.getMatches().get(matchId).getHomeTeamName(), homeTeam);
        assertEquals(scoreboard.getMatches().get(matchId).getAwayTeamName(), awayTeam);
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenMatchIsAlreadyOngoing() {
        //given
        String homeTeam = "home";
        String awayTeam = "away";

        //when
        scoreboard.startMatch(homeTeam, awayTeam);

        //then
        assertThrows(IllegalStateException.class, () -> scoreboard.startMatch(homeTeam, awayTeam));
    }

    @ParameterizedTest
    @MethodSource("nullNameArguments")
    void shouldThrowIllegalArgumentExceptionWhenNamesAreNull(String homeTeam, String awayTeam) {
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch(homeTeam, awayTeam));
    }

    public static Stream<Arguments> nullNameArguments() {
        return Stream.of(
                Arguments.of(
                        null,
                        "away"
                ),
                Arguments.of(
                        "home",
                        null
                ),
                Arguments.of(
                        null,
                        null
                )
        );
    }
}
