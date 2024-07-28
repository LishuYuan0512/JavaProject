package com.mycompany.finalproject;

/**
 *
 * @author tangy
 */
import java.sql.*;
import java.util.*;

public class FoodItemDaoImpl implements FoodItemDao {
    private DataSource dataSource;

    public FoodItemDaoImpl() {
        this.dataSource = new DataSource();
    }

    @Override
    public FoodItem getFoodItem(int itemID) {
        FoodItem foodItem = null;
        String query = "SELECT * FROM FoodItems WHERE itemID = ?";
        try (Connection conn = dataSource.createConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, itemID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                foodItem = new FoodItem();
                foodItem.setItemID(rs.getInt("itemID"));
                foodItem.setUserID(rs.getInt("userID"));
                foodItem.setItemName(rs.getString("itemName"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setRestockTime(rs.getTimestamp("restockTime"));
                foodItem.setExpirationDate(rs.getTimestamp("expirationDate"));
                foodItem.setPrice(rs.getDouble("price"));
                foodItem.setPriceTypeID(rs.getInt("priceTypeID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItem;
    }

    @Override
    public void addFoodItem(FoodItem foodItem) {
        String query = "INSERT INTO FoodItems (userID, itemName, quantity, restockTime, expirationDate, price, priceTypeID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.createConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, foodItem.getUserID());
            stmt.setString(2, foodItem.getItemName());
            stmt.setInt(3, foodItem.getQuantity());
            stmt.setTimestamp(4, new Timestamp(foodItem.getRestockTime().getTime()));
            stmt.setTimestamp(5, new Timestamp(foodItem.getExpirationDate().getTime()));
            stmt.setDouble(6, foodItem.getPrice());
            stmt.setInt(7, foodItem.getPriceTypeID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFoodItem(FoodItem foodItem) {
        String query = "UPDATE FoodItems SET userID = ?, itemName = ?, quantity = ?, restockTime = ?, expirationDate = ?, price = ?, priceTypeID = ? WHERE itemID = ?";
        try (Connection conn = dataSource.createConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, foodItem.getUserID());
            stmt.setString(2, foodItem.getItemName());
            stmt.setInt(3, foodItem.getQuantity());
            stmt.setTimestamp(4, new Timestamp(foodItem.getRestockTime().getTime()));
            stmt.setTimestamp(5, new Timestamp(foodItem.getExpirationDate().getTime()));
            stmt.setDouble(6, foodItem.getPrice());
            stmt.setInt(7, foodItem.getPriceTypeID());
            stmt.setInt(8, foodItem.getItemID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFoodItem(int itemID) {
        String query = "DELETE FROM FoodItems WHERE itemID = ?";
        try (Connection conn = dataSource.createConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, itemID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

@Override
public List<FoodItem> getAllFoodItems() {
    List<FoodItem> foodItems = new ArrayList<>();
    String query = "SELECT * FROM fooditems";
    try (Connection conn = dataSource.createConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            FoodItem foodItem = new FoodItem();
            foodItem.setItemID(rs.getInt("itemID"));
            foodItem.setUserID(rs.getInt("userID"));
            foodItem.setItemName(rs.getString("itemName"));
            foodItem.setQuantity(rs.getInt("quantity"));
            foodItem.setRestockTime(rs.getTimestamp("restockTime"));
            foodItem.setExpirationDate(rs.getTimestamp("expirationDate"));
            foodItem.setPrice(rs.getDouble("price"));
            foodItem.setPriceTypeID(rs.getInt("priceTypeID"));
            foodItems.add(foodItem);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return foodItems;
}


    @Override
    public List<PriceType> getAllPriceTypes() {
        List<PriceType> priceTypes = new ArrayList<>();
        String query = "SELECT * FROM PriceType";
        try (Connection conn = dataSource.createConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PriceType priceType = new PriceType();
                priceType.setPriceTypeID(rs.getInt("priceTypeID"));
                priceType.setPriceType(rs.getString("priceType"));
                priceTypes.add(priceType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priceTypes;
    }
}
