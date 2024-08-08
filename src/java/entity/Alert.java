package entity;
import java.util.Date;

/**
 * Represents an alert associated with a user, item, and alert type.
 * Contains information about the alert's ID, associated user and item,
 * type of alert, time the alert was triggered, and contact information.
 */
public class Alert {
    private int alertID;
    private int userID;
    private int itemID;
    private int alertTypeID;
    private Date alertTime;
    private String email;
    private String phone;

    /**
     * Constructs an Alert with specified details.
     *
     * @param alertID    The unique identifier for the alert.
     * @param userID     The unique identifier of the user associated with the alert.
     * @param itemID     The unique identifier of the item associated with the alert.
     * @param alertTypeID The type of alert, represented by an integer.
     * @param alertTime  The time at which the alert was triggered.
     * @param email      The email address associated with the alert.
     * @param phone      The phone number associated with the alert.
     */
    public Alert() {
    }

    public Alert(int alertID, int userID, int itemID, int alertTypeID, Date alertTime, String email, String phone) {
        this.alertID = alertID;
        this.userID = userID;
        this.itemID = itemID;
        this.alertTypeID = alertTypeID;
        this.alertTime = alertTime;
        this.email = email;
        this.phone = phone;
    }

        /**
     * Gets the unique identifier for the alert.
     *
     * @return The alert ID.
     */
    public int getUserID() {
        return userID;
    }

      /**
     * Sets the unique identifier for the alert.
     *
     * @param alertID The alert ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
       /**
     * Gets the unique identifier of the user associated with the alert.
     *
     * @return The user ID.
     */

    public int getAlertID() {
        return alertID;
    }
    
       /**
     * Sets the unique identifier of the user associated with the alert.
     *
     * @param userID The user ID to set.
     */

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }
    
      /**
     * Gets the unique identifier of the item associated with the alert.
     *
     * @return The item ID.
     */

    public int getItemID() {
        return itemID;
    }
    
       /**
     * Sets the unique identifier of the item associated with the alert.
     *
     * @param itemID The item ID to set.
     */

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
      /**
     * Gets the type of alert, represented by an integer.
     *
     * @return The alert type ID.
     */

    public int getAlertTypeID() {
        return alertTypeID;
    }
        /**
     * Sets the type of alert, represented by an integer.
     *
     * @param alertTypeID The alert type ID to set.
     */

    public void setAlertTypeID(int alertTypeID) {
        this.alertTypeID = alertTypeID;
    }
    
     /**
     * Gets the time at which the alert was triggered.
     *
     * @return The alert time.
     */

    public Date getAlertTime() {
        return alertTime;
    }
    
      /**
     * Sets the time at which the alert was triggered.
     *
     * @param alertTime The alert time to set.
     */

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }
    
        /**
     * Gets the email address associated with the alert.
     *
     * @return The email address.
     */

    public String getEmail() {
        return email;
    }
    
      /**
     * Sets the email address associated with the alert.
     *
     * @param email The email address to set.
     */

    public void setEmail(String email) {
        this.email = email;
    }
       /**
     * Gets the phone number associated with the alert.
     *
     * @return The phone number.
     */

    public String getPhone() {
        return phone;
    }
    
        /**
     * Sets the phone number associated with the alert.
     *
     * @param phone The phone number to set.
     */

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
