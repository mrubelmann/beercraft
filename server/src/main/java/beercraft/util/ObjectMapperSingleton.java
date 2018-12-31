package beercraft.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperSingleton {
    private static final ObjectMapper instance = new ObjectMapper();

    public static ObjectMapper getInstance() {
        return instance;
    }
}
