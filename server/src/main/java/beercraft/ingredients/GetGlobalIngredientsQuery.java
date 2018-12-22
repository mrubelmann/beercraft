package beercraft.ingredients;

import beercraft.util.Executable;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetGlobalIngredientsQuery implements Executable<String> {
    static final Logger logger = LogManager.getLogger(GetGlobalIngredientsQuery.class);

    private Table table;

    public GetGlobalIngredientsQuery(Table table) {
        this.table = table;
    }

    @Override
    public String execute() {
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

        // Go through the returned items and turn them into a list of JSON strings.
        Iterator<Item> iterator = items.iterator();
        List<String> jsonItems = new ArrayList<>();
        while (iterator.hasNext()) {
            jsonItems.add(iterator.next().toJSON());
        }

        // Finally, wrap all the strings in a JSON array.
        return "[" + String.join(",", jsonItems) + "]";
    }
}
