package org.scoreboard.scoreboard.football;

import org.junit.jupiter.api.Test;
import org.scoreboard.exception.MatchNotFoundException;
import org.scoreboard.impl.FootballScoreboard;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FinishMatchTest {

    FootballScoreboard footballScoreboard = new FootballScoreboard();

    @Test
    void shouldRemoveMatchFromScoreboardWhenFinished() {
        //given
        var match = footballScoreboard.startMatch("home", "away");
        var matchId = match.getId();

        assertTrue(footballScoreboard.getMatches().containsKey(matchId));

        //when
        footballScoreboard.finishMatch(matchId);

        //then
        assertFalse(footballScoreboard.getMatches().containsKey(matchId));
    }

    @Test
    void shouldThrowMatchNotFoundExceptionWhenMatchDoesNotExistInScoreboard() {
        var uuid = UUID.randomUUID();
        assertThrows(MatchNotFoundException.class, () -> footballScoreboard.finishMatch(uuid));
    }
}
