package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

public class GetAllFermentablesQuery implements Query<List<Fermentable>> {
    protected AmazonDynamoDB databaseClient;

    public GetAllFermentablesQuery(AmazonDynamoDB databaseClient) {
        this.databaseClient = databaseClient;
    }

    public List<Fermentable> execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        return mapper.scan(Fermentable.class, new DynamoDBScanExpression());
    }
}
