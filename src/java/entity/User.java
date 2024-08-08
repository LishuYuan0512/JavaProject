package entity;

/**
 * Represents a user in the system, including essential details such as
 * user ID, username, password, email, phone number, user type, and location ID.
 * Serves as a base class for different types of users, such as customers, retailers, and charities.
 */
public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String userType;
    private int locationID;

    /**
     * Default constructor for the User class.
     * Initializes a new instance of the User class with default values.
     */
    public User() {
    }

    /**
     * Constructs a User with specified user details, excluding user ID.
     *
     * @param username   The username of the user.
     * @param password   The password of the user.
     * @param email      The email address of the user.
     * @param phone      The phone number of the user.
     * @param userType   The type of user, such as "customer", "retailer", or "charity".
     * @param locationID The location ID associated with the user.
     */
    public User(String username, String password, String email, String phone, String userType, int locationID) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userType = userType;
        this.locationID = locationID;
    }

    /**
     * Constructs a User with specified user details, including user ID.
     *
     * @param userID     The unique identifier for the user.
     * @param username   The username of the user.
     * @param password   The password of the user.
     * @param email      The email address of the user.
     * @param phone      The phone number of the user.
     * @param userType   The type of user, such as "customer", "retailer", or "charity".
     * @param locationID The location ID associated with the user.
     */
    public User(int userID, String username, String password, String email, String phone, String userType, int locationID) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userType = userType;
        this.locationID = locationID;
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param userID The user ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the type of user, such as "customer", "retailer", or "charity".
     *
     * @return The user type.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the type of user, such as "customer", "retailer", or "charity".
     *
     * @param userType The user type to set.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Gets the location ID associated with the user.
     *
     * @return The location ID.
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Sets the location ID associated with the user.
     *
     * @param locationID The location ID to set.
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}
