package beercraft.recipes;

import beercraft.builders.RecipeBuilder;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CreateRecipeRequestWorkerTest {
    @Test
    void execute_validRequest_recordIsCreated() {
        CreateRecipeQuery mockQuery = mock(CreateRecipeQuery.class);
        Recipe recipe = new RecipeBuilder().build();

        CreateRecipeRequestWorker worker = new CreateRecipeRequestWorker(mockQuery);
        worker.execute(recipe);

        verify(mockQuery, times(1)).execute(recipe);
    }
}
