/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.CustomerDAO;
import entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

/**
 * Unit tests for the CustomerServiceImpl class.
 * This class tests the customer authentication logic and transaction management using mocks.
 */
public class CustomerServiceImplTest {

    private CustomerService customerService;

    @Mock
    private CustomerDAO customerDAO;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the service and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the DbUtil static methods
        mockStatic(DbUtil.class);

        // Initialize the service with the mocked DAO
        customerService = new CustomerServiceImpl();
      
    }

    /**
     * Tests the login method of the CustomerServiceImpl class for successful authentication.
     * This test verifies that a customer is authenticated correctly with valid credentials.
     */
    @Test
    public void testLogin_Successful() {
        String email = "customer@example.com";
        String password = "password";

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        // Define the behavior of the mock
        when(customerDAO.selectCustomerByEmail(email)).thenReturn(customer);

        // Call the method to test
        Customer result = customerService.login(email, password);

        // Verify the result
        assertNotNull(result);
        assertEquals(email, result.getEmail());

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the login method of the CustomerServiceImpl class for failed authentication.
     * This test verifies that authentication fails with invalid credentials.
     */
    @Test
    public void testLogin_Failed() {
        String email = "customer@example.com";
        String password = "wrongpassword";

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword("password");

        // Define the behavior of the mock
        when(customerDAO.selectCustomerByEmail(email)).thenReturn(customer);

        // Call the method to test
        Customer result = customerService.login(email, password);

        // Verify the result
        assertNull(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the login method of the CustomerServiceImpl class for non-existent email.
     * This test verifies that authentication fails when the email does not exist.
     */
    @Test
    public void testLogin_EmailNotFound() {
        String email = "nonexistent@example.com";
        String password = "password";

        // Define the behavior of the mock
        when(customerDAO.selectCustomerByEmail(email)).thenReturn(null);

        // Call the method to test
        Customer result = customerService.login(email, password);

        // Verify the result
        assertNull(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    private void verifyStatic(Class<DbUtil> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
