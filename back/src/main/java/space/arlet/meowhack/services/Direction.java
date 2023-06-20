package space.arlet.meowhack.services;

import java.util.Arrays;

public enum Direction {
    ECO("eco"),
    FIT("fit"),
    FRIENDLY("friendly"),
    HEALTHY("healthy"),
    OPEN("open"),
    PRO("pro");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public static Direction from(String val) {
        return Arrays.stream(values()).filter(it -> it.direction.equalsIgnoreCase(val)).findAny().orElseThrow();
    }
}
