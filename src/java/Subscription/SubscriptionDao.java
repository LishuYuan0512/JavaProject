/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

/**
 *
 * @author rosal
 */
import java.sql.SQLException;

public interface SubscriptionDao {
    boolean updateSubscription(Subscription subscription) throws SQLException;
    Subscription getSubscription(int subscriptionID) throws SQLException;
    void createSubscription(Subscription subscription) throws SQLException;
    boolean deleteSubscription(int subscriptionID) throws SQLException;
}
