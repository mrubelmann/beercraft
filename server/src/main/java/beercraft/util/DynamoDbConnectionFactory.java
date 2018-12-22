package beercraft.util;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DynamoDbConnectionFactory {
    public static Table getConnectionToTable(String tableName) {
        Regions region = Regions.US_EAST_2;
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region).build();
        if(client == null) {
            throw new RuntimeException(String.format("Error connecting to DynamoDB in %s", region));
        }

        DynamoDB dynamoDB = new DynamoDB(client);
        if(dynamoDB == null) {
            throw new RuntimeException("Error creating DynamoDB client");
        }

        Table table = dynamoDB.getTable(tableName);
        if(table == null) {
            throw new RuntimeException(String.format("Error connecting to table %s", tableName));
        }

        return table;
    }
}
