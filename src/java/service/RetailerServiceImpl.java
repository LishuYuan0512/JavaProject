package service;

import dao.RetailerDAO;
import dao.RetailerDAOImpl;
import entity.Retailer;
import utils.DbUtil;

/**
 * Implementation of the RetailerService interface, providing methods for retailer operations.
 * This class handles retailer authentication with transaction management.
 */
public class RetailerServiceImpl implements RetailerService {

    private final RetailerDAO retailerDAO = new RetailerDAOImpl();

    /**
     * Authenticates a retailer using the provided email and password.
     * Begins a transaction, retrieves the retailer from the database by email,
     * and checks if the password matches.
     *
     * @param email    The email address of the retailer trying to log in.
     * @param password The password associated with the retailer's account.
     * @return The Retailer object if authentication is successful; otherwise, returns null.
     * @throws RuntimeException if an error occurs during the authentication process.
     */
    @Override
    public Retailer login(String email, String password) {
        Retailer retailer = null;
        try {
            // Begin a transaction
            DbUtil.begin();

            // Retrieve retailer by email
            Retailer temp = retailerDAO.selectRetailerByEmail(email);

            // Check if the retailer exists and the password matches
            if (temp != null && temp.getPassword().equals(password)) {
                retailer = temp;
            }

            // Commit the transaction
            DbUtil.commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            DbUtil.rollback();
            throw new RuntimeException("Error during login: " + e.getMessage(), e);
        }
        return retailer;
    }
}
