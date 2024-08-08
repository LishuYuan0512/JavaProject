package entity;

/**
 * Represents a subscription associated with a user, including details
 * about the user's preferences, contact information, and communication methods.
 */
public class Subscription {
    private int userID;
    private int locationID;
    private int foodPrefer;
    private String email;
    private String phone;
    private int communicationMethod;

    /**
     * Default constructor for the Subscription class.
     * Initializes a new instance of the Subscription class with default values.
     */
    public Subscription() {
    }

    /**
     * Constructs a Subscription with specified user and subscription details.
     *
     * @param userID             The unique identifier of the user associated with the subscription.
     * @param locationID         The location ID associated with the subscription.
     * @param foodPrefer         The food preference represented as an integer.
     * @param email              The email address associated with the subscription.
     * @param phone              The phone number associated with the subscription.
     */
    public Subscription(int userID, int locationID, int foodPrefer, String email, String phone) {
        this.userID = userID;
        this.locationID = locationID;
        this.foodPrefer = foodPrefer;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Gets the unique identifier of the user associated with the subscription.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the unique identifier of the user associated with the subscription.
     *
     * @param userID The user ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the location ID associated with the subscription.
     *
     * @return The location ID.
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Sets the location ID associated with the subscription.
     *
     * @param locationID The location ID to set.
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    /**
     * Gets the food preference associated with the subscription.
     *
     * @return The food preference.
     */
    public int getFoodPrefer() {
        return foodPrefer;
    }

    /**
     * Sets the food preference associated with the subscription.
     *
     * @param foodPrefer The food preference to set.
     */
    public void setFoodPrefer(int foodPrefer) {
        this.foodPrefer = foodPrefer;
    }

    /**
     * Gets the email address associated with the subscription.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address associated with the subscription.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number associated with the subscription.
     *
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number associated with the subscription.
     *
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the communication method associated with the subscription.
     *
     * @return The communication method.
     */
    public int getCommunicationMethod() {
        return communicationMethod;
    }

    /**
     * Sets the communication method associated with the subscription.
     *
     * @param communicationMethod The communication method to set.
     */
    public void setCommunicationMethod(int communicationMethod) {
        this.communicationMethod = communicationMethod;
    }

    /**
     * Returns a string representation of the subscription, including user details,
     * location, preferences, and contact information.
     *
     * @return A string containing the subscription's details.
     */
    @Override
    public String toString() {
        return "Subscription{" +
                "userID=" + userID +
                ", locationID=" + locationID +
                ", foodPrefer=" + foodPrefer +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", communicationMethod=" + communicationMethod +
                '}';
    }
}
