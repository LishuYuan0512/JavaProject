package entity;

/**
 * Represents a charity organization that is a type of user.
 * Inherits from the User class, including all user-related attributes.
 */
public class Charity extends User {

    /**
     * Default constructor for the Charity class.
     * Initializes a new instance of the Charity class with default values.
     */
    public Charity() {
    }

    /**
     * Constructs a Charity with specified user details.
     *
     * @param username   The username of the charity.
     * @param password   The password of the charity.
     * @param email      The email address of the charity.
     * @param phone      The phone number of the charity.
     * @param userType   The type of user, which is "charity" in this case.
     * @param locationID The location ID associated with the charity.
     */
    public Charity(String username, String password, String email, String phone, String userType, int locationID) {
        super(username, password, email, phone, userType, locationID);
    }

    /**
     * Constructs a Charity with a user ID and specified user details.
     *
     * @param userID     The unique identifier for the charity.
     * @param username   The username of the charity.
     * @param password   The password of the charity.
     * @param email      The email address of the charity.
     * @param phone      The phone number of the charity.
     * @param userType   The type of user, which is "charity" in this case.
     * @param locationID The location ID associated with the charity.
     */
    public Charity(int userID, String username, String password, String email, String phone, String userType, int locationID) {
        super(userID, username, password, email, phone, userType, locationID);
    }
}
