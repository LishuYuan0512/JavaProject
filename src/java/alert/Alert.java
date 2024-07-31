package alert;


import java.sql.Timestamp;


/**
 *
 * @author rosal
 */
public class Alert {
    private int alertID;
    private int userID;
    private int itemID;
    private int alertTypeID;
    private Timestamp alertTime;
    private String email;
    private String phone;
    
    
    /**
     * Constructs a alert the specified ID and details.
     *
     * @param alertID
     * @param userID
     * @param itemID
     * @param alertTypeID
     * @param alertTime
     * @param email
     * @param phone
     */
    public Alert(int alertID, int userID, int itemID, int alertTypeID, Timestamp alertTime, String email, String phone) {
        this.alertID = alertID;
        this.userID = userID;
        this.itemID = itemID;
        this.alertTypeID = alertTypeID;
        this.alertTime = alertTime;
        this.email = email;
        this.phone = phone;
        
    }

    // Getters and Setters
    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getAlertTypeID() {
        return alertTypeID;
    }

    public void setAlertTypeID(int alertTypeID) {
        this.alertTypeID = alertTypeID;
    }

    public Timestamp getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Timestamp alertTime) {
        this.alertTime = alertTime;
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
