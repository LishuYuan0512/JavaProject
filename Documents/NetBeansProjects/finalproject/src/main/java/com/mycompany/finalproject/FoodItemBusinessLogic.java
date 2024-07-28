/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author tangy
 */
import java.util.List;

public class FoodItemBusinessLogic {
    private FoodItemDao foodItemDao;

    public FoodItemBusinessLogic(FoodItemDao foodItemDao) {
        this.foodItemDao = foodItemDao;
    }

//    public void addItem(FoodItem foodItem) {
//        foodItemDao.addFoodItem(foodItem);
//    }
//
//    public void updateItem(FoodItem foodItem) {
//        foodItemDao.updateFoodItem(foodItem);
//    }
//
//    public FoodItem getItem(int itemID) {
//        return foodItemDao.getFoodItem(itemID);
//    }
//
//    public void deleteItem(int itemID) {
//        foodItemDao.deleteFoodItem(itemID);
//    }

    public List<FoodItem> getAllItems() {
        return foodItemDao.getAllFoodItems();
    }

//    public List<PriceType> getAllPriceTypes() {
//        return foodItemDao.getAllPriceTypes();
//    }
//
//  public void markAsSurplus(int itemID) {
//        FoodItem item = getItem(itemID);
//        if (item != null) {
//            item.setIsSurplus(true);
//            updateItem(item);
//        }
//    }
}

//  public List<FoodItem> getFoodItemsByRetailerId(long retailerId) throws SQLException {
//    return foodItemDao.getFoodItemsByRetailerId(retailerId);
//  }
//
//  public List<FoodItem> getAvailableDonations() throws SQLException {
//    return foodItemDao.getFoodItemsByDonationStatus(true);
//  }
//
//  public List<FoodItem> getDiscountedItems() throws SQLException {
//    return foodItemDao.getDiscountedFoodItems();
//  }
