package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;
import java.util.Optional;

public class GetByIdQuery<T> implements Query<Optional<T>> {
    protected AmazonDynamoDB databaseClient;
    private String id;
    private Class<T> itemClass;

    public GetByIdQuery(AmazonDynamoDB databaseClient, String id, Class<T> itemClass) {
        this.databaseClient = databaseClient;
        this.id = id;
        this.itemClass = itemClass;
    }

    public Optional<T> execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        T result = mapper.load(itemClass, id);
        return result != null ? Optional.of(result) : Optional.empty();
    }
}
