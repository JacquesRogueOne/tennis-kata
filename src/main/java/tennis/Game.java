package tennis;

final class Game {
    private final Score score;

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
    }

    void rightPlayerScore() {
        score.incrementRightPoint();
    }
}
