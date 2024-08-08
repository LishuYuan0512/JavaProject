package dao;

import entity.FoodItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the FoodItemDAO interface.
 * Provides database operations for FoodItem entities using Apache Commons DbUtils.
 */

public class FoodItemDAOImpl implements FoodItemDAO{
    private QueryRunner queryRunner = new QueryRunner();
    
    /**
     * Selects all food items from the database.
     * @return a list of all FoodItem objects in the database
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public List<FoodItem> selectAllFoodItems() {
        List<FoodItem> foodItems = null;
        try {
            foodItems = queryRunner.query(DbUtil.getConnection(),"select * from FoodItem2;",
                    new BeanListHandler<FoodItem>(FoodItem.class));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foodItems;
    }

        /**
     * Selects a food item from the database by its ID.
     * @param id the ID of the food item to select
     * @return the FoodItem object with the specified ID, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public FoodItem selectFoodItemById(int id) {
        try {
            FoodItem foodItem = queryRunner.query(DbUtil.getConnection(),"select * from FoodItem2 where itemID =?;",
                    new BeanHandler<FoodItem>(FoodItem.class),id);
            return foodItem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    /**
     * Consumes a specified quantity of a food item.
     * @param foodItem the FoodItem object with the quantity to consume
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int consumeFoodItemQuantity(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"update FoodItem2 set quantity= quantity - ? where itemID =?;",
                    foodItem.getQuantity(),foodItem.getItemID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
       /**
     * Adds a specified quantity to a food item.
     * @param foodItem the FoodItem object with the quantity to add
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int addFoodItemQuantity(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(), "update FoodItem2 set quantity= quantity + ? where itemID =?;",
                    foodItem.getQuantity(), foodItem.getItemID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Selects a food item from the database by its name.
     * @param itemName the name of the food item to select
     * @return the FoodItem object with the specified name, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public FoodItem selectFoodItemByItemName(String itemName) {
        try {
            FoodItem foodItem = queryRunner.query(DbUtil.getConnection(),"select * from FoodItem2 where itemName =?;",
                    new BeanHandler<FoodItem>(FoodItem.class),itemName);
            return foodItem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    /**
     * Updates the expiration dates for a food item.
     * @param foodItem the FoodItem object with updated expiration dates
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int updateFoodItemExpirationDates(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(), "update FoodItem2 set expirationDate = ? where itemID =?;",
                    foodItem.getExpirationDate(), foodItem.getItemID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Inserts a new food item into the database.
     * @param foodItem the FoodItem object to insert
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int insertFoodItem(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price,priceTypeID,isPlus) VALUES" +
                            "(?, ?, ?, ?, ?, ?,?,?);",
                    foodItem.getUserID(),foodItem.getItemName(),foodItem.getQuantity(),foodItem.getRestockTime(),foodItem.getExpirationDate(),
                    foodItem.getPrice(),foodItem.getPriceTypeID(),foodItem.getIsPlus());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

       /**
     * Updates the surplus status of a food item.
     * @param foodItem the FoodItem object with updated surplus status
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public int updateFoodItemSurplus(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(), "update FoodItem2 set isPlus = ?, priceTypeID=? where itemID =?;",
                    foodItem.getIsPlus(),foodItem.getPriceTypeID(), foodItem.getItemID());
            
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves the surplus ID for a food item based on its ID.
     * @param itemID the ID of the food item
     * @return the surplus ID of the food item
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int getFoodItemIsPlusID(int itemID) {
        try {
            ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();
            Integer isPlus = queryRunner.query(DbUtil.getConnection(),"select isPlus from fooditem2 where itemID = ?;", scalarHandler, itemID);
            return isPlus;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Updates the price type and price for a food item.
     * @param foodItem the FoodItem object with updated price type and price
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int updatePriceTypeAndPrice(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(), "update FoodItem2 set priceTypeID = ?, price=price*(1-?) where itemID =?;",
                    foodItem.getPriceTypeID(),foodItem.getDiscount(), foodItem.getItemID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    /**
     * Selects food items from the database by retailer ID.
     * @param userID the ID of the retailer
     * @return a list of FoodItem objects associated with the specified retailer
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public List<FoodItem> selectFoodItemsByRetailerId(int userID) {
    List<FoodItem> foodItems = null;
        try {
            String query = "SELECT * FROM FoodItem2 WHERE userID = ?";
            foodItems = queryRunner.query(DbUtil.getConnection(), query,
                    new BeanListHandler<>(FoodItem.class), userID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foodItems;
    }
    
}