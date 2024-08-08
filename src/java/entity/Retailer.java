package entity;

/**
 * Represents a retailer that is a type of user.
 * Inherits from the User class, including all user-related attributes.
 */
public class Retailer extends User {

    /**
     * Default constructor for the Retailer class.
     * Initializes a new instance of the Retailer class with default values.
     */
    public Retailer() {
    }

    /**
     * Constructs a Retailer with specified user details.
     *
     * @param username   The username of the retailer.
     * @param password   The password of the retailer.
     * @param email      The email address of the retailer.
     * @param phone      The phone number of the retailer.
     * @param userType   The type of user, which is "retailer" in this case.
     * @param locationID The location ID associated with the retailer.
     */
    public Retailer(String username, String password, String email, String phone, String userType, int locationID) {
        super(username, password, email, phone, userType, locationID);
    }

    /**
     * Constructs a Retailer with a user ID and specified user details.
     *
     * @param userID     The unique identifier for the retailer.
     * @param username   The username of the retailer.
     * @param password   The password of the retailer.
     * @param email      The email address of the retailer.
     * @param phone      The phone number of the retailer.
     * @param userType   The type of user, which is "retailer" in this case.
     * @param locationID The location ID associated with the retailer.
     */
    public Retailer(int userID, String username, String password, String email, String phone, String userType, int locationID) {
        super(userID, username, password, email, phone, userType, locationID);
    }
}
