/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;

/**
 * An interface that defines the methods for an observable entity in the Observer pattern.
 * It allows adding, removing, and notifying observers about changes in state.
 */
public interface Observable {
     /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    void addObserver(Observer observer);
        /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(Observer observer);
        /**
     * Notifies all observers about an update related to a subscription.
     *
     * @param subscription The Subscription object containing details of the update.
     */
    void notifyObservers(Subscription subscription);
     /**
     * Updates the observable entity with the given food item details.
     *
     * @param foodItem The FoodItem object containing details of the update.
     */
    public void update(FoodItem foodItem);

}