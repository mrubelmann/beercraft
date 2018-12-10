package beercraft.util;

/**
 * An interface representing something that can be a record in DynamoDB.  That is, it has a partition key and sort key.
 */
public interface DatabaseItem {
    /**
     * @return The partition key
     */
    String getPartitionKey();

    /**
     * @param partitionKey The partition key
     */
    void setPartitionKey(String partitionKey);

    /**
     * @return The sort key
     */
    String getSortKey();

    /**
     * @param sortKey The sort key
     */
    void setSortKey(String sortKey);
}
