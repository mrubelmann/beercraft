package beercraft.users;

import beercraft.builders.FermentableBuilder;
import beercraft.builders.MockGetGlobalIngredientQueryBuilder;
import beercraft.ingredients.Fermentable;
import beercraft.ingredients.FermentableFactory;
import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.QueryResult;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class GetUserDatabaseRequestWorkerTest {
    @Test
    void execute_oneFermentable_recordIsReturned() {
        Fermentable fermentable = new FermentableBuilder().build();
        GetGlobalIngredientsQuery getGlobalIngredientsQuery = new MockGetGlobalIngredientQueryBuilder()
                .withFermentable(fermentable)
                .build();

        GetUserDatabaseRequestWorker worker = new GetUserDatabaseRequestWorker(getGlobalIngredientsQuery);
        QueryResult queryResult = worker.execute();
        assertThat(queryResult.size()).isEqualTo(1);

        Fermentable actualFermentable = FermentableFactory.createFromAttributes(queryResult.get(0));
        assertThat(actualFermentable).isEqualToComparingFieldByField(fermentable);
    }
}