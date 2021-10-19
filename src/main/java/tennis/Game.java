package tennis;

import java.util.HashMap;
import java.util.Map;

import static tennis.Game.ScoreAPoint.LEFT_PLAYER;
import static tennis.Game.ScoreAPoint.RIGHT_PLAYER;

public class Game {

    public static final String INITIAL = "0 - 0";
    public static final String FIFTEEN_LOVE = "15 - 0";
    public static final String LOVE_FIFTEEN = "0 - 15";
    public static final String THIRTY_LOVE = "30 - 0";
    public static final String LOVE_THIRTY = "0 - 30";
    public static final String FORTY_LOVE = "40 - 0";
    public static final String LOVE_FORTY = "0 - 40";
    public static final String FIFTEEN_A = "15 - 15";
    public static final String THIRTY_A = "30 - 30";
    public static final String FORTY_A = "40 - 40";
    public static final String FIFTEEN_THIRTY = "15 - 30";
    public static final String THIRTY_FIFTEEN = "30 - 15";
    public static final String FIFTEEN_FORTY = "15 - 40";
    public static final String FORTY_FIFTEEN = "40 - 15";
    public static final String THIRTY_FORTY = "30 - 40";
    public static final String FORTY_THIRTY = "40 - 30";
    public static final String RIGHT_WIN = "RIGHT WIN";
    public static final String LEFT_WIN = "LEFT WIN";
    public static final String ADVANTAGE_LEFT = "ADVANTAGE LEFT";
    public static final String ADVANTAGE_RIGHT = "ADVANTAGE RIGHT";
    public static final String DEUCE = "DEUCE";

    static Map<String, Map<ScoreAPoint, String>> states;
    static{
        states = new HashMap<>();
        states.put(INITIAL, Map.of(
                LEFT_PLAYER, FIFTEEN_LOVE,
                RIGHT_PLAYER, LOVE_FIFTEEN
        ));
        states.put(FIFTEEN_LOVE, Map.of(
                LEFT_PLAYER, THIRTY_LOVE,
                RIGHT_PLAYER, FIFTEEN_A
        ));
        states.put(LOVE_FIFTEEN, Map.of(
                RIGHT_PLAYER, LOVE_THIRTY,
                LEFT_PLAYER, FIFTEEN_A
        ));
        states.put(FIFTEEN_A, Map.of(
                RIGHT_PLAYER, FIFTEEN_THIRTY,
                LEFT_PLAYER, THIRTY_FIFTEEN
        ));
        states.put(FIFTEEN_THIRTY, Map.of(
                RIGHT_PLAYER, FIFTEEN_FORTY,
                LEFT_PLAYER, THIRTY_A
        ));
        states.put(THIRTY_FIFTEEN, Map.of(
                RIGHT_PLAYER, THIRTY_A,
                LEFT_PLAYER, FORTY_FIFTEEN
        ));
        states.put(THIRTY_A, Map.of(
                RIGHT_PLAYER, THIRTY_FORTY,
                LEFT_PLAYER, FORTY_THIRTY
        ));
        states.put(THIRTY_FORTY, Map.of(
                LEFT_PLAYER, FORTY_A,
                RIGHT_PLAYER, RIGHT_WIN
        ));
        states.put(THIRTY_LOVE, Map.of(
                LEFT_PLAYER, FORTY_LOVE,
                RIGHT_PLAYER, THIRTY_FIFTEEN
        ));
        states.put(LOVE_THIRTY, Map.of(
                RIGHT_PLAYER, LOVE_FORTY,
                LEFT_PLAYER, FIFTEEN_THIRTY
        ));
        states.put(LOVE_FORTY, Map.of(
                RIGHT_PLAYER, RIGHT_WIN,
                LEFT_PLAYER, FIFTEEN_FORTY
        ));
        states.put(FIFTEEN_FORTY, Map.of(
                RIGHT_PLAYER, RIGHT_WIN,
                LEFT_PLAYER, THIRTY_FORTY
        ));
        states.put(FORTY_LOVE, Map.of(
                LEFT_PLAYER, LEFT_WIN,
                RIGHT_PLAYER, FORTY_FIFTEEN
        ));
        states.put(FORTY_FIFTEEN, Map.of(
                LEFT_PLAYER, LEFT_WIN,
                RIGHT_PLAYER, FORTY_THIRTY
        ));
        states.put(FORTY_THIRTY, Map.of(
                LEFT_PLAYER, LEFT_WIN,
                RIGHT_PLAYER, FORTY_A
        ));
        states.put(FORTY_A, Map.of(
                LEFT_PLAYER, ADVANTAGE_LEFT,
                RIGHT_PLAYER, ADVANTAGE_RIGHT
        ));
        states.put(ADVANTAGE_LEFT, Map.of(
                LEFT_PLAYER, LEFT_WIN,
                RIGHT_PLAYER, DEUCE
        ));
        states.put(ADVANTAGE_RIGHT, Map.of(
                LEFT_PLAYER, DEUCE,
                RIGHT_PLAYER, RIGHT_WIN
        ));
    }

    public String getState() {
        return INITIAL;
    }

    public String operateTransition(ScoreAPoint player) {
        return operateTransition(INITIAL, player);
    }

    public String operateTransition(String state, ScoreAPoint player) {
        return states.get(state).get(player);
    }

    public boolean isAWinningState(String state) {
        return LEFT_WIN.equals(state) || RIGHT_WIN.equals(state);
    }

    enum ScoreAPoint {
        LEFT_PLAYER,
        RIGHT_PLAYER
    }

}
