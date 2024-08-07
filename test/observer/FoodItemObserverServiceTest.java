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
 * This test verifies that the observer is correctly notified when a FoodItem is added or updated.
 */

public class FoodItemObserverServiceTest {
    private FoodItemObserverService service;
    private TestObserver testObserver;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
  /**
     * Sets up the test environment by initializing the FoodItemObserverService and TestObserver.
     * It also redirects the system output to capture console messages for verification.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        service = new FoodItemObserverService();
        testObserver = new TestObserver();
        service.addObserver(testObserver);
        System.setOut(new PrintStream(outContent));
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
     * Tests the notifyObservers method with a FoodItem that has isPlus set to true.
     * This test checks if the observer is notified correctly when a FoodItem is added or updated.
     */
    @Test
    public void testNotifyObserversWithIsPlus() {
        FoodItem testItem = new FoodItem(1, "Apple", 10);
        testItem.setIsPlus(1); 

        service.addOrUpdateFoodItem(testItem);

      // Verify that the update method was triggered and output contains the expected message
        String expectedOutput = "Observer updated with: " + testItem;
        assertTrue("Observer was not notified correctly", outContent.toString().contains(expectedOutput));
    }

       /**
     * TestObserver is an implementation of the Observer interface used for testing.
     * It captures the update notification and prints it to the console.
     */
    class TestObserver implements Observer {
        @Override
        public void update(FoodItem foodItem) {
            System.out.println("Observer updated with: " + foodItem);
        }
    }
}
