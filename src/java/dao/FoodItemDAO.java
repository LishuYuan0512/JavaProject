package dao;

import entity.FoodItem;

import java.util.List;

public interface FoodItemDAO {
    public List<FoodItem> selectAllFoodItems();
    public FoodItem selectFoodItemById(int id);
    public int consumeFoodItemQuantity(FoodItem foodItem);
    public int addFoodItemQuantity(FoodItem foodItem);
    public FoodItem selectFoodItemByItemName(String itemName);
    public int updateFoodItemExpirationDates(FoodItem foodItem);
    public int insertFoodItem(FoodItem foodItem);
    public int updateFoodItemSurplus(FoodItem foodItem);
    public int getFoodItemIsPlusID(int foodItemID);
    public int updatePriceTypeAndPrice(FoodItem foodItem);
    
    public List<FoodItem> selectFoodItemsByRetailerId(int userID);    

}
