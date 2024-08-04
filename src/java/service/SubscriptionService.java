/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.Subscription;

/**
 *
 * @author ZU
 */
public interface SubscriptionService {
    boolean createSubscription(Subscription subscription);
    boolean updateSubscription(Subscription subscription);
    boolean subscriptionExists(int userID);
}