package service;

import entity.Charity;

/**
 * The CharityService interface provides methods related to charity operations.
 * This includes functionality for charity authentication.
 */
public interface CharityService {

    /**
     * Authenticates a charity using the provided email and password.
     *
     * @param email    The email address of the charity trying to log in.
     * @param password The password associated with the charity's account.
     * @return The Charity object if authentication is successful; otherwise, returns null.
     * @throws IllegalArgumentException if email or password is null or empty.
     */
    public Charity login(String email, String password);
}
