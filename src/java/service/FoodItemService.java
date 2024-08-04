package service;

import entity.FoodItem;

import java.util.List;

public interface FoodItemService {
    public List<FoodItem> getAllFoodItems();
    public FoodItem getFoodItemById(int id);
    public int purchaseFoodItemQuantity(FoodItem foodItem);
    public int addFoodItemQuantity(FoodItem foodItem);
    public int updateFoodItemDate(FoodItem foodItem);
    public int insertFoodItem(FoodItem foodItem);
    public int updateSurplusItem(FoodItem foodItem);
    public int getFoodItemIsPlus(FoodItem foodItem);
    public int updateFoodItem(FoodItem foodItem);
}