package beercraft.databases;

import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.Executable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetUserDatabaseRequestWorker implements Executable<String> {
    static final Logger logger = LogManager.getLogger(GetUserDatabaseRequestWorker.class);

    private GetGlobalIngredientsQuery globalIngredientsQuery;

    public GetUserDatabaseRequestWorker(GetGlobalIngredientsQuery globalIngredientsQuery) {
        this.globalIngredientsQuery = globalIngredientsQuery;
    }

    @Override
    public String execute() {
        // TODO: Query for user profile with ID from URL

        // Query for shared ingredients
        logger.info("Executing global ingredients query");
        String globalIngredients = this.globalIngredientsQuery.execute();
        logger.info(String.format("Query results: %s", globalIngredients));

        // TODO: Query for user ingredients
        // TODO: Query for user recipes
        // TODO: Query for shared equipment
        // TODO: Query for user equipment

        // Return everything we've queried for
        return globalIngredients;
    }
}
