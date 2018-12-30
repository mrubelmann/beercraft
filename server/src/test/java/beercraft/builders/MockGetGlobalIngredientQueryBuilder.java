package beercraft.builders;

import beercraft.ingredients.Fermentable;
import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.QueryResult;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockGetGlobalIngredientQueryBuilder {
    private QueryResult ingredients;

    public MockGetGlobalIngredientQueryBuilder() {
        ingredients = new QueryResult();
    }

    public GetGlobalIngredientsQuery build() {
        GetGlobalIngredientsQuery query = mock(GetGlobalIngredientsQuery.class);
        when(query.execute()).thenReturn(ingredients);
        return query;
    }

    public MockGetGlobalIngredientQueryBuilder withFermentable(Fermentable f) {
        Map<String, Object> map = new HashMap<>();
        map.put("PK", f.getPartitionKey());
        map.put("SK", f.getSortKey());
        map.put("Name", f.getName());
        map.put("Notes", f.getNotes());
        map.put("Color", f.getColor());
        map.put("Type", f.getType());
        map.put("Yield", f.getYield());
        map.put("LateBoilAddition", f.getLateBoilAddition());
        map.put("Origin", f.getOrigin());
        map.put("Supplier", f.getSupplier());
        map.put("CoarseFineDiff", f.getCoarseFineDiff());
        map.put("Moisture", f.getMoisture());
        map.put("DiastaticPower", f.getDiastaticPower());
        map.put("Protein", f.getProtein());
        map.put("MaxInBatch", f.getMaxInBatch());
        map.put("RecommendMash", f.getRecommendMash());
        map.put("Mashed", f.getMashed());
        ingredients.add(map);

        return this;
    }
}
