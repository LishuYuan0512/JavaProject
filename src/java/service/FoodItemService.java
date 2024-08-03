/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.FoodItem;
import java.util.List;

/**
 *
 * @author ZU
 */
public interface FoodItemService {
    public List<FoodItem> getAllFoodItems();
    public FoodItem getFoodItemById(int id);
    public int purchaseFoodItemQuantity(FoodItem foodItem);
    public int addFoodItemQuantity(FoodItem foodItem);
    public int updateFoodItemDate(FoodItem foodItem);
    public int insertFoodItem(FoodItem foodItem);
    public int surplusItem(FoodItem foodItem);
    public List<FoodItem> getFoodItemsByRetailerId(int retailerId);
}
