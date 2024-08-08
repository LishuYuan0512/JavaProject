/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Subscription;
import dao.SubscriptionDAOImp;
import dao.SubscriptionDao;
import utils.DbUtil;

/**
 * Implementation of the SubscriptionService interface, providing methods for managing subscriptions.
 * This class handles the creation, updating, and existence checking of subscriptions with transaction management.
 * 
 * @author ZU
 */
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionDao subscriptionDao;

    /**
     * Constructs a SubscriptionServiceImpl instance and initializes the SubscriptionDao.
     */
    public SubscriptionServiceImpl() {
        // Instantiate SubscriptionDao
        this.subscriptionDao = new SubscriptionDAOImp();
    }

    /**
     * Creates a new subscription in the system.
     * Begins a transaction, calls the DAO to add the subscription, and commits the transaction.
     *
     * @param subscription The Subscription object containing the details of the subscription to be created.
     * @return A boolean indicating whether the subscription was successfully created.
     * @throws RuntimeException if an error occurs during the creation process or if the subscription is invalid.
     */
    @Override
    public boolean createSubscription(Subscription subscription) {
        try {
            // Begin a transaction
            DbUtil.begin();

            // Call the DAO to handle the subscription creation
            subscriptionDao.addSubscription(subscription);

            // Commit the transaction
            DbUtil.commit();
            return true;
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            DbUtil.rollback();
            throw new RuntimeException("Error creating subscription: " + e.getMessage(), e);
        }
    }

    /**
     * Updates an existing subscription in the system.
     * Begins a transaction, calls the DAO to update the subscription, and commits the transaction.
     *
     * @param subscription The Subscription object containing the updated details of the subscription.
     * @return A boolean indicating whether the subscription was successfully updated.
     * @throws RuntimeException if an error occurs during the update process or if the subscription is invalid.
     */
    @Override
    public boolean updateSubscription(Subscription subscription) {
        try {
            // Begin a transaction
            DbUtil.begin();

            // Call the DAO to handle the subscription update
            subscriptionDao.updateSubscription(subscription);

            // Commit the transaction
            DbUtil.commit();
            return true;
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            DbUtil.rollback();
            throw new RuntimeException("Error updating subscription: " + e.getMessage(), e);
        }
    }

    /**
     * Checks if a subscription exists for the specified user ID.
     *
     * @param userID The ID of the user for whom to check the subscription.
     * @return A boolean indicating whether a subscription exists for the specified user ID.
     * @throws RuntimeException if an error occurs during the existence check.
     */
    @Override
    public boolean subscriptionExists(int userID) {
        try {
            // Begin a transaction
            DbUtil.begin();

            // Check if the subscription exists
            return subscriptionDao.subscriptionExists(userID);
        } catch (Exception e) {
            throw new RuntimeException("Error checking subscription existence: " + e.getMessage(), e);
        }
    }
}
