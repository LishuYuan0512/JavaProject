package dao;

import entity.FoodItem;

import java.util.List;

public interface FoodItemDAO {
    public List<FoodItem> selectAllFoodItems();
    public FoodItem selectFoodItemById(int id);
    public int updateFoodItemQuantity(FoodItem foodItem);
    public FoodItem selectFoodItemByItemName(String itemName);
}
