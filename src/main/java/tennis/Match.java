package tennis;

import java.util.Objects;

final class Match {
    private final String status;
    Match() {
        this.status = "In Progress";
    }

    public String getStatus() {
        return status;
    }

    private Game game;

    public void firstPlayerScore() {
        game = new Game("15 - 0");
    }

    public void secondPlayerScore() {
        game = new Game("0 - 15");
    }

    public String currentGameScore() {
        return game.score();
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
