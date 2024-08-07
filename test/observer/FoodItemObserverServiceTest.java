/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Calendar;
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
        service = new FoodItemObserverService() {
            @Override
            public void notifyObservers(Subscription subscription) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void update(FoodItem foodItem) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }; // Instantiate as anonymous subclass
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
        // Set dates using Calendar for Date objects
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // 1 day ago
        Date restockTime = calendar.getTime();
        
        calendar.add(Calendar.DATE, 6); // 5 days later (6 days from now)
        Date expirationDate = calendar.getTime();

        FoodItem testItem = new FoodItem(1, 1, "Apple", 10, restockTime, expirationDate, 2.99, 1, 1);
        testItem.setIsPlus(1); 

        service.addOrUpdateFoodItem(testItem);

        // Verify that the update method was triggered and output contains the expected message
        String expectedOutput = "Observer updated with: " + testItem;
        assertTrue("Observer was not notified correctly", outContent.toString().contains(expectedOutput));
    }

    /**
     * Tests the notifyObservers method with a FoodItem that has isPlus set to false.
     * This test ensures that the observer is not notified when isPlus is false.
     */
    @Test
    public void testNotifyObserversWithoutIsPlus() {
        // Set dates using Calendar for Date objects
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // 1 day ago
        Date restockTime = calendar.getTime();
        
        calendar.add(Calendar.DATE, 6); // 5 days later (6 days from now)
        Date expirationDate = calendar.getTime();

        FoodItem testItem = new FoodItem(2, 1, "Banana", 5, restockTime, expirationDate, 1.49, 1, 0);
        testItem.setIsPlus(0); 

        service.addOrUpdateFoodItem(testItem);

        // Verify that the update method was not triggered
        String unexpectedOutput = "Observer updated with: " + testItem;
        assertFalse("Observer should not be notified", outContent.toString().contains(unexpectedOutput));
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

        @Override
        public void update(Subscription subscription) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
