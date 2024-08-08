package service;

import dao.FoodItemDAO;
import dao.FoodItemDAOImpl;
import entity.FoodItem;
import utils.DbUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FoodItemService interface, providing methods for managing food items.
 * This class handles operations such as retrieving, purchasing, adding, updating, and inserting food items.
 */
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemDAO foodItemDAO = new FoodItemDAOImpl();

    /**
     * Retrieves a list of all food items from the database.
     *
     * @return A list of FoodItem objects representing all available food items.
     * @throws RuntimeException if an error occurs during the retrieval process.
     */
    @Override
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        try {
            DbUtil.begin();
            List<FoodItem> temps = foodItemDAO.selectAllFoodItems();
            if (temps != null && !temps.isEmpty()) {
                foodItems = temps;
            }
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error retrieving all food items: " + e.getMessage(), e);
        }
        return foodItems;
    }

    /**
     * Retrieves a food item by its ID from the database.
     *
     * @param id The ID of the food item to be retrieved.
     * @return The FoodItem object corresponding to the specified ID, or null if not found.
     * @throws RuntimeException if an error occurs during the retrieval process.
     */
    @Override
    public FoodItem getFoodItemById(int id) {
        FoodItem foodItem = null;
        try {
            DbUtil.begin();
            foodItem = foodItemDAO.selectFoodItemById(id);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error retrieving food item by ID: " + e.getMessage(), e);
        }
        return foodItem;
    }

    /**
     * Purchases a specified quantity of a food item.
     *
     * @param foodItem The FoodItem object representing the item to be purchased.
     * @return An integer indicating the remaining quantity of the food item after purchase.
     * @throws RuntimeException if an error occurs during the purchase process.
     */
    @Override
    public int purchaseFoodItemQuantity(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.consumeFoodItemQuantity(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error purchasing food item quantity: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Adds a specified quantity to a food item's stock.
     *
     * @param foodItem The FoodItem object representing the item to be restocked.
     * @return An integer indicating the new total quantity of the food item.
     * @throws RuntimeException if an error occurs during the addition process.
     */
    @Override
    public int addFoodItemQuantity(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.addFoodItemQuantity(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error adding food item quantity: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Updates the date information for a food item.
     *
     * @param foodItem The FoodItem object with updated date information.
     * @return An integer indicating the result of the update operation.
     * @throws RuntimeException if an error occurs during the update process.
     */
    @Override
    public int updateFoodItemDate(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updateFoodItemExpirationDates(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error updating food item date: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Inserts a new food item into the inventory.
     *
     * @param foodItem The FoodItem object representing the new item to be added.
     * @return An integer indicating the result of the insertion operation.
     * @throws RuntimeException if an error occurs during the insertion process.
     */
    @Override
    public int insertFoodItem(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.insertFoodItem(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error inserting food item: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Updates surplus information for a food item.
     *
     * @param foodItem The FoodItem object with updated surplus information.
     * @return An integer indicating the result of the update operation.
     * @throws RuntimeException if an error occurs during the update process.
     */
    @Override
    public int updateSurplusItem(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updateFoodItemSurplus(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error updating surplus item: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Checks if a food item is a surplus item by its ID.
     *
     * @param foodItemID The ID of the food item to check.
     * @return An integer indicating whether the food item is surplus (1) or not (0).
     * @throws RuntimeException if an error occurs during the check process.
     */
    @Override
    public int getFoodItemIsPlus(int foodItemID) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.getFoodItemIsPlusID(foodItemID);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error checking if food item is surplus: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Updates the information of a food item, including price type and price.
     *
     * @param foodItem The FoodItem object with updated information.
     * @return An integer indicating the result of the update operation.
     * @throws RuntimeException if an error occurs during the update process.
     */
    @Override
    public int updateFoodItem(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updatePriceTypeAndPrice(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error updating food item: " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * Retrieves a list of food items associated with a specific retailer ID.
     *
     * @param retailerId The ID of the retailer whose food items are to be retrieved.
     * @return A list of FoodItem objects associated with the specified retailer.
     * @throws RuntimeException if an error occurs during the retrieval process.
     */
    @Override
    public List<FoodItem> getFoodItemsByRetailerId(int retailerId) {
        List<FoodItem> foodItems = new ArrayList<>();
        try {
            DbUtil.begin();
            List<FoodItem> temps = foodItemDAO.selectFoodItemsByRetailerId(retailerId);
            if (temps != null && !temps.isEmpty()) {
                foodItems = temps;
            }
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException("Error retrieving food items by retailer ID: " + e.getMessage(), e);
        }
        return foodItems;
    }
}
