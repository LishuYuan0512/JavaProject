/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

import dao.SubscriptionDao;
import java.sql.SQLException;
/**
 *
 * @author rosal
 */
public class SubscriptionBusinessLogic {
    private final SubscriptionDao subscriptionDao;

    public SubscriptionBusinessLogic(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    /**
     * Adds a new subscription.
     *
     * @param subscription the Subscription object containing details to be added
     * @return true if the subscription was added successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean addSubscription(Subscription subscription) throws SQLException {
        subscriptionDao.addSubscription(subscription); // Handle the exception (e.g., logging)
        // Indicate failure
        return true; // Indicate success
    }

    /**
     * Updates an existing subscription.
     *
     * @param subscription the Subscription object containing updated details
     * @return true if the subscription was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean updateSubscription(Subscription subscription) throws SQLException {
        subscriptionDao.updateSubscription(subscription); // Handle the exception (e.g., logging)
        // Indicate failure
        return true;
    }
}