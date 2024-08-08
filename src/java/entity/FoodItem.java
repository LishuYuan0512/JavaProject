package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents a food item with details about its stock and pricing.
 * Includes information such as item ID, user ID, item name, quantity,
 * restock time, expiration date, price, and discount.
 */
public class FoodItem {
    private int itemID;
    private int userID;
    private String itemName;
    private int quantity;
    private Date restockTime;
    private Date expirationDate;
    private double price;
    private int priceTypeID;
    private int isPlus;
    private double discount;

    /**
     * Default constructor for the FoodItem class.
     * Initializes a new instance of the FoodItem class with default values.
     */
    public FoodItem() {
    }

    /**
     * Constructs a FoodItem with specified details.
     *
     * @param itemID        The unique identifier for the food item.
     * @param userID        The unique identifier of the user associated with the food item.
     * @param itemName      The name of the food item.
     * @param quantity      The quantity of the food item in stock.
     * @param restockTime   The time when the food item was restocked.
     * @param expirationDate The expiration date of the food item.
     * @param price         The price of the food item.
     * @param priceTypeID   The type of price, represented by an integer.
     * @param isPlus        An indicator for additional features, represented by an integer.
     */
    public FoodItem(int itemID, int userID, String itemName, int quantity, Date restockTime, Date expirationDate, double price, int priceTypeID, int isPlus) {
        this.itemID = itemID;
        this.userID = userID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.restockTime = restockTime;
        this.expirationDate = expirationDate;
        this.price = price;
        this.priceTypeID = priceTypeID;
        this.isPlus = isPlus;
    }

    /**
     * Gets the unique identifier for the food item.
     *
     * @return The item ID.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Sets the unique identifier for the food item.
     *
     * @param itemID The item ID to set.
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * Gets the unique identifier of the user associated with the food item.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the unique identifier of the user associated with the food item.
     *
     * @param userID The user ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the name of the food item.
     *
     * @return The item name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the name of the food item.
     *
     * @param itemName The item name to set.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the quantity of the food item in stock.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the food item in stock.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the time when the food item was restocked.
     *
     * @return The restock time.
     */
    public Date getRestockTime() {
        return restockTime;
    }

    /**
     * Sets the time when the food item was restocked.
     *
     * @param restockTime The restock time to set.
     */
    public void setRestockTime(Date restockTime) {
        this.restockTime = restockTime;
    }

    /**
     * Gets the expiration date of the food item.
     *
     * @return The expiration date.
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the food item.
     *
     * @param expirationDate The expiration date to set.
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the price of the food item.
     *
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the food item.
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

    /**
     * Gets the indicator for additional features, represented by an integer.
     *
     * @return The isPlus value.
     */
    public int getIsPlus() {
        return isPlus;
    }

    /**
     * Sets the indicator for additional features, represented by an integer.
     *
     * @param isPlus The isPlus value to set.
     */
    public void setIsPlus(int isPlus) {
        this.isPlus = isPlus;
    }

    /**
     * Gets the discount applied to the food item.
     *
     * @return The discount.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount applied to the food item.
     *
     * @param discount The discount to set.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Returns a string representation of the food item, including item details.
     *
     * @return A string containing the food item's details.
     */
    @Override
    public String toString() {
        return "FoodItem{" +
                "itemID=" + itemID +
                ", userID=" + userID +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", restockTime=" + restockTime +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                ", priceTypeID=" + priceTypeID +
                '}';
    }

    /**
     * Determines if the expiration date is within 7 days from the current date.
     *
     * @param expirationDate The expiration date to check.
     * @return true if the expiration date is within 7 days; otherwise, false.
     */
    public boolean isDateWithin7Days(Date expirationDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        long expirationTime = calendar.getTimeInMillis();

        calendar.setTime(new Date());
        long currentTime = calendar.getTimeInMillis();

        long diffInMillis = expirationTime - currentTime;
        long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);

        return diffInDays < 7;
    }
}
