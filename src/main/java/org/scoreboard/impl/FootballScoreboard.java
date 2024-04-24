package org.scoreboard.impl;

import lombok.Getter;
import org.scoreboard.core.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Getter
public class FootballScoreboard implements Scoreboard {

    private final Map<UUID, FootballMatch> matches;

    public FootballScoreboard() {
        matches = new HashMap<>();
    }


    public FootballMatch startMatch(String homeTeam, String awayTeam) {
        if (homeTeam == null) {
            throw new IllegalArgumentException("Home team name cannot be null");
        }
        if (awayTeam == null) {
            throw new IllegalArgumentException("Away team name cannot be null");
        }
        validateMatchDoesNotExist(homeTeam, awayTeam);

        FootballMatch newMatch = new FootballMatch(homeTeam, awayTeam);
        matches.put(newMatch.getId(), newMatch);
        return newMatch;
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

    private void validateMatchDoesNotExist(String homeTeam, String awayTeam) {
        Optional<FootballMatch> existingMatch = matches.values().stream()
                .filter(match -> match.getHomeTeamName().equals(homeTeam) && match.getAwayTeamName().equals(awayTeam))
                .findAny();
        existingMatch.ifPresent(match -> {
            throw new IllegalStateException("A match between " + homeTeam + " and " + awayTeam + " already exists.");
        });
    }


}
