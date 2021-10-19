package tennis;

public class Score {
    public static final String SEPARATOR = " - ";

    private final Point leftPoint;
    private final Point rightPoint;

    public Score() {
        leftPoint = new Point();
        rightPoint = new Point();
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    public void incrementLeftPoint() {
        leftPoint.next();
    }

    public void incrementRightPoint() {
        rightPoint.next();
    }
}
