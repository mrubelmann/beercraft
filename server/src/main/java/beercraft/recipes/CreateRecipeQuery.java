package beercraft.recipes;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class CreateRecipeQuery {
    private final AmazonDynamoDB databaseClient;

    public CreateRecipeQuery(AmazonDynamoDB databaseClient) {
        this.databaseClient = databaseClient;
    }

    public void execute(Recipe recipe) {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.save(recipe);
    }
}
