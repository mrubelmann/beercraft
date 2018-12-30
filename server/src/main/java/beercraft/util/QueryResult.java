package beercraft.util;

import java.util.*;

/**
 * A poor man's typedef. Yes, I know some consider this to be an anti-pattern, but {@code QueryResult} is far more
 * readable than {@code List<Map<String, Object>>}.
 */
public class QueryResult extends ArrayList<Map<String, Object>> {
}
