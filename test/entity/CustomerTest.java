/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the Customer class.
 * This test verifies the getter methods and the toString method in the Customer class.
 */
public class CustomerTest {
    private Customer customer;

    /**
     * Sets up the test environment by initializing a Customer instance with test data.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        customer = new Customer("JaneDoe", "password123", "jane.doe@example.com", "123-456-7890", "customer", 100);
    }

    /**
     * Tests the getUsername method.
     * This test verifies that the username is retrieved correctly.
     */
    @Test
    public void testGetUsername() {
        assertEquals("JaneDoe", customer.getUsername());
    }

    /**
     * Tests the getPassword method.
     * This test verifies that the password is retrieved correctly.
     */
    @Test
    public void testGetPassword() {
        assertEquals("password123", customer.getPassword());
    }

    /**
     * Tests the getEmail method.
     * This test verifies that the email is retrieved correctly.
     */
    @Test
    public void testGetEmail() {
        assertEquals("jane.doe@example.com", customer.getEmail());
    }

    /**
     * Tests the getPhone method.
     * This test verifies that the phone number is retrieved correctly.
     */
    @Test
    public void testGetPhone() {
        assertEquals("123-456-7890", customer.getPhone());
    }

    /**
     * Tests the getUserType method.
     * This test verifies that the user type is retrieved correctly.
     */
    @Test
    public void testGetUserType() {
        assertEquals("customer", customer.getUserType());
    }

    /**
     * Tests the toString method.
     * This test verifies that the string representation of the customer is formatted correctly.
     */
    @Test
    public void testToString() {
        String expectedString = "JaneDoe password123 jane.doe@example.com 123-456-7890 customer";
        assertEquals(expectedString, customer.toString());
    }
}
