package beercraft.builders;

import beercraft.ingredients.Fermentable;
import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.ObjectMapperSingleton;
import beercraft.util.QueryResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = ObjectMapperSingleton.getInstance();
        ingredients.add(mapper.convertValue(f, new TypeReference<Map<String, Object>>() {}));
        return this;
    }
}
