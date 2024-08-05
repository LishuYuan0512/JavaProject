/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Subscription;
import dao.SubscriptionDAOImp;
import dao.SubscriptionDao;
import observer.FoodItemObserverService;
import observer.Observable;
import utils.DbUtil;

/**
 *
 * @author ZU
 */
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionDao subscriptionDao;


    public SubscriptionServiceImpl() {
        // Instantiate SubscriptionDao
        this.subscriptionDao = new SubscriptionDAOImp();
    }

    @Override
    public boolean createSubscription(Subscription subscription) {
        try {
            // Call the DAO to handle the subscription creation
            subscriptionDao.addSubscription(subscription);
            //search if it's surplus

            return true;
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateSubscription(Subscription subscription) {
        try {
            // Call the DAO to handle the subscription update
            subscriptionDao.updateSubscription(subscription);
            return true;
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean subscriptionExists(int userID) {
        try {
            return subscriptionDao.subscriptionExists(userID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}