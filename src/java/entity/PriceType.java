package entity;

/**
 * Represents a type of pricing, with an identifier and a descriptive name.
 * Useful for categorizing different pricing strategies or models.
 */
public class PriceType {
    private int priceTypeID;
    private String priceType;

    /**
     * Default constructor for the PriceType class.
     * Initializes a new instance of the PriceType class with default values.
     */
    public PriceType() {
    }

    /**
     * Constructs a PriceType with specified details.
     *
     * @param priceTypeID The unique identifier for the price type.
     * @param priceType   The name or description of the price type.
     */
    public PriceType(int priceTypeID, String priceType) {
        this.priceTypeID = priceTypeID;
        this.priceType = priceType;
    }

    /**
     * Gets the unique identifier for the price type.
     *
     * @return The price type ID.
     */
    public int getPriceTypeID() {
        return priceTypeID;
    }

    /**
     * Sets the unique identifier for the price type.
     *
     * @param priceTypeID The price type ID to set.
     */
    public void setPriceTypeID(int priceTypeID) {
        this.priceTypeID = priceTypeID;
    }

    /**
     * Gets the name or description of the price type.
     *
     * @return The price type.
     */
    public String getPriceType() {
        return priceType;
    }

    /**
     * Sets the name or description of the price type.
     *
     * @param priceType The price type to set.
     */
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
}
