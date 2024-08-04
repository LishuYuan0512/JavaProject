package dao;

import entity.FoodItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

public class FoodItemDAOImpl implements FoodItemDAO{
    private QueryRunner queryRunner = new QueryRunner();
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

    @Override
    public int getFoodItemIsPlusID(FoodItem foodItem) {
        try {
            ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();
            Integer userID = queryRunner.query(DbUtil.getConnection(),"select isPlus from FoodItem2 where itemID = ?;",
                    scalarHandler,foodItem.getItemID());
            return userID.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
    
