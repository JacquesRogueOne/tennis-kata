package tennis;

import java.util.Objects;

final class Match {
    private final String status;
    private final Game game;

    Match() {
        this.status = "In Progress";
        game = new Game();
    }

    public String getStatus() {
        return status;
    }

    public void firstPlayerScore() {
        game.leftPlayerScore();
    }

    public void secondPlayerScore() {
        game.rightPlayerScore();
    }

    public String currentGameScore() {
        return game.representation();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Match) obj;
        return Objects.equals(this.status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return "Match[" +
                "status=" + status + ']';
    }
}
