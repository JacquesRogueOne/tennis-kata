package tennis;

import java.util.Iterator;

public class Point implements Iterator<String> {
    public static final String LOVE = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";

    private String value;

    public String getValue() {
        return value;
    }

    public Point() {
        value = "0";
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        switch (value) {
            case LOVE -> value = FIFTEEN;
            case FIFTEEN -> value = THIRTY;
            default -> value = LOVE;
        }
        return value;
    }
}
