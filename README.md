# Live Football World Cup Scoreboard Library

This is a simple Java library implementation of a Live Football World Cup Scoreboard. The library allows users to manage
ongoing football matches, update their scores, finish matches, and retrieve a summary of matches in progress.

## Implementation Details

- The library uses in-memory storage (HashMap) to store ongoing matches.
- Each football match is represented by the `FootballMatch` class, which implements the `Match` interface.
- The `FootballScoreboard` class implements the `Scoreboard` interface to manage ongoing matches and provide match
  summaries.

## Notes - Extensibility and Possible Improvements

- Currently, this library can only support sports that scores can be represented by integers - such as football and
  volleyball.
  Natural evolution to make the library more extendable would be to define a `Score` abstraction - this would enable
  support for sports with non-integer scoring systems, such as tennis.
- Instead of adding matches based solely on team names, consider allowing users to work directly with `Match` instances
  when interacting with the scoreboard. This approach provides users with more flexibility and allows for a wider range
  of use cases.

## Features

<details>
 <summary></summary>

### 1. Start a New Match

Users can start a new football match by providing the names of the home team and away team. The match is added to the
scoreboard with an initial score of 0-0.

### 2. Update Score

Users can update the score of a match by providing the absolute scores for the home team and away team.

### 3. Finish Match

Users can finish a match that is currently in progress. This removes the match from the scoreboard.

### 4. Get Summary of Matches in Progress

Users can retrieve a summary of matches in progress, ordered by their total score. Matches with the same total score are
ordered by the most recently started match.
</details>