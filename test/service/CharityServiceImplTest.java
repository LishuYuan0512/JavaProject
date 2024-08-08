/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.CharityDAO;
import entity.Charity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

/**
 * Unit tests for the CharityServiceImpl class.
 * This class tests the charity authentication logic and transaction management using mocks.
 */
public class CharityServiceImplTest {

    private CharityService charityService;

    @Mock
    private CharityDAO charityDAO;

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
        charityService = new CharityServiceImpl();
        ((CharityServiceImpl) charityService).charityDAO = charityDAO; // Inject mocked DAO
    }

    /**
     * Tests the login method of the CharityServiceImpl class for successful authentication.
     * This test verifies that a charity is authenticated correctly with valid credentials.
     */
    @Test
    public void testLogin_Successful() {
        String email = "charity@example.com";
        String password = "password";

        Charity charity = new Charity();
        charity.setEmail(email);
        charity.setPassword(password);

        // Define the behavior of the mock
        when(charityDAO.selectCharityByEmail(email)).thenReturn(charity);

        // Call the method to test
        Charity result = charityService.login(email, password);

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
     * Tests the login method of the CharityServiceImpl class for failed authentication.
     * This test verifies that authentication fails with invalid credentials.
     */
    @Test
    public void testLogin_Failed() {
        String email = "charity@example.com";
        String password = "wrongpassword";

        Charity charity = new Charity();
        charity.setEmail(email);
        charity.setPassword("password");

        // Define the behavior of the mock
        when(charityDAO.selectCharityByEmail(email)).thenReturn(charity);

        // Call the method to test
        Charity result = charityService.login(email, password);

        // Verify the result
        assertNull(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the login method of the CharityServiceImpl class for non-existent email.
     * This test verifies that authentication fails when the email does not exist.
     */
    @Test
    public void testLogin_EmailNotFound() {
        String email = "nonexistent@example.com";
        String password = "password";

        // Define the behavior of the mock
        when(charityDAO.selectCharityByEmail(email)).thenReturn(null);

        // Call the method to test
        Charity result = charityService.login(email, password);

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
