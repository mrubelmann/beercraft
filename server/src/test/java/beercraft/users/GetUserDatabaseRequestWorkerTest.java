package beercraft.users;

import beercraft.builders.FermentableBuilder;
import beercraft.builders.MockGetGlobalIngredientQueryBuilder;
import beercraft.ingredients.Fermentable;
import beercraft.ingredients.FermentableType;
import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.QueryResult;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

class GetUserDatabaseRequestWorkerTest {
    private Fermentable createFermentableFromAttributes(Map<String, Object> attributes) {
        Fermentable f = new Fermentable();
        f.setPartitionKey((String)attributes.get("PK"));
        f.setSortKey((String)attributes.get("SK"));
        f.setName((String)attributes.get("Name"));
        f.setNotes((String)attributes.get("Notes"));
        f.setColor((double)attributes.get("Color"));
        f.setType((FermentableType) attributes.get("Type"));
        f.setYield((double)attributes.get("Yield"));
        f.setLateBoilAddition((boolean)attributes.get("LateBoilAddition"));
        f.setOrigin((String)attributes.get("Origin"));
        f.setSupplier((String)attributes.get("Supplier"));
        f.setCoarseFineDiff((double)attributes.get("CoarseFineDiff"));
        f.setMoisture((double)attributes.get("Moisture"));
        f.setDiastaticPower((double)attributes.get("DiastaticPower"));
        f.setProtein((double)attributes.get("Protein"));
        f.setMaxInBatch((double)attributes.get("MaxInBatch"));
        f.setRecommendMash((boolean)attributes.get("RecommendMash"));
        f.setMashed((boolean)attributes.get("Mashed"));
        return f;
    }

    @Test
    void execute_oneFermentable_recordIsReturned() {
        Fermentable fermentable = new FermentableBuilder().build();
        GetGlobalIngredientsQuery getGlobalIngredientsQuery = new MockGetGlobalIngredientQueryBuilder()
                .withFermentable(fermentable)
                .build();

        GetUserDatabaseRequestWorker worker = new GetUserDatabaseRequestWorker(getGlobalIngredientsQuery);
        QueryResult queryResult = worker.execute();
        assertThat(queryResult.size()).isEqualTo(1);

        Fermentable actualFermentable = createFermentableFromAttributes(queryResult.get(0));
        assertThat(actualFermentable).isEqualToComparingFieldByField(fermentable);
    }
}