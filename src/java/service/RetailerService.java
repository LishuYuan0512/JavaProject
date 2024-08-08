package service;

import entity.Retailer;

/**
 * The RetailerService interface provides methods related to retailer operations.
 * This includes functionality for retailer authentication.
 */
public interface RetailerService {

    /**
     * Authenticates a retailer using the provided email and password.
     *
     * @param email    The email address of the retailer trying to log in.
     * @param password The password associated with the retailer's account.
     * @return The Retailer object if authentication is successful; otherwise, returns null.
     * @throws IllegalArgumentException if email or password is null or empty.
     */
    public Retailer login(String email, String password);
}
