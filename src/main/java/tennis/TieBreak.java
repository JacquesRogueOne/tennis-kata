package tennis;

import static tennis.ScoreAPoint.LEFT_PLAYER;
import static tennis.ScoreAPoint.RIGHT_PLAYER;

public class TieBreak {

    public static final String INITIAL = "0 - 0";

    public String getInitialState() {
        return INITIAL;
    }

    public String operateTransition(ScoreAPoint player) {
        return operateTransition(INITIAL, player);
    }

    public String operateTransition(String state, ScoreAPoint player) {
        var split = state.split(" ");

        var leftScore = Integer.parseInt(split[0]);
        leftScore += player.equals(LEFT_PLAYER) ? 1 : 0;

        var rightScore = Integer.parseInt(split[split.length - 1]);
        rightScore += player.equals(RIGHT_PLAYER) ? 1 : 0;

        if (leftScore >= 7 && (leftScore - rightScore) >= 2) {
            return "LEFT WIN";
        }

        if (rightScore >= 7 && (rightScore - leftScore) >= 2) {
            return "RIGHT WIN";
        }

        return leftScore + " - " + rightScore;
    }
}
