package beercraft.ingredients;

import beercraft.util.Executable;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import java.util.*;

public class GetGlobalIngredientsQuery implements Executable<List<Map<String, Object>>> {
    private Table table;

    public GetGlobalIngredientsQuery(Table table) {
        this.table = table;
    }

    @Override
    public List<Map<String, Object>> execute() {
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
        List<Map<String, Object>> jsonItems = new ArrayList<>();
        while (iterator.hasNext()) {
            jsonItems.add(iterator.next().asMap());
        }

        return jsonItems;
    }
}
