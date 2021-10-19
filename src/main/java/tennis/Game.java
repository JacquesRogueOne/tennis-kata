package tennis;

final class Game {
    private final Score score;
    private boolean leftPlayerWinTheGame;
    private boolean rightPlayerWinTheGame;

    public Game() {
        this(new Score());
    }

    Game(Score score) {
        this.score = score;
    }

    public String score() {
        return
                score.getLeftPoint().getValue() +
                Score.SEPARATOR +
                score.getRightPoint().getValue();
    }

    void leftPlayerScore() {
        score.incrementLeftPoint();
        leftPlayerWinTheGame = score.hasLeftPlayerWin();
    }

    void rightPlayerScore() {
        score.incrementRightPoint();
        rightPlayerWinTheGame = score.hasRightPlayerWin();
    }

    public boolean isLeftPlayerWinTheGame() {
        return leftPlayerWinTheGame;
    }

    public boolean isRightPlayerWinTheGame() {
        return rightPlayerWinTheGame;
    }
}
