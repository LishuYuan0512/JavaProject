package entity;

/**
 * Represents a customer that is a type of user.
 * Inherits from the User class, including all user-related attributes.
 */
public class Customer extends User {

    /**
     * Default constructor for the Customer class.
     * Initializes a new instance of the Customer class with default values.
     */
    public Customer() {
    }

    /**
     * Constructs a Customer with specified user details.
     *
     * @param username   The username of the customer.
     * @param password   The password of the customer.
     * @param email      The email address of the customer.
     * @param phone      The phone number of the customer.
     * @param userType   The type of user, which is "customer" in this case.
     * @param locationID The location ID associated with the customer.
     */
    public Customer(String username, String password, String email, String phone, String userType, int locationID) {
        super(username, password, email, phone, userType, locationID);
    }

    /**
     * Returns a string representation of the customer, including username,
     * password, email, phone, and user type.
     *
     * @return A string containing the customer's details.
     */
    @Override
    public String toString() {
        return this.getUsername() + " " + this.getPassword() + " " + this.getEmail() + " " + this.getPhone() + " " + this.getUserType();
    }
}
