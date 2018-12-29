package beercraft.users;

import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.Executable;
import beercraft.util.QueryResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Business logic needed to service GET requests to /users/{userId}/database
 */
public class GetUserDatabaseRequestWorker implements Executable<QueryResult> {
    static final Logger logger = LogManager.getLogger(GetUserDatabaseRequestWorker.class);

    private GetGlobalIngredientsQuery globalIngredientsQuery;

    public GetUserDatabaseRequestWorker(GetGlobalIngredientsQuery globalIngredientsQuery) {
        this.globalIngredientsQuery = globalIngredientsQuery;
    }

    @Override
    public QueryResult execute() {
        // TODO: Query for user profile with ID from URL

        // Query for shared ingredients
        QueryResult globalIngredients = this.globalIngredientsQuery.execute();

        // TODO: Query for user ingredients
        // TODO: Query for user recipes
        // TODO: Query for shared equipment
        // TODO: Query for user equipment

        // Return everything we've queried for.
        return globalIngredients;
    }
}
