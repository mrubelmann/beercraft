package beercraft.ingredients;

import beercraft.util.Executable;
import beercraft.util.QueryResult;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import java.util.*;

/**
 * Gets all of the ingredients that are shared globally.
 */
public class GetGlobalIngredientsQuery implements Executable<QueryResult> {
    private Table table;

    public GetGlobalIngredientsQuery(Table table) {
        this.table = table;
    }

    @Override
    public QueryResult execute() {
        // Search for everything with "ingredient" for a partition key.
        QuerySpec spec = new QuerySpec()
            .withKeyConditionExpression("PK = :v_partition")
            .withValueMap(new ValueMap()
                .withString(":v_partition", "ingredient"));
        if(spec == null) {
            throw new RuntimeException("Error creating query spec for ingredient partition");
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
