package org.scoreboard.core;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface Scoreboard<T extends Match> {
    T startMatch(String teamOne, String teamTwo, Instant startDate);

    void finishMatch(UUID matchId);

    List<T> getSummary();
}
