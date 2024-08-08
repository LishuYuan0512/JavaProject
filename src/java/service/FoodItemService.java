package service;

import entity.FoodItem;

import java.util.List;

/**
 * The FoodItemService interface provides methods for managing food items.
 * This includes retrieving, purchasing, adding, updating, and inserting food items.
 */
public interface FoodItemService {

    /**
     * Retrieves a list of all food items.
     *
     * @return A list of FoodItem objects representing all available food items.
     */
    public List<FoodItem> getAllFoodItems();

    /**
     * Retrieves a food item by its ID.
     *
     * @param id The ID of the food item to be retrieved.
     * @return The FoodItem object corresponding to the specified ID, or null if not found.
     */
    public FoodItem getFoodItemById(int id);

    /**
     * Purchases a specified quantity of a food item.
     *
     * @param foodItem The FoodItem object representing the item to be purchased.
     * @return An integer indicating the remaining quantity of the food item after purchase.
     */
    public int purchaseFoodItemQuantity(FoodItem foodItem);

    /**
     * Adds a specified quantity to a food item's stock.
     *
     * @param foodItem The FoodItem object representing the item to be restocked.
     * @return An integer indicating the new total quantity of the food item.
     */
    public int addFoodItemQuantity(FoodItem foodItem);

    /**
     * Updates the date information for a food item.
     *
     * @param foodItem The FoodItem object with updated date information.
     * @return An integer indicating the result of the update operation.
     */
    public int updateFoodItemDate(FoodItem foodItem);

    /**
     * Inserts a new food item into the inventory.
     *
     * @param foodItem The FoodItem object representing the new item to be added.
     * @return An integer indicating the result of the insertion operation.
     */
    public int insertFoodItem(FoodItem foodItem);

    /**
     * Updates surplus information for a food item.
     *
     * @param foodItem The FoodItem object with updated surplus information.
     * @return An integer indicating the result of the update operation.
     */
    public int updateSurplusItem(FoodItem foodItem);

    /**
     * Checks if a food item is a surplus item.
     *
     * @param foodItemID The ID of the food item to check.
     * @return An integer indicating whether the food item is surplus (1) or not (0).
     */
    public int getFoodItemIsPlus(int foodItemID);

    /**
     * Updates the information of a food item.
     *
     * @param foodItem The FoodItem object with updated information.
     * @return An integer indicating the result of the update operation.
     */
    public int updateFoodItem(FoodItem foodItem);

    /**
     * Retrieves a list of food items associated with a specific retailer ID.
     *
     * @param userID The ID of the retailer whose food items are to be retrieved.
     * @return A list of FoodItem objects associated with the specified retailer.
     */
    public List<FoodItem> getFoodItemsByRetailerId(int userID);
}
