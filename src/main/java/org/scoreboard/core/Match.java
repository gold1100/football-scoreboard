package org.scoreboard.core;

import java.util.UUID;

public interface Match {

    UUID getId();
    void updateScore(int teamOneScore, int teamTwoScore);

}
