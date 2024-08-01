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

    public boolean updateSubscription(Subscription subscription) throws SQLException {
        return subscriptionDao.updateSubscription(subscription);
    }

    public Subscription getSubscription(int subscriptionID) throws SQLException {
        return subscriptionDao.getSubscription(subscriptionID);
    }

    public void createSubscription(Subscription subscription) throws SQLException {
        subscriptionDao.createSubscription(subscription);
    }

    public boolean deleteSubscription(int subscriptionID) throws SQLException {
        return subscriptionDao.deleteSubscription(subscriptionID);
    }
}