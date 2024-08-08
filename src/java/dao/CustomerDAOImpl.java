package dao;

import entity.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the CustomerDAO interface.
 * Provides database operations for Customer entities using Apache Commons DbUtils.
 */

public class CustomerDAOImpl implements CustomerDAO{
    private QueryRunner queryRunner = new QueryRunner();
    
        /**
     * Selects all customers from the database.
     * @return a list of all Customer objects in the database
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public List<Customer> selectAllCustomer() {
        try {
            List<Customer> customers = queryRunner.query(DbUtil.getConnection(), "select * from Users where userType = 'Customer';",
                    new BeanListHandler<Customer>(Customer.class));
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
       /**
     * Deletes a customer from the database by email.
     * @param email the email of the customer to delete
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int deleteCustomer(String email) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"delete from Users where email = ?;",email);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
       /**
     * Updates an existing customer in the database.
     * @param customer the Customer object with updated information
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */


    @Override
    public int updateCustomer(Customer customer) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"update Users set username=?,password=?;",
                    customer.getUsername(),customer.getPassword());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Inserts a new customer into the database.
     * @param customer the Customer object to insert
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int insertCustomer(Customer customer) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "insert into Consumer (userName, password, email, phone, userType, locationID) values (?, ?,?,?,?,?);",
                    customer.getUsername(), customer.getPassword(), customer.getEmail(), customer.getPhone(),
                    customer.getUserType(),customer.getLocationID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Selects a customer from the database by email.
     * @param email the email of the customer to select
     * @return the Customer object with the specified email, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public Customer selectCustomerByEmail(String email) {
        try {
            Customer customer = queryRunner.query(DbUtil.getConnection(),"select * from Consumer where email = ?;",
                    new BeanHandler<Customer>(Customer.class),email);
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Retrieves the user ID for a customer based on their email.
     * @param email the email of the customer
     * @return the user ID of the customer
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int getUserIDByEmail(String email) {
        try {
            ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
            Long userID = queryRunner.query(DbUtil.getConnection(),"select userID from Consumer where email = ?;",
                    scalarHandler,email);
            return userID.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Retrieves the user type for a customer based on their user ID.
     * @param customer the Customer object
     * @return the user type of the customer
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public String getUserTypeByUserID(Customer customer) {
        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        try {
            String userType = String.valueOf(queryRunner.query(DbUtil.getConnection(),"select userType from Consumer where userID = ?;",
                    scalarHandler,customer.getUserID()));
            return userType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}



