/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Subscription.Subscription;
import Subscription.Subscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import utils.DbUtil;

/**
 *
 * @author rosal
 */
public class SubscriptionDAOImp implements SubscriptionDao {
    // Assuming you have a method to get a database connection
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public void addSubscription(Subscription subscription) {
        String sql = "INSERT INTO Subscription (userID, locationID, foodPrefer, comunication_method, email, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, subscription.getUserID());
            statement.setInt(2, subscription.getLocationID());
            statement.setString(3, subscription.getFoodPrefer());
            statement.setInt(4, subscription.getComunicationMethod()); // Assuming a getter for com method
            statement.setString(5, subscription.getEmail());
            statement.setString(6, subscription.getPhone());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., logging)
        }
    }

    @Override
    public void updateSubscription(Subscription subscription) {
        String sql = "UPDATE Subscription SET userID = ?, locationID = ?, foodPrefer = ?, comunication_method = ?, email = ?, phone = ? WHERE subscriptionID = ?";

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, subscription.getUserID());
            statement.setInt(2, subscription.getLocationID());
            statement.setString(3, subscription.getFoodPrefer());
            statement.setInt(4, subscription.getComunicationMethod()); // Assuming a getter for com method
            statement.setString(5, subscription.getEmail());
            statement.setString(6, subscription.getPhone());
            statement.setInt(7, subscription.getSubscriptionID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., logging)
        }
    }
}
