package beercraft.users;

import beercraft.builders.FermentableBuilder;
import beercraft.builders.MockGetGlobalIngredientQueryBuilder;
import beercraft.ingredients.Fermentable;
import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.ObjectMapperSingleton;
import beercraft.util.QueryResult;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        ObjectMapper mapper = ObjectMapperSingleton.getInstance();
        Fermentable actualFermentable = mapper.convertValue(queryResult.get(0), Fermentable.class);

        // ObjectMapper doesn't include the partition key.  Let's verify that and also cheat to compare everything else.
        assertThat(actualFermentable.getPK()).isNull();
        actualFermentable.setPK(fermentable.getPK());
        assertThat(actualFermentable).isEqualToComparingFieldByField(fermentable);
    }

    @Test
    void execute_twoFermentables_allRecordsAreReturned() {
        Fermentable[] fermentables = new Fermentable[] {
                new FermentableBuilder().build(),
                new FermentableBuilder().build()
        };
        GetGlobalIngredientsQuery getGlobalIngredientsQuery = new MockGetGlobalIngredientQueryBuilder()
                .withFermentable(fermentables[0])
                .withFermentable(fermentables[1])
                .build();

        GetUserDatabaseRequestWorker worker = new GetUserDatabaseRequestWorker(getGlobalIngredientsQuery);
        QueryResult queryResult = worker.execute();
        assertThat(queryResult.size()).isEqualTo(2);

        ObjectMapper mapper = ObjectMapperSingleton.getInstance();
        Fermentable[] actualFermentables = new Fermentable[]{
                mapper.convertValue(queryResult.get(0), Fermentable.class),
                mapper.convertValue(queryResult.get(1), Fermentable.class)
        };
        // ObjectMapper doesn't include the partition key.  Let's verify that and also cheat to compare everything else.
        assertThat(actualFermentables[0].getPK()).isNull();
        assertThat(actualFermentables[1].getPK()).isNull();
        actualFermentables[0].setPK(fermentables[0].getPK());
        actualFermentables[1].setPK(fermentables[1].getPK());
        assertThat(actualFermentables[0]).isEqualToComparingFieldByField(fermentables[0]);
        assertThat(actualFermentables[1]).isEqualToComparingFieldByField(fermentables[1]);
    }
}