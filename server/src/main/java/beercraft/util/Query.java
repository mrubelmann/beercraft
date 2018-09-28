package beercraft.util;

import java.io.IOException;

public interface Query<T> {
    T execute() throws IOException, IllegalAccessException, InstantiationException;
}
