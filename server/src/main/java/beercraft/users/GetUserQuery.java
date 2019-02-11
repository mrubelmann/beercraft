package beercraft.users;

import beercraft.util.QueryResult;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetUserQuery {
    static final Logger logger = LogManager.getLogger(GetUserQuery.class);

    private final Table table;
    private final String userId;

    public GetUserQuery(Table table, String userId) {
        this.table = table;
        this.userId = userId;
    }

    public QueryResult execute() {
        String partitionKey = "user_" + userId;
        logger.info(String.format("Retrieving data for user '%s'", userId));
        QuerySpec spec = new QuerySpec()
            .withKeyConditionExpression("PK = :v_partition")
            .withValueMap(new ValueMap()
                .withString(":v_partition", partitionKey));
        if(spec == null) {
            throw new RuntimeException(String.format("Error creating query spec for partition '%s'", partitionKey));
        }

        ItemCollection<QueryOutcome> items = table.query(spec);
        if(items == null) {
            throw new RuntimeException("Query returned null.");
        }

        // Go through the returned items and turn them into a list of attribute maps.
        Iterator<Item> iterator = items.iterator();
        QueryResult queryResult = new QueryResult();
        while (iterator.hasNext()) {
            queryResult.add(iterator.next().asMap());
        }

        return queryResult;
    }
}

