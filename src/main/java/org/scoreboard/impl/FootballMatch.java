package org.scoreboard.impl;

import lombok.Getter;
import org.scoreboard.core.Match;

import java.time.Instant;
import java.util.UUID;


@Getter
public class FootballMatch implements Match {

    private final UUID id;
    private String homeTeamName;
    private String awayTeamName;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;
    private final Instant startDate;

    FootballMatch(String homeTeamName, String awayTeamName) {
        this.id = UUID.randomUUID();
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.startDate = Instant.now();
    }

    @Override
    public void updateScore(int teamOneScore, int teamTwoScore) {
        //TODO: add implementation
    }
}
