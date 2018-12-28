package beercraft.users;

import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.Executable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class GetUserDatabaseRequestWorker implements Executable<List<Map<String, Object>>> {
    static final Logger logger = LogManager.getLogger(GetUserDatabaseRequestWorker.class);

    private GetGlobalIngredientsQuery globalIngredientsQuery;

    public GetUserDatabaseRequestWorker(GetGlobalIngredientsQuery globalIngredientsQuery) {
        this.globalIngredientsQuery = globalIngredientsQuery;
    }

    @Override
    public List<Map<String, Object>> execute() {
        // TODO: Query for user profile with ID from URL

        // Query for shared ingredients
        List<Map<String, Object>> globalIngredients = this.globalIngredientsQuery.execute();

        // TODO: Query for user ingredients
        // TODO: Query for user recipes
        // TODO: Query for shared equipment
        // TODO: Query for user equipment

        // Return everything we've queried for.
        return globalIngredients;
    }
}
