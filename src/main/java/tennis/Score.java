package tennis;

public class Score {
    public static final String SEPARATOR = " - ";

    private final Point leftPoint;
    private final Point rightPoint;
    private boolean leftPlayerWin;
    private boolean rightPlayerWin;

    public Score() {
        this(new Point(), new Point());
    }

    Score(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    public void incrementLeftPoint() {
        if (leftPoint.isClosedToGoal()) {
            leftPlayerWin = true;
            return;
        }
        leftPoint.goToTheNextValue();
    }

    public void incrementRightPoint() {
        if (rightPoint.isClosedToGoal()) {
            rightPlayerWin = true;
            return;
        }
        rightPoint.goToTheNextValue();
    }

    public boolean hasLeftPlayerWin() {
        return leftPlayerWin;
    }

    public boolean hasRightPlayerWin() {
        return rightPlayerWin;
    }

    public boolean isDeuce() {
        return rightPoint.isClosedToGoal() && leftPoint.isClosedToGoal();
    }
}
