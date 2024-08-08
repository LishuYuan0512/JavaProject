/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Subscription;
import entity.Subscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import observer.Observable;
import observer.SubscriptionObserve;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import service.FoodItemService;
import service.FoodItemServiceImpl;
import utils.DbUtil;


/**
 * Implementation of the SubscriptionDao interface.
 * Provides database operations for Subscription entities using Apache Commons DbUtils.
 */
public class SubscriptionDAOImp implements SubscriptionDao {
    // Assuming you have a method to get a database connection
    private QueryRunner queryRunner = new QueryRunner();
 /**
     * Adds a new subscription to the database.
     * @param subscription the Subscription object to add
     */
@Override
    public void addSubscription(Subscription subscription) {
        String sql = "INSERT INTO Subscription (userID, locationID, foodPrefer, communicationMethod, email, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            queryRunner.update(DbUtil.getConnection(), sql,
                    subscription.getUserID(),
                    subscription.getLocationID(),
                    subscription.getFoodPrefer(),
                    subscription.getCommunicationMethod(),
                    subscription.getEmail(),
                    subscription.getPhone());
            

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., logging)
        }
    }
    
      /**
     * Updates an existing subscription in the database.
     * @param subscription the Subscription object with updated information
     */

    @Override
    public void updateSubscription(Subscription subscription) {
        String sql = "UPDATE Subscription SET locationID = ?, foodPrefer = ?, communicationMethod = ?, email = ?, phone = ? WHERE userID = ?";
        try {
            queryRunner.update(DbUtil.getConnection(), sql,
                    subscription.getLocationID(),
                    subscription.getFoodPrefer(),
                    subscription.getCommunicationMethod(),
                    subscription.getEmail(),
                    subscription.getPhone(),
                    subscription.getUserID());
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., logging)
        }
    }
    
      /**
     * Checks if a subscription exists for a given user ID.
     * @param userID the ID of the user
     * @return true if the subscription exists, false otherwise
     */

    @Override
    public boolean subscriptionExists(int userID) {
        String sql = "SELECT COUNT(*) FROM Subscription WHERE userID = ?";
        try {
            Long count = queryRunner.query(DbUtil.getConnection(), sql, new ScalarHandler<>(), userID);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}