/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Subscription.Subscription;
import Subscription.SubscriptionBusinessLogic;
import dao.SubscriptionDAOImp;
import dao.SubscriptionDao;
import utils.DbUtil;

/**
 *
 * @author ZU
 */
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionBusinessLogic subscriptionBusinessLogic;

    public SubscriptionServiceImpl() {
        // Instantiate SubscriptionDao and pass it to SubscriptionBusinessLogic
        SubscriptionDao subscriptionDao = new SubscriptionDAOImp();
        this.subscriptionBusinessLogic = new SubscriptionBusinessLogic(subscriptionDao);
    }

    @Override
    public boolean createSubscription(Subscription subscription){
        try {
            // Call the business logic to handle the subscription creation
            return subscriptionBusinessLogic.updateSubscription(subscription);
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
    }
}