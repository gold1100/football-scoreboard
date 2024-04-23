package org.scoreboard.impl;

import lombok.Getter;
import org.scoreboard.core.Match;
import org.scoreboard.core.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class FootballScoreboard implements Scoreboard {

    Map<UUID, Match> matches;

    public FootballScoreboard() {
        matches = new HashMap<>();
    }

    @Override
    public Object startMatch(String homeTeam, String awayTeam) {
        //TODO: add implementation
        return null;
    }

    @Override
    public Object finishMatch(UUID matchId) {
        //TODO: add implementation
        return null;
    }

    @Override
    public Object getSummary() {
        //TODO: add implementation
        return null;
    }

}
