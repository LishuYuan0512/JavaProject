package dao;

import entity.Customer;

import java.util.List;

/**
 * Interface for Customer Data Access Object (DAO).
 * Provides methods for CRUD operations on Customer entities.
 */

public interface CustomerDAO {
    
      /**
     * Selects all customers from the database.
     * @return a list of all Customer objects in the database
     */
        public List<Customer> selectAllCustomer();
            /**
     * Deletes a customer from the database by email.
     * @param email the email of the customer to delete
     * @return the number of rows affected
     */
        public int deleteCustomer(String email);
         /**
     * Updates an existing customer in the database.
     * @param customer the Customer object with updated information
     * @return the number of rows affected
     */
        public int updateCustomer(Customer customer);
            /**
     * Inserts a new customer into the database.
     * @param customer the Customer object to insert
     * @return the number of rows affected
     */

        public int insertCustomer(Customer customer);
            /**
     * Selects a customer from the database by email.
     * @param email the email of the customer to select
     * @return the Customer object with the specified email, or null if not found
     */
        public Customer selectCustomerByEmail(String email);
            /**
     * Retrieves the user ID for a customer based on their email.
     * @param email the email of the customer
     * @return the user ID of the customer
     */
        public int getUserIDByEmail(String email);
           /**
     * Retrieves the user type for a customer based on their user ID.
     * @param customer the Customer object
     * @return the user type of the customer
     */
        public String getUserTypeByUserID(Customer customer);
}
