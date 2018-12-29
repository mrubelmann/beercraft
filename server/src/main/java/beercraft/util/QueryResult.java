package beercraft.util;

import java.util.*;
import java.util.function.Consumer;

/**
 * A simple container for the result of a query.  Its main reason for existing is readability elsewhere.
 */
public class QueryResult implements Iterable<Map<String, Object>> {
    private final List<Map<String, Object>> records;

    /**
     * @param records The list of records.
     */
    public QueryResult(List<Map<String, Object>> records) {
        this.records = records;
    }

    @Override
    public Iterator<Map<String, Object>> iterator() {
        return records.iterator();
    }

    @Override
    public void forEach(Consumer<? super Map<String, Object>> consumer) {
        records.forEach(consumer);
    }

    @Override
    public Spliterator<Map<String, Object>> spliterator() {
        return records.spliterator();
    }
}
