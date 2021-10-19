package tennis;

public class Score {
    public static final String SEPARATOR = " - ";

    private final Point leftPoint;
    private final Point rightPoint;
    private boolean leftPlayerWin;
    private boolean rightPlayerWin;
    private boolean deuce;
    private boolean advantageLeft;
    private boolean advantageRight;

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
        if (deuce) {
            advantageLeft = true;
            updateDeuceValueAfterAdvantage();
            return;
        }
        if (advantageRight) {
            advantageRight = false;
            updateDeuceValueAfterEquality();
            return;
        }
        if (leftPoint.isClosedToGoal()) {
            leftPlayerWin = true;
            return;
        }
        leftPoint.goToTheNextValue();
        updateDeuceValue();
    }

    private void updateDeuceValueAfterAdvantage() {
        deuce = advantageLeft && advantageRight;
    }

    private void updateDeuceValueAfterEquality() {
        deuce = !advantageLeft && !advantageRight;
    }

    private void updateDeuceValue() {
        deuce = rightPoint.isClosedToGoal() && leftPoint.isClosedToGoal();
    }

    public void incrementRightPoint() {
        if (deuce) {
            advantageRight = true;
            updateDeuceValueAfterAdvantage();
            return;
        }
        if (advantageLeft) {
            advantageLeft = false;
            updateDeuceValueAfterEquality();
            return;
        }
        if (rightPoint.isClosedToGoal()) {
            rightPlayerWin = true;
            return;
        }
        rightPoint.goToTheNextValue();
        updateDeuceValue();
    }

    public boolean hasLeftPlayerWin() {
        return leftPlayerWin;
    }

    public boolean hasRightPlayerWin() {
        return rightPlayerWin;
    }

    public boolean isDeuce() {
        return deuce;
    }

    public boolean isAdvantageLeft() {
        return advantageLeft;
    }
    public boolean isAdvantageRight() {
        return advantageRight;
    }
}
