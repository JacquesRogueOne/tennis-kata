package tennis;

import java.util.Iterator;
import java.util.Objects;

public class Point implements Iterator<String> {
    public static final String LOVE = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";
    public static final String FORTY = "40";

    private String value;

    public String getValue() {
        return value;
    }

    public Point() {
        value = LOVE;
    }

    Point(String value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return !value.equals(FORTY);
    }

    @Override
    public String next() {
        switch (value) {
            case LOVE -> value = FIFTEEN;
            case FIFTEEN -> value = THIRTY;
            case THIRTY -> value = FORTY;
            default -> value = LOVE;
        }
        return value;
    }

    @Override
    public String toString() {
        return "Point{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(value, point.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
