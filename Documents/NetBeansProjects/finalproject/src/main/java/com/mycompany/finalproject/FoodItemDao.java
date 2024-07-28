package com.mycompany.finalproject;

import java.util.List;


/**
 *
 * @author tangy
 */
import java.util.List;

public interface FoodItemDao {
    FoodItem getFoodItem(int itemID);
    void addFoodItem(FoodItem foodItem);
    void updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(int itemID);
    List<FoodItem> getAllFoodItems();
    List<PriceType> getAllPriceTypes();
}

