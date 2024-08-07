/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the Charity class.
 * This test verifies the getter methods for various fields in the Charity class.
 */
public class CharityTest {
    private Charity charity;

    /**
     * Sets up the test environment by initializing a Charity instance with test data.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        charity = new Charity(1, "CharityName", "securePass", "charity@example.com", "123-456-7890", "nonprofit", 101);
    }

    /**
     * Tests the getUserID method.
     * This test verifies that the userID is retrieved correctly.
     */
    @Test
    public void testGetUserID() {
        assertEquals(1, charity.getUserID());
    }

    /**
     * Tests the getUsername method.
     * This test verifies that the username is retrieved correctly.
     */
    @Test
    public void testGetUsername() {
        assertEquals("CharityName", charity.getUsername());
    }

    /**
     * Tests the getPassword method.
     * This test verifies that the password is retrieved correctly.
     */
    @Test
    public void testGetPassword() {
        assertEquals("securePass", charity.getPassword());
    }

    /**
     * Tests the getEmail method.
     * This test verifies that the email is retrieved correctly.
     */
    @Test
    public void testGetEmail() {
        assertEquals("charity@example.com", charity.getEmail());
    }

    /**
     * Tests the getPhone method.
     * This test verifies that the phone number is retrieved correctly.
     */
    @Test
    public void testGetPhone() {
        assertEquals("123-456-7890", charity.getPhone());
    }

    /**
     * Tests the getUserType method.
     * This test verifies that the user type is retrieved correctly.
     */
    @Test
    public void testGetUserType() {
        assertEquals("nonprofit", charity.getUserType());
    }

    /**
     * Tests the getLocationID method.
     * This test verifies that the location ID is retrieved correctly.
     */
    @Test
    public void testGetLocationID() {
        assertEquals(101, charity.getLocationID());
    }
}
