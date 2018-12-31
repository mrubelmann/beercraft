package beercraft.util;

/**
 * An interface representing something that can be a record in DynamoDB.  That is, it has a partition key and sort key.
 */
public interface DatabaseItem {
    /**
     * @return The partition key
     */
    String getPK();

    /**
     * @param partitionKey The partition key
     */
    void setPK(String partitionKey);

    /**
     * @return The sort key
     */
    String getSK();

    /**
     * @param sortKey The sort key
     */
    void setSK(String sortKey);
}
