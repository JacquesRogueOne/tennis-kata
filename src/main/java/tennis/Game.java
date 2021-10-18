package tennis;

final class Game {
    private final Score score;

    Game() {
        this.score = new Score();
    }

    public String score() {
        return
                score.getLeftPoint().getValue() +
                Score.SEPARATOR +
                score.getRightPoint().getValue();
    }

    void leftPlayerScore() {
        score.getLeftPoint().next();
    }

    void rightPlayerScore() {
        score.getRightPoint().next();
    }
}
