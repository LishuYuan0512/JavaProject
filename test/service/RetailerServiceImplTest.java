/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.RetailerDAO;
import entity.Retailer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

/**
 * Unit tests for the RetailerServiceImpl class.
 * This class tests the retailer authentication logic and transaction management using mocks.
 */
public class RetailerServiceImplTest {

    private RetailerService retailerService;

    @Mock
    private RetailerDAO retailerDAO;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the service and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the DbUtil static methods
        mockStatic(DbUtil.class);

//        // Initialize the service with the mocked DAO
//        retailerService = new RetailerServiceImpl();
//        ((RetailerServiceImpl) retailerService).retailerDAO = retailerDAO; // Inject mocked DAO
    }

    /**
     * Tests the login method of the RetailerServiceImpl class for successful authentication.
     * This test verifies that a retailer is authenticated correctly with valid credentials.
     */
    @Test
    public void testLogin_Successful() {
        String email = "retailer@example.com";
        String password = "password";

        Retailer retailer = new Retailer();
        retailer.setEmail(email);
        retailer.setPassword(password);

        // Define the behavior of the mock
        when(retailerDAO.selectRetailerByEmail(email)).thenReturn(retailer);

        // Call the method to test
        Retailer result = retailerService.login(email, password);

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
     * Tests the login method of the RetailerServiceImpl class for failed authentication.
     * This test verifies that authentication fails with invalid credentials.
     */
    @Test
    public void testLogin_Failed() {
        String email = "retailer@example.com";
        String password = "wrongpassword";

        Retailer retailer = new Retailer();
        retailer.setEmail(email);
        retailer.setPassword("password");

        // Define the behavior of the mock
        when(retailerDAO.selectRetailerByEmail(email)).thenReturn(retailer);

        // Call the method to test
        Retailer result = retailerService.login(email, password);

        // Verify the result
        assertNull(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the login method of the RetailerServiceImpl class for non-existent email.
     * This test verifies that authentication fails when the email does not exist.
     */
    @Test
    public void testLogin_EmailNotFound() {
        String email = "nonexistent@example.com";
        String password = "password";

        // Define the behavior of the mock
        when(retailerDAO.selectRetailerByEmail(email)).thenReturn(null);

        // Call the method to test
        Retailer result = retailerService.login(email, password);

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
