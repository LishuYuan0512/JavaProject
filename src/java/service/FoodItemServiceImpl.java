package service;

import dao.FoodItemDAO;
import dao.FoodItemDAOImpl;
import entity.FoodItem;
import utils.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class FoodItemServiceImpl implements FoodItemService{
    private FoodItemDAO foodItemDAO= new FoodItemDAOImpl();
    @Override
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<FoodItem>();
        try {
            DbUtil.begin();
            List<FoodItem> temps = foodItemDAO.selectAllFoodItems();
            if (temps!=null&&temps.size()>0){
                foodItems = temps;
            }
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return foodItems;
    }

    @Override
    public FoodItem getFoodItemById(int id) {
        FoodItem foodItem = null;
        try {
            DbUtil.begin();
            foodItem = foodItemDAO.selectFoodItemById(id);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return foodItem;
    }

    @Override
    public int modifyFoodItemQuantity(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updateFoodItemQuantity(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }
}
