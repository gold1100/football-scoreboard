package org.scoreboard.impl;

import lombok.Getter;
import org.scoreboard.core.Scoreboard;
import org.scoreboard.exception.MatchNotFoundException;

import java.time.Instant;
import java.util.*;

@Getter
public class FootballScoreboard implements Scoreboard<FootballMatch> {

    private final Map<UUID, FootballMatch> matches;

    public FootballScoreboard() {
        matches = new HashMap<>();
    }

    @Override
    public FootballMatch startMatch(String homeTeam, String awayTeam, Instant startDate) {
        if (homeTeam == null) {
            throw new IllegalArgumentException("Home team name cannot be null");
        }
        if (awayTeam == null) {
            throw new IllegalArgumentException("Away team name cannot be null");
        }
        validateMatchDoesNotExist(homeTeam, awayTeam);

        FootballMatch newMatch = new FootballMatch(homeTeam, awayTeam, startDate);
        matches.put(newMatch.getId(), newMatch);
        return newMatch;
    }

    public FootballMatch startMatch(String homeTeam, String awayTeam) {
        return startMatch(homeTeam, awayTeam, Instant.now());
    }


    @Override
    public void finishMatch(UUID matchId) {
        if (!matches.containsKey(matchId)) {
            throw new MatchNotFoundException(String.format("Match with id: %s not found", matchId));
        }
        matches.remove(matchId);
    }

    @Override
    public List<FootballMatch> getSummary() {
        return matches.values().stream()
                .sorted(Comparator.comparing(FootballMatch::getTotalScore)
                        .thenComparing(FootballMatch::getStartDate).reversed())
                .toList();
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
