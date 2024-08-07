/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package observer;

import entity.FoodItem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;

/**
 * Unit test for the FoodItemObserverService class.
 * This test verifies that observers are correctly notified when a FoodItem is added or updated.
 */

public class FoodItemObserverServiceTestTest {
    private FoodItemObserverService service;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

       /**
     * Sets up the test environment by initializing the FoodItemObserverService and capturing the console output.
     * Adds a CustomerAlertObserver to the service for notification testing.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        service = new FoodItemObserverService();

  
        CustomerAlertObserver customerAlertObserver = new CustomerAlertObserver();
        service.addObserver(customerAlertObserver);
    }

        /**
     * Restores the original system output stream.
     * This method is called after each test is executed to clean up the environment.
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests that the addOrUpdateFoodItem method notifies observers correctly.
     * This test checks if the observer receives the expected notification when a FoodItem is added or updated.
     */
    @Test
    public void testAddOrUpdateFoodItem_NotifiesObservers() {
        FoodItem foodItem = new FoodItem(1, "Apple", 10);
        foodItem.setIsPlus(1); // Set to trigger notification

        service.addOrUpdateFoodItem(foodItem);
        String expectedOutput = "Alert: New Food Item Added/Updated with isPlus=true: " + foodItem;
        assertTrue("Expected output was not found in the console output", outContent.toString().contains(expectedOutput));
    }
}
