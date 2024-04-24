package org.scoreboard.core;

import java.util.UUID;

public interface Scoreboard {
    Match startMatch(String teamOne, String teamTwo);

    Object finishMatch(UUID matchId);

    Object getSummary();
}
