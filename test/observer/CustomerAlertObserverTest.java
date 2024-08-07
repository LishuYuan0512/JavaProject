/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package observer;

import entity.FoodItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for CustomerAlertObserver class.
 * This test verifies the behavior of the CustomerAlertObserver when a FoodItem is updated.
 */

public class CustomerAlertObserverTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

     /**
     * Sets up the output stream to capture console output for testing purposes.
     * This method is called before each test is executed.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    /**
     * Restores the original system output stream.
     * This method is called after each test is executed.
     */

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    /**
     * Tests the update method of CustomerAlertObserver.
     * This test checks if the console output contains the expected alert message when a FoodItem is updated with isPlus set to true.
     */

    @Test
    public void testUpdateWithIsPlus() {
        // Create an instance of FoodItem and set isPlus to 1
        FoodItem testItem = new FoodItem(1, "Apple", 10);
        testItem.setIsPlus(1);  // 假设FoodItem有一个setIsPlus方法

         // Create an instance of CustomerAlertObserver and call the update method
        CustomerAlertObserver observer = new CustomerAlertObserver();
        observer.update(testItem);

         // Check if the console output contains the expected message
        String expectedOutput = "Alert: New Food Item Added/Updated with isPlus=true: " + testItem;
        assertTrue("Expected output not found in console output", outContent.toString().contains(expectedOutput));
    }
}
