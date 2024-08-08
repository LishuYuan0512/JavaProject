/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class that implements the Observable interface for managing food item observers.
 * It provides methods to add, remove, and notify observers when a food item is added or updated.
 */
public abstract class FoodItemObserverService implements Observable {
    private List<Observer> observers = new ArrayList<>();
    
      /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
        /**
     * Notifies all observers about an update to a food item.
     *
     * @param foodItem The FoodItem object that has been added or updated.
     */

    public void notifyObservers(FoodItem foodItem) {
        for (Observer observer : observers) {
            observer.update(foodItem);
        }
    }
       /**
     * Adds or updates a food item and notifies observers if the food item is marked as surplus.
     *
     * @param foodItem The FoodItem object to be added or updated.
     */

    public void addOrUpdateFoodItem(FoodItem foodItem) {
   
        if (foodItem.getIsPlus() == 1) {
            notifyObservers(foodItem);
        }
    }

  
}