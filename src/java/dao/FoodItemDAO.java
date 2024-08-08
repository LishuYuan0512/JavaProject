package dao;

import entity.FoodItem;

import java.util.List;

/**
 * Interface for FoodItem Data Access Object (DAO).
 * Provides methods for CRUD operations on FoodItem entities.
 */

public interface FoodItemDAO {
        /**
     * Selects all food items from the database.
     * @return a list of all FoodItem objects in the database
     */
    public List<FoodItem> selectAllFoodItems();
        /**
     * Selects a food item from the database by its ID.
     * @param id the ID of the food item to select
     * @return the FoodItem object with the specified ID, or null if not found
     */
    public FoodItem selectFoodItemById(int id);
        /**
     * Consumes a specified quantity of a food item.
     * @param foodItem the FoodItem object with the quantity to consume
     * @return the number of rows affected
     */
    public int consumeFoodItemQuantity(FoodItem foodItem);
       /**
     * Adds a specified quantity to a food item.
     * @param foodItem the FoodItem object with the quantity to add
     * @return the number of rows affected
     */
    public int addFoodItemQuantity(FoodItem foodItem);
        /**
     * Selects a food item from the database by its name.
     * @param itemName the name of the food item to select
     * @return the FoodItem object with the specified name, or null if not found
     */
    public FoodItem selectFoodItemByItemName(String itemName);
    
    /**
     * Updates the expiration dates for a food item.
     * @param foodItem the FoodItem object with updated expiration dates
     * @return the number of rows affected
     */
    public int updateFoodItemExpirationDates(FoodItem foodItem);
     /**
     * Inserts a new food item into the database.
     * @param foodItem the FoodItem object to insert
     * @return the number of rows affected
     */
    public int insertFoodItem(FoodItem foodItem);
       /**
     * Updates the surplus status of a food item.
     * @param foodItem the FoodItem object with updated surplus status
     * @return the number of rows affected
     */
    public int updateFoodItemSurplus(FoodItem foodItem);
       /**
     * Retrieves the surplus ID for a food item based on its ID.
     * @param foodItemID the ID of the food item
     * @return the surplus ID of the food item
     */
    public int getFoodItemIsPlusID(int foodItemID);
        /**
     * Updates the price type and price for a food item.
     * @param foodItem the FoodItem object with updated price type and price
     * @return the number of rows affected
     */
    public int updatePriceTypeAndPrice(FoodItem foodItem);
       /**
     * Selects food items from the database by retailer ID.
     * @param userID the ID of the retailer
     * @return a list of FoodItem objects associated with the specified retailer
     */
    
    public List<FoodItem> selectFoodItemsByRetailerId(int userID);    

}
