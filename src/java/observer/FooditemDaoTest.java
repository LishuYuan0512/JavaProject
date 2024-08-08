package observer;


import dao.FoodItemDAOImpl;
import entity.FoodItem;
import entity.Subscription;
import observer.CustomerAlertObserver;
import observer.FoodItemObserverService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * A test class to demonstrate the functionality of the Observer pattern for food item updates.
 * It creates a FoodItemObserverService instance, adds a CustomerAlertObserver, and triggers a notification.
 */
public class FooditemDaoTest {
    public static void main(String[] args) {

        
       /**
     * The main method to test the Observer pattern functionality.
     *
     * @param args The command line arguments.
     */
        FoodItemObserverService observerService = new FoodItemObserverService() {
            @Override
            public void notifyObservers(Subscription subscription) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void update(FoodItem foodItem) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        // Create and add CustomerAlertObserver
        CustomerAlertObserver customerAlertObserver = new CustomerAlertObserver();
        observerService.addObserver(customerAlertObserver);
        
        // Create FoodItem instance
        FoodItem foodItem = new FoodItem();
        foodItem.setItemID(1);
        foodItem.setIsPlus(1); // Set to 1 to trigger notification
        foodItem.setPriceTypeID(100);
        
        // Call addOrUpdateFoodItem
        observerService.addOrUpdateFoodItem(foodItem);
    }
}