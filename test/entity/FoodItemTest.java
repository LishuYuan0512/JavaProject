/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit test for the FoodItem class.
 * This test verifies the getter and setter methods and the isDateWithin7Days method in the FoodItem class.
 */
public class FoodItemTest {
    private FoodItem foodItem;
    private Date today;
    private Date sixDaysLater;
    private Date eightDaysLater;

    /**
     * Sets up the test environment by initializing a FoodItem instance with test data.
     * It also sets up date instances to test the date-related methods.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        sixDaysLater = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 2);  // Moving to 8 days later from today
        eightDaysLater = calendar.getTime();

        foodItem = new FoodItem(1, 100, "Apple", 50, today, sixDaysLater, 0.99, 1, 0);
    }

    /**
     * Tests the get and set methods for itemID.
     * This test verifies that the itemID can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetItemID() {
        foodItem.setItemID(2);
        assertEquals(2, foodItem.getItemID());
    }

    /**
     * Tests the get and set methods for userID.
     * This test verifies that the userID can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetUserID() {
        foodItem.setUserID(101);
        assertEquals(101, foodItem.getUserID());
    }

    /**
     * Tests the get and set methods for itemName.
     * This test verifies that the itemName can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetItemName() {
        foodItem.setItemName("Banana");
        assertEquals("Banana", foodItem.getItemName());
    }

    /**
     * Tests the get and set methods for quantity.
     * This test verifies that the quantity can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetQuantity() {
        foodItem.setQuantity(30);
        assertEquals(30, foodItem.getQuantity());
    }

    /**
     * Tests the get and set methods for restockTime.
     * This test verifies that the restockTime can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetRestockTime() {
        Date newRestockTime = new Date();
        foodItem.setRestockTime(newRestockTime);
        assertEquals(newRestockTime, foodItem.getRestockTime());
    }

    /**
     * Tests the get and set methods for expirationDate.
     * This test verifies that the expirationDate can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetExpirationDate() {
        Date newExpirationDate = new Date();
        foodItem.setExpirationDate(newExpirationDate);
        assertEquals(newExpirationDate, foodItem.getExpirationDate());
    }

    /**
     * Tests the get and set methods for price.
     * This test verifies that the price can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetPrice() {
        foodItem.setPrice(1.29);
        assertEquals(1.29, foodItem.getPrice(), 0.0);
    }

    /**
     * Tests the get and set methods for priceTypeID.
     * This test verifies that the priceTypeID can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetPriceTypeID() {
        foodItem.setPriceTypeID(2);
        assertEquals(2, foodItem.getPriceTypeID());
    }

    /**
     * Tests the get and set methods for isPlus.
     * This test verifies that isPlus can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetIsPlus() {
        foodItem.setIsPlus(1);
        assertEquals(1, foodItem.getIsPlus());
    }

    /**
     * Tests the get and set methods for discount.
     * This test verifies that the discount can be set and retrieved correctly.
     */
    @Test
    public void testGetAndSetDiscount() {
        foodItem.setDiscount(0.15);
        assertEquals(0.15, foodItem.getDiscount(), 0.0);
    }

    /**
     * Tests the isDateWithin7Days method.
     * This test verifies that the method returns true when the date is within 7 days.
     */
    @Test
    public void testIsDateWithin7Days_True() {
        assertTrue(foodItem.isDateWithin7Days(sixDaysLater));
    }

    /**
     * Tests the isDateWithin7Days method.
     * This test verifies that the method returns false when the date is not within 7 days.
     */
    @Test
    public void testIsDateWithin7Days_False() {
        assertFalse(foodItem.isDateWithin7Days(eightDaysLater));
    }
}
