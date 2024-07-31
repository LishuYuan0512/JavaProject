/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rosal
 */
public class SubscriptionDAOImp implements SubscriptionDao {
    private final Connection connection;

    public SubscriptionDAOImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean updateSubscription(Subscription subscription) throws SQLException {
        String sql = "UPDATE Subscription SET userID = ?, location = ?, foodPrefer = ?, email = ?, phone = ? WHERE subscriptionID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subscription.getUserID());
            stmt.setString(2, subscription.getLocation());
            stmt.setString(3, subscription.getFoodPrefer());
            stmt.setString(4, subscription.getEmail());
            stmt.setString(5, subscription.getPhone());
            stmt.setInt(6, subscription.getSubscriptionID());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    @Override
    public Subscription getSubscription(int subscriptionID) throws SQLException {
        String sql = "SELECT * FROM Subscription WHERE subscriptionID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subscriptionID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Subscription(
                        rs.getInt("subscriptionID"),
                        rs.getInt("userID"),
                        rs.getString("location"),
                        rs.getString("foodPrefer"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                }
            }
        }
        return null;
    }
    
    @Override
    public void createSubscription(Subscription subscription) throws SQLException {
        String sql = "INSERT INTO Subscription (userID, location, foodPrefer, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subscription.getUserID());
            stmt.setString(2, subscription.getLocation());
            stmt.setString(3, subscription.getFoodPrefer());
            stmt.setString(4, subscription.getEmail());
            stmt.setString(5, subscription.getPhone());
            stmt.executeUpdate();
        }
    }
    
    @Override
    public boolean deleteSubscription(int subscriptionID) throws SQLException {
        String sql = "DELETE FROM Subscription WHERE subscriptionID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subscriptionID);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}