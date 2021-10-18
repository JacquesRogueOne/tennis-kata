package tennis;

import java.util.Objects;

final class Game {
    private final String scoreRepresentation;
    private final Score score;

    Game(String score) {
        this.scoreRepresentation = score;
        this.score = new Score();
    }

    public String score() {
        String representation = score.getLeftPoint().getValue() + Score.SEPARATOR + score.getRightPoint().getValue();
        return scoreRepresentation != null ? scoreRepresentation : representation;
    }

    void leftPlayerScore() {
        score.getLeftPoint().next();
    }

    void rightPlayerScore() {
        score.getRightPoint().next();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Game) obj;
        return Objects.equals(this.scoreRepresentation, that.scoreRepresentation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreRepresentation);
    }

    @Override
    public String toString() {
        return "Game[" +
                "score=" + scoreRepresentation + ']';
    }

}
