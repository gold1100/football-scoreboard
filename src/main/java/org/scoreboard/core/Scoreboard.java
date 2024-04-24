package org.scoreboard.core;

import java.util.UUID;

public interface Scoreboard {
    Match startMatch(String teamOne, String teamTwo);

    void finishMatch(UUID matchId);

    Object getSummary();
}
