package alertType;

public class AlertType {
    private int alertTypeID;
    private String alertTypeName;

    // Constructors
    public AlertType() {}

    public AlertType(int alertTypeID, String alertTypeName) {
        this.alertTypeID = alertTypeID;
        this.alertTypeName = alertTypeName;
    }

    // Getters and Setters
    public int getAlertTypeID() {
        return alertTypeID;
    }

    public void setAlertTypeID(int alertTypeID) {
        this.alertTypeID = alertTypeID;
    }

    public String getAlertTypeName() {
        return alertTypeName;
    }

    public void setAlertTypeName(String alertTypeName) {
        this.alertTypeName = alertTypeName;
    }
}