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
    public int purchaseFoodItemQuantity(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.consumeFoodItemQuantity(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int addFoodItemQuantity(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.addFoodItemQuantity(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int updateFoodItemDate(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updateFoodItemExpirationDates(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int insertFoodItem(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.insertFoodItem(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int updateSurplusItem(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updateFoodItemSurplus(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int getFoodItemIsPlus(int foodItemID) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.getFoodItemIsPlusID(foodItemID);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int updateFoodItem(FoodItem foodItem) {
        int result = 0;
        try {
            DbUtil.begin();
            result = foodItemDAO.updatePriceTypeAndPrice(foodItem);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }


    @Override
    public List<FoodItem> getFoodItemsByRetailerId(int retailerId) {
    List<FoodItem> foodItems = new ArrayList<>();
        try {
            DbUtil.begin();
            // 调用DAO方法，使用零售商ID过滤商品
            List<FoodItem> temps = foodItemDAO.selectFoodItemsByRetailerId(retailerId);
            if (temps != null && !temps.isEmpty()) {
                foodItems = temps;
            }
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return foodItems;
    }


}
