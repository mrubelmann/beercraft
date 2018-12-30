package beercraft.recipes;

import beercraft.util.Executable;
import beercraft.util.QueryResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Business logic needed to service POST requests to /recipes.
*/
public class CreateRecipeRequestWorker implements Executable<QueryResult> {
    static final Logger logger = LogManager.getLogger(CreateRecipeRequestWorker.class);

    public CreateRecipeRequestWorker() {
    }

    @Override
    public QueryResult execute() {
        return null;
    }
}