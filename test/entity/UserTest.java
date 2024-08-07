/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the User class.
 * This test verifies the getter and setter methods in the User class.
 */
public class UserTest {
    private User user;
    
    /**
     * Sets up the test environment by initializing a User instance with test data.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        user = new User(1, "JohnDoe", "password123", "john.doe@example.com", "123-456-7890", "admin", 100);
    }

    /**
     * Tests the getUserID method.
     * This test verifies that the user ID is retrieved correctly.
     */
    @Test
    public void testGetUserID() {
        assertEquals(1, user.getUserID());
    }

    /**
     * Tests the getUsername method.
     * This test verifies that the username is retrieved correctly.
     */
    @Test
    public void testGetUsername() {
        assertEquals("JohnDoe", user.getUsername());
    }

    /**
     * Tests the getPassword method.
     * This test verifies that the password is retrieved correctly.
     */
    @Test
    public void testGetPassword() {
        assertEquals("password123", user.getPassword());
    }

    /**
     * Tests the getEmail method.
     * This test verifies that the email is retrieved correctly.
     */
    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", user.getEmail());
    }

    /**
     * Tests the getPhone method.
     * This test verifies that the phone number is retrieved correctly.
     */
    @Test
    public void testGetPhone() {
        assertEquals("123-456-7890", user.getPhone());
    }

    /**
     * Tests the getUserType method.
     * This test verifies that the user type is retrieved correctly.
     */
    @Test
    public void testGetUserType() {
        assertEquals("admin", user.getUserType());
    }

    /**
     * Tests the getLocationID method.
     * This test verifies that the location ID is retrieved correctly.
     */
    @Test
    public void testGetLocationID() {
        assertEquals(100, user.getLocationID());
    }

    /**
     * Tests the setUsername method.
     * This test verifies that the username is set and retrieved correctly.
     */
    @Test
    public void testSetUsername() {
        user.setUsername("JaneDoe");
        assertEquals("JaneDoe", user.getUsername());
    }

    // Additional setter tests similar to testSetUsername can be added here.
}
