package service;

import entity.Customer;

/**
 * The CustomerService interface provides methods related to customer operations.
 * This includes functionality for customer authentication.
 */
public interface CustomerService {

    /**
     * Authenticates a customer using the provided email and password.
     *
     * @param email    The email address of the customer trying to log in.
     * @param password The password associated with the customer's account.
     * @return The Customer object if authentication is successful; otherwise, returns null.
     * @throws IllegalArgumentException if email or password is null or empty.
     */
    public Customer login(String email, String password);
}
