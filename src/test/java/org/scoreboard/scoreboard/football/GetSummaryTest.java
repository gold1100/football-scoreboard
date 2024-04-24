package org.scoreboard.scoreboard.football;

import org.junit.jupiter.api.Test;
import org.scoreboard.impl.FootballScoreboard;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetSummaryTest {

    FootballScoreboard scoreboard = new FootballScoreboard();

    @Test
    void shouldReturnSortedListWhenScoreIsDifferent() {
        //given
        Instant startDate = Instant.now();
        prepareTestData(0, 6, startDate, startDate);

        //when
        var summary = scoreboard.getSummary();

        //then
        assertEquals(6, summary.get(0).getTotalScore());
        assertEquals(0, summary.get(1).getTotalScore());
    }

    @Test
    void shouldReturnSortedListWhenScoreIsEqual() {
        //given
        Instant expectedFirstDate = LocalDateTime.of(2022, 10, 1, 1, 1).toInstant(ZoneOffset.UTC);
        Instant expectedSecondDate = LocalDateTime.of(2021, 10, 1, 1, 1).toInstant(ZoneOffset.UTC);

        prepareTestData(6, 6, expectedSecondDate, expectedFirstDate);

        //when
        var summary = scoreboard.getSummary();

        //then
        assertEquals(6, summary.get(0).getTotalScore());
        assertEquals(expectedFirstDate, summary.get(0).getStartDate());
        //second element
        assertEquals(6, summary.get(1).getTotalScore());
        assertEquals(expectedSecondDate, summary.get(1).getStartDate());
    }

    @Test
    void shouldReturnEmptyListWhenNoMatchesPresent() {
        //when
        var summary = scoreboard.getSummary();

        //then
        assertNotNull(summary);
        assertEquals(0, summary.size());
    }

    private void prepareTestData(int matchOneTotalScore, int matchTwoTotalScore, Instant matchOneStartDate, Instant matchTwoStartDate) {
        var match1 = scoreboard.startMatch("home", "away", matchOneStartDate);
        var match2 = scoreboard.startMatch("home2", "away2", matchTwoStartDate);

        match1.updateScore(0, matchOneTotalScore);
        match2.updateScore(0, matchTwoTotalScore);
    }
}
