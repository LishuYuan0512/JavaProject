/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit test for the Alert class.
 * This test verifies the getter and setter methods for various fields in the Alert class.
 */

public class AlertTest {
    private Alert alert;
    private Date testDate;

   /**
     * Sets up the test environment by initializing an Alert instance with test data.
     * This method is called before each test is executed.
     */

    @Before
    public void setUp() {
        testDate = new Date();  // Sets the current date and time
        alert = new Alert(1, 100, 200, 300, testDate, "user@example.com", "123-456-7890");
    }

    /**
     * Tests the get and set methods for alertID.
     * This test verifies that the alertID can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetAlertID() {
        alert.setAlertID(2);
        assertEquals(2, alert.getAlertID());
    }
    /**
     * Tests the get and set methods for userID.
     * This test verifies that the userID can be set and retrieved correctly.
     */

    @Test
    public void testGetAndSetUserID() {
        alert.setUserID(101);
        assertEquals(101, alert.getUserID());
    }

    /**
     * Tests the get and set methods for itemID.
     * This test verifies that the itemID can be set and retrieved correctly.
     */

    @Test
    public void testGetAndSetItemID() {
        alert.setItemID(201);
        assertEquals(201, alert.getItemID());
    }

   /**
     * Tests the get and set methods for alertTypeID.
     * This test verifies that the alertTypeID can be set and retrieved correctly.
     */

    @Test
    public void testGetAndSetAlertTypeID() {
        alert.setAlertTypeID(301);
        assertEquals(301, alert.getAlertTypeID());
    }

     /**
     * Tests the get and set methods for alertTime.
     * This test verifies that the alertTime can be set and retrieved correctly.
     */

    @Test
    public void testGetAndSetAlertTime() {
        Date newDate = new Date();
        alert.setAlertTime(newDate);
        assertEquals(newDate, alert.getAlertTime());
    }

    /**
     * Tests the get and set methods for email.
     * This test verifies that the email can be set and retrieved correctly.
     */

    @Test
    public void testGetAndSetEmail() {
        alert.setEmail("newuser@example.com");
        assertEquals("newuser@example.com", alert.getEmail());
    }

   /**
     * Tests the get and set methods for phone.
     * This test verifies that the phone can be set and retrieved correctly.
     */

    @Test
    public void testGetAndSetPhone() {
        alert.setPhone("987-654-3210");
        assertEquals("987-654-3210", alert.getPhone());
    }
}
