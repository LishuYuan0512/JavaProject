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

public interface SubscriptionDao {
    void addSubscription(Subscription subscription);
    void updateSubscription(Subscription subscription);
    boolean subscriptionExists(int userID);
}
