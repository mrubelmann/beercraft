package beercraft.builders;

import beercraft.users.GetUserQuery;
import beercraft.util.QueryResult;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockGetUserQueryBuilder {
    private QueryResult userData;
    private String userId;

    public MockGetUserQueryBuilder() {
        userData = new QueryResult();
        userId = RandomData.getString();
    }

    public GetUserQuery build() {
        // Create a clone of the user data so we can modify it in here without affecting subsequent calls to build().
        QueryResult result = (QueryResult)userData.clone();

        Map<String, Object> userRecord = new HashMap<>();
        userRecord.put("userId", userId);
        result.add(userRecord);

        GetUserQuery query = mock(GetUserQuery.class);
        when(query.execute()).thenReturn(result);
        return query;
    }
}

