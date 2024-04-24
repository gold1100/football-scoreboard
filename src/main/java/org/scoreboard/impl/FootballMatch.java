package org.scoreboard.impl;

import lombok.Getter;
import org.scoreboard.core.Match;

import java.time.Instant;
import java.util.UUID;


@Getter
public class FootballMatch implements Match {

    private final UUID id;
    private final String homeTeamName;
    private final String awayTeamName;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;
    private final Instant startDate;

    public FootballMatch(String homeTeamName, String awayTeamName, Instant startDate) {
        this.id = UUID.randomUUID();
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.startDate = startDate;
    }

    @Override
    public void updateScore(int homeTeamScore, int awayTeamScore) {
        validateIsNonNegative(homeTeamScore);
        validateIsNonNegative(awayTeamScore);
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    @Override
    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    private void validateIsNonNegative(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be less than 0");
        }
    }
}
