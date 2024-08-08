/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;

/**
 * An interface that defines the methods for an observer in the Observer pattern.
 * Observers receive updates when the observable entity's state changes.
 */
public interface Observer {
      /**
     * Updates the observer with the given subscription details.
     *
     * @param subscription The Subscription object containing details of the update.
     */
    public void update(Subscription subscription);
    
       /**
     * Updates the observer with the given food item details.
     *
     * @param foodItem The FoodItem object containing details of the update.
     */

    public void update(FoodItem foodItem);



    
	
}