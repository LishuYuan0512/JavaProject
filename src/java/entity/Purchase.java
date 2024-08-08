package entity;

import java.time.LocalDateTime;

/**
 * Represents a purchase transaction, including details about the purchase time,
 * user, item, quantity, price, and price type.
 */
public class Purchase {
    private int purchaseId;
    private LocalDateTime purchaseTime;
    private int userID;
    private int itemID;
    private int quantity;
    private double price;
    private int priceTypeID;

    /**
     * Default constructor for the Purchase class.
     * Initializes a new instance of the Purchase class with default values.
     */
    public Purchase() {
    }

    /**
     * Constructs a Purchase with specified details.
     *
     * @param purchaseId   The unique identifier for the purchase.
     * @param purchaseTime The time when the purchase was made.
     * @param userID       The unique identifier of the user who made the purchase.
     * @param itemID       The unique identifier of the item purchased.
     * @param quantity     The quantity of the item purchased.
     * @param price        The total price of the purchase.
     * @param priceTypeID  The type of price, represented by an integer.
     */
    public Purchase(int purchaseId, LocalDateTime purchaseTime, int userID, int itemID, int quantity, double price, int priceTypeID) {
        this.purchaseId = purchaseId;
        this.purchaseTime = purchaseTime;
        this.userID = userID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.priceTypeID = priceTypeID;
    }

    /**
     * Gets the unique identifier of the purchased item.
     *
     * @return The item ID.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Sets the unique identifier of the purchased item.
     *
     * @param itemID The item ID to set.
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * Gets the unique identifier for the purchase.
     *
     * @return The purchase ID.
     */
    public int getPurchaseId() {
        return purchaseId;
    }

    /**
     * Sets the unique identifier for the purchase.
     *
     * @param purchaseId The purchase ID to set.
     */
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * Gets the time when the purchase was made.
     *
     * @return The purchase time.
     */
    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    /**
     * Sets the time when the purchase was made.
     *
     * @param purchaseTime The purchase time to set.
     */
    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    /**
     * Gets the unique identifier of the user who made the purchase.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the unique identifier of the user who made the purchase.
     *
     * @param userID The user ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the quantity of the item purchased.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item purchased.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the total price of the purchase.
     *
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the total price of the purchase.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the type of price, represented by an integer.
     *
     * @return The price type ID.
     */
    public int getPriceTypeID() {
        return priceTypeID;
    }

    /**
     * Sets the type of price, represented by an integer.
     *
     * @param priceTypeID The price type ID to set.
     */
    public void setPriceTypeID(int priceTypeID) {
        this.priceTypeID = priceTypeID;
    }
}
