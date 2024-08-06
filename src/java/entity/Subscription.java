/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author rosal
 */
public class Subscription {
    private int userID;
    private int locationID;
    private int foodPrefer;
    private String email;
    private String phone;
    private int communicationMethod;

    public Subscription(){
    }
    
    public Subscription(int userID, int locationID, int foodPrefer, String email, String phone) {
        this.userID = userID;
        this.locationID = locationID;
        this.foodPrefer = foodPrefer;
        this.email = email;
        this.phone = phone;
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

    public int getFoodPrefer() {
        return foodPrefer;
    }

    public void setFoodPrefer(int foodPrefer) {
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

    public int getCommunicationMethod() {
        return communicationMethod; // Getter for com method
    }

    public void setCommunicationMethod(int communicationMethod) {
        this.communicationMethod = communicationMethod; // Setter for com method
    }
    
    //+to string

    @Override
    public String toString() {
        return "Subscription{" + "userID=" + userID + ", locationID=" + locationID + ", foodPrefer=" + foodPrefer + ", email=" + email + ", phone=" + phone + ", communicationMethod=" + communicationMethod + '}';
    }
    
    
}
