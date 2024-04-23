package org.scoreboard.impl;

import lombok.Getter;
import lombok.Setter;
import org.scoreboard.core.Match;

import java.time.Instant;
import java.util.UUID;


@Setter
@Getter
class FootballMatch implements Match {

    private UUID id;
    private String homeTeamName;
    private String awayTeamName;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;
    private Instant startDate;


    @Override
    public void updateScore(int teamOneScore, int teamTwoScore) {
        //TODO: add implementation
    }
}
