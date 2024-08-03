package entity;
import java.util.Date;
public class Alert {
    private int alertID;
    private int userID;
    private int itemID;
    private int alertTypeID;
    private Date alertTime;
    private String email;
    private String phone;

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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
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

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
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
