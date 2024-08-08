/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.Subscription;

/**
 * The SubscriptionService interface provides methods for managing subscriptions.
 * This includes functionality for creating, updating, and checking the existence of subscriptions.
 * 
 * @author ZU
 */
public interface SubscriptionService {

    /**
     * Creates a new subscription in the system.
     *
     * @param subscription The Subscription object containing the details of the subscription to be created.
     * @return A boolean indicating whether the subscription was successfully created.
     * @throws IllegalArgumentException if the subscription object is null or contains invalid data.
     */
    boolean createSubscription(Subscription subscription);

    /**
     * Updates an existing subscription in the system.
     *
     * @param subscription The Subscription object containing the updated details of the subscription.
     * @return A boolean indicating whether the subscription was successfully updated.
     * @throws IllegalArgumentException if the subscription object is null or contains invalid data.
     */
    boolean updateSubscription(Subscription subscription);

    /**
     * Checks if a subscription exists for the specified user ID.
     *
     * @param userID The ID of the user for whom to check the subscription.
     * @return A boolean indicating whether a subscription exists for the specified user ID.
     */
    boolean subscriptionExists(int userID);
}
