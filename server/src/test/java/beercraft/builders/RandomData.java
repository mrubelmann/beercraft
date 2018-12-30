package beercraft.builders;

import java.util.UUID;

public class RandomData {
    public static String getString() {
        return UUID.randomUUID().toString();
    }

    public static double getDouble() {
        return getDouble(1, 100);
    }

    public static double getDouble(double min, double max) {
        return Math.random() * (max - min) + min;
    }
}
