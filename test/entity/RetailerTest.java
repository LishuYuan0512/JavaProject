/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the Retailer class.
 * This test verifies the getter and setter methods in the Retailer class.
 */
public class RetailerTest {
    private Retailer retailer;

    /**
     * Sets up the test environment by initializing a Retailer instance with test data.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        retailer = new Retailer(2, "JaneRetail", "securePass123", "jane.retail@example.com", "987-654-3210", "retailer", 101);
    }

    /**
     * Tests the getUserID method.
     * This test verifies that the user ID is retrieved correctly.
     */
    @Test
    public void testGetUserID() {
        assertEquals(2, retailer.getUserID());
    }

    /**
     * Tests the getUsername method.
     * This test verifies that the username is retrieved correctly.
     */
    @Test
    public void testGetUsername() {
        assertEquals("JaneRetail", retailer.getUsername());
    }

    /**
     * Tests the getPassword method.
     * This test verifies that the password is retrieved correctly.
     */
    @Test
    public void testGetPassword() {
        assertEquals("securePass123", retailer.getPassword());
    }

    /**
     * Tests the getEmail method.
     * This test verifies that the email is retrieved correctly.
     */
    @Test
    public void testGetEmail() {
        assertEquals("jane.retail@example.com", retailer.getEmail());
    }

    /**
     * Tests the getPhone method.
     * This test verifies that the phone number is retrieved correctly.
     */
    @Test
    public void testGetPhone() {
        assertEquals("987-654-3210", retailer.getPhone());
    }

    /**
     * Tests the getUserType method.
     * This test verifies that the user type is retrieved correctly.
     */
    @Test
    public void testGetUserType() {
        assertEquals("retailer", retailer.getUserType());
    }

    /**
     * Tests the getLocationID method.
     * This test verifies that the location ID is retrieved correctly.
     */
    @Test
    public void testGetLocationID() {
        assertEquals(101, retailer.getLocationID());
    }

    /**
     * Tests the setUsername method.
     * This test verifies that the username is set and retrieved correctly.
     */
    @Test
    public void testSetUsername() {
        retailer.setUsername("NewJaneRetail");
        assertEquals("NewJaneRetail", retailer.getUsername());
    }

    // Additional setter tests similar to testSetUsername can be added here.
}
