/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import entity.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the CustomerDAOImpl class.
 * This class tests the database operations for Customer entities using mocks.
 */
public class CustomerDAOImplTest {

    private CustomerDAO customerDAO;
    private QueryRunner queryRunner;

    @Mock
    private Connection connection;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the DAO and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the QueryRunner
        queryRunner = mock(QueryRunner.class);

        // Mock the DbUtil.getConnection() method
        mockStatic(DbUtil.class);
        when(DbUtil.getConnection()).thenReturn(connection);

        // Initialize the DAO
        customerDAO = new CustomerDAOImpl();
        ((CustomerDAOImpl) customerDAO).queryRunner = queryRunner; // Inject mocked QueryRunner
    }

    /**
     * Tests the selectAllCustomer method of the CustomerDAOImpl class.
     * This test verifies that all customers are selected from the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectAllCustomer() throws SQLException {
        List<Customer> expectedCustomers = new ArrayList<>();
        expectedCustomers.add(new Customer("user1", "password1", "user1@example.com", "1234567890", "Customer", 1));
        expectedCustomers.add(new Customer("user2", "password2", "user2@example.com", "0987654321", "Customer", 2));

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanListHandler.class))).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = customerDAO.selectAllCustomer();
        assertNotNull(actualCustomers);
        assertEquals(expectedCustomers.size(), actualCustomers.size());

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from Users where userType = 'Customer';"), any(BeanListHandler.class));
    }

    /**
     * Tests the deleteCustomer method of the CustomerDAOImpl class.
     * This test verifies that a customer is deleted from the database by email.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testDeleteCustomer() throws SQLException {
        when(queryRunner.update(any(Connection.class), anyString(), anyString())).thenReturn(1);

        int rowsAffected = customerDAO.deleteCustomer("user1@example.com");
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("delete from Users where email = ?;"), eq("user1@example.com"));
    }

    /**
     * Tests the updateCustomer method of the CustomerDAOImpl class.
     * This test verifies that an existing customer is updated in the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateCustomer() throws SQLException {
        Customer customer = new Customer("user1", "newpassword", "user1@example.com", "1234567890", "Customer", 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), any())).thenReturn(1);

        int rowsAffected = customerDAO.updateCustomer(customer);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update Users set username=?,password=?;"),
                eq(customer.getUsername()), eq(customer.getPassword()));
    }

    /**
     * Tests the insertCustomer method of the CustomerDAOImpl class.
     * This test verifies that a new customer is inserted into the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertCustomer() throws SQLException {
        Customer customer = new Customer("user1", "password", "user1@example.com", "1234567890", "Customer", 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int rowsAffected = customerDAO.insertCustomer(customer);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("insert into Consumer (userName, password, email, phone, userType, locationID) values (?, ?,?,?,?,?);"),
                eq(customer.getUsername()), eq(customer.getPassword()), eq(customer.getEmail()), eq(customer.getPhone()), eq(customer.getUserType()), eq(customer.getLocationID()));
    }

    /**
     * Tests the selectCustomerByEmail method of the CustomerDAOImpl class.
     * This test verifies that a customer is selected by their email.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectCustomerByEmail() throws SQLException {
        Customer expectedCustomer = new Customer("user1", "password", "user1@example.com", "1234567890", "Customer", 1);

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanHandler.class), anyString())).thenReturn(expectedCustomer);

        Customer actualCustomer = customerDAO.selectCustomerByEmail("user1@example.com");
        assertNotNull(actualCustomer);
        assertEquals(expectedCustomer, actualCustomer);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from Consumer where email = ?;"), any(BeanHandler.class), eq("user1@example.com"));
    }

    /**
     * Tests the getUserIDByEmail method of the CustomerDAOImpl class.
     * This test verifies that the user ID is retrieved based on email.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testGetUserIDByEmail() throws SQLException {
        when(queryRunner.query(any(Connection.class), anyString(), any(ScalarHandler.class), anyString())).thenReturn(1L);

        int userID = customerDAO.getUserIDByEmail("user1@example.com");
        assertEquals(1, userID);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select userID from Consumer where email = ?;"), any(ScalarHandler.class), eq("user1@example.com"));
    }

    /**
     * Tests the getUserTypeByUserID method of the CustomerDAOImpl class.
     * This test verifies that the user type is retrieved based on user ID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testGetUserTypeByUserID() throws SQLException {
        Customer customer = new Customer();
        customer.setUserID(1);

        when(queryRunner.query(any(Connection.class), anyString(), any(ScalarHandler.class), anyInt())).thenReturn("Customer");

        String userType = customerDAO.getUserTypeByUserID(customer);
        assertEquals("Customer", userType);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select userType from Consumer where userID = ?;"), any(ScalarHandler.class), eq(customer.getUserID()));
    }
}
