/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import service.FoodItemService;
import service.FoodItemServiceImpl;
import utils.DbUtil;

/**
 * A class that implements the Observable interface to manage observers for subscription updates.
 * It provides methods to add, remove, and notify observers when a subscription is updated.
 */
public class SubscriptionObserve implements Observable{
    private static List<Observer> observers = new ArrayList<>();
    private QueryRunner queryRunner = new QueryRunner();

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
     * Notifies all observers about an update to a subscription.
     *
     * @param subscription The Subscription object containing details of the update.
     */

    @Override
    public void notifyObservers(Subscription subscription) {
        for (int i = 0; i< observers.size(); i++) {
	observers.get(i).update(subscription);
        }
    }

 /**
     * Checks for changes in the subscription and notifies observers if a condition is met.
     * If the isPlus flag is set to 1 for a food item, it triggers notifications.
     *
     * @param subscription The Subscription object to check for changes.
     */
	public void checkChange(Subscription subscription){
                        //check isPlus
            int foodID = subscription.getFoodPrefer();
            FoodItemService foodservice = new FoodItemServiceImpl();
            int isSruplu = foodservice.getFoodItemIsPlus(foodID);
		if(isSruplu == 1){//这里需要从数据库中调取相关数据，此处是为了简便
                notifyObservers(subscription);

	}
        }
           /**
     * Updates the observable entity with the given food item details.
     * This method is not supported in this class.
     *
     * @param foodItem The FoodItem object containing details of the update.
     */

    @Override
    public void update(FoodItem foodItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}