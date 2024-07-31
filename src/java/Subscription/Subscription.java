/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

/**
 *
 * @author rosal
 */
public class Subscription {
    private int subscriptionID;
    private int userID;
    private String location;
    private String foodPrefer;
    private String email;
    private String phone;

 
    public Subscription(int subscriptionID, int userID, String location, String foodPrefer, String email, String phone) {
        this.subscriptionID = subscriptionID;
        this.userID = userID;
        this.location = location;
        this.foodPrefer = foodPrefer;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoodPrefer() {
        return foodPrefer;
    }

    public void setFoodPrefer(String foodPrefer) {
        this.foodPrefer = foodPrefer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
