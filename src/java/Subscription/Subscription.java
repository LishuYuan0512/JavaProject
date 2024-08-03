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
    private int locationID;
    private String foodPrefer;
    private String email;
    private String phone;
    private int comunication_method;

    public Subscription(){
    }
    
    public Subscription(int subscriptionID, int userID, int locationID, String foodPrefer, String email, String phone) {
        this.subscriptionID = subscriptionID;
        this.userID = userID;
        this.locationID = locationID;
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

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
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

    public int getComunicationMethod() {
        return comunication_method; // Getter for com method
    }

    public void setComunicationMethod(int comunication_method) {
        this.comunication_method = comunication_method; // Setter for com method
    }
    
}
