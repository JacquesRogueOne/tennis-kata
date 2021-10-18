package tennis;

import java.util.Iterator;

public class Point implements Iterator<String> {
    public static final String LOVE = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";

    private String current;

    public Point() {
        current = "0";
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        switch (current) {
            case LOVE -> current = FIFTEEN;
            case FIFTEEN -> current = THIRTY;
            default -> current = LOVE;
        }
        return current;
    }
}
