package dao;

import entity.FoodItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

public class FoodItemDAOImpl implements FoodItemDAO{
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<FoodItem> selectAllFoodItems() {
        List<FoodItem> foodItems = null;
        try {
            foodItems = queryRunner.query(DbUtil.getConnection(),"select * from FoodItem;",
                    new BeanListHandler<FoodItem>(FoodItem.class));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foodItems;
    }

    @Override
    public FoodItem selectFoodItemById(int id) {
        try {
            FoodItem foodItem = queryRunner.query(DbUtil.getConnection(),"select * from FoodItem where itemID =?;",
                    new BeanHandler<FoodItem>(FoodItem.class),id);
            return foodItem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int updateFoodItemQuantity(FoodItem foodItem) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"update FoodItem set quantity= quantity - ? where itemID =?;",
                    foodItem.getQuantity(),foodItem.getItemID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FoodItem selectFoodItemByItemName(String itemName) {
        try {
            FoodItem foodItem = queryRunner.query(DbUtil.getConnection(),"select * from FoodItem where itemName =?;",
                    new BeanHandler<FoodItem>(FoodItem.class),itemName);
            return foodItem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
