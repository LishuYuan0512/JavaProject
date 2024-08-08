package service;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import entity.Customer;
import utils.DbUtil;

/**
 * Implementation of the CustomerService interface, providing methods for customer operations.
 * This class handles customer authentication with transaction management.
 */
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    /**
     * Authenticates a customer using the provided email and password.
     * Begins a transaction, retrieves the customer from the database by email,
     * and checks if the password matches.
     *
     * @param email    The email address of the customer trying to log in.
     * @param password The password associated with the customer's account.
     * @return The Customer object if authentication is successful; otherwise, returns null.
     * @throws RuntimeException if an error occurs during the authentication process.
     */
    @Override
    public Customer login(String email, String password) {
        Customer customer = null;
        try {
            // Begin a transaction
            DbUtil.begin();

            // Retrieve customer by email
            Customer temp = customerDAO.selectCustomerByEmail(email);

            // Check if the customer exists and the password matches
            if (temp != null && temp.getPassword().equals(password)) {
                customer = temp;
            }

            // Commit the transaction
            DbUtil.commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            DbUtil.rollback();
            throw new RuntimeException("Error during login: " + e.getMessage(), e);
        }
        return customer;
    }
}
