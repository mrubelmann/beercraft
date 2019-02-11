package beercraft.users;

import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.QueryResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Business logic needed to service GET requests to /users/{userId}/database
 */
public class GetUserDatabaseRequestWorker {
    static final Logger logger = LogManager.getLogger(GetUserDatabaseRequestWorker.class);

    private final GetGlobalIngredientsQuery globalIngredientsQuery;
    private final GetUserQuery getUserQuery;

    public GetUserDatabaseRequestWorker(GetGlobalIngredientsQuery globalIngredientsQuery, GetUserQuery getUserQuery) {
        this.globalIngredientsQuery = globalIngredientsQuery;
        this.getUserQuery = getUserQuery;
    }

    public QueryResult execute() {
        // Query for all the user's stuff.
        QueryResult userData = this.getUserQuery.execute();

        // Query for shared ingredients
        QueryResult globalIngredients = this.globalIngredientsQuery.execute();

        // TODO: Query for shared equipment
        // TODO: Query for user equipment

        // Return everything.
        userData.addAll(globalIngredients);
        return globalIngredients;
    }
}
