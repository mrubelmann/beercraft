package beercraft.recipes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Business logic needed to service POST requests to /recipes.
*/
public class CreateRecipeRequestWorker {
    static final Logger logger = LogManager.getLogger(CreateRecipeRequestWorker.class);
    private final CreateRecipeQuery createRecipeQuery;

    public CreateRecipeRequestWorker(CreateRecipeQuery createRecipeQuery) {
        this.createRecipeQuery = createRecipeQuery;
    }

    public void execute(Recipe recipe) {
        if(recipe != null) {
            this.createRecipeQuery.execute(recipe);
        }
    }
}
