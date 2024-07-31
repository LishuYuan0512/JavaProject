package service;

import entity.FoodItem;

import java.util.List;

public interface FoodItemService {
    public List<FoodItem> getAllFoodItems();
    public FoodItem getFoodItemById(int id);
    public int modifyFoodItemQuantity(FoodItem foodItem);
}
