/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author rosal
 */
import entity.Subscription;
import entity.Subscription;
import java.sql.SQLException;


/**
 * Interface for Subscription Data Access Object (DAO).
 * Provides methods for CRUD operations on Subscription entities.
 */

public interface SubscriptionDao {
        /**
     * Adds a new subscription to the database.
     * @param subscription the Subscription object to add
     */
    void addSubscription(Subscription subscription);
       /**
     * Updates an existing subscription in the database.
     * @param subscription the Subscription object with updated information
     */
    void updateSubscription(Subscription subscription);
        /**
     * Checks if a subscription exists for a given user ID.
     * @param userID the ID of the user
     * @return true if the subscription exists, false otherwise
     */
    boolean subscriptionExists(int userID);
}
