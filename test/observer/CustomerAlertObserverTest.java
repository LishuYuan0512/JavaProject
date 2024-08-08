/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package observer;

import entity.Subscription;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for CustomerAlertObserver class.
 * This test verifies the behavior of the CustomerAlertObserver when a Subscription is updated.
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
     * Tests the update method of CustomerAlertObserver for email communication.
     * This test checks if the console output contains the expected alert message when a Subscription is updated with communicationMethod set to 1 (email).
     */
    @Test
    public void testUpdateWithEmailCommunication() {
        // Create an instance of Subscription with communicationMethod set to 1 (email)
        Subscription testSubscription = new Subscription(1, 101, 5, "test@example.com", "123-456-7890");
        testSubscription.setCommunicationMethod(1);

        // Create an instance of CustomerAlertObserver and call the update method
        CustomerAlertObserver observer = new CustomerAlertObserver();
        observer.update(testSubscription);

        // Check if the console output contains the expected message
        String expectedOutput = "Receive Email:";
        assertTrue("Expected output not found in console output", outContent.toString().contains(expectedOutput));
    }
    
    /**
     * Tests the update method of CustomerAlertObserver for SMS communication.
     * This test checks if the console output contains the expected alert message when a Subscription is updated with communicationMethod set to 2 (SMS).
     */
    @Test
    public void testUpdateWithSMSCommunication() {
        // Create an instance of Subscription with communicationMethod set to 2 (SMS)
        Subscription testSubscription = new Subscription(2, 102, 6, "test@example.com", "123-456-7890");
        testSubscription.setCommunicationMethod(2);

        // Create an instance of CustomerAlertObserver and call the update method
        CustomerAlertObserver observer = new CustomerAlertObserver();
        observer.update(testSubscription);

        // Check if the console output contains the expected message
        String expectedOutput = "Receive message:";
        assertTrue("Expected output not found in console output", outContent.toString().contains(expectedOutput));
    }
    
    /**
     * Tests the update method of CustomerAlertObserver for invalid communication method.
     * This test checks if the console output contains the expected message when a Subscription is updated with an invalid communication method.
     */
    @Test
    public void testUpdateWithInvalidCommunicationMethod() {
        // Create an instance of Subscription with an invalid communication method
        Subscription testSubscription = new Subscription(3, 103, 7, "invalid@example.com", "123-456-7890");
        testSubscription.setCommunicationMethod(3);

        // Create an instance of CustomerAlertObserver and call the update method
        CustomerAlertObserver observer = new CustomerAlertObserver();
        observer.update(testSubscription);

        // Check if the console output contains the expected message
        String expectedOutput = "Invaid CommunicationMethod";
        assertTrue("Expected output not found in console output", outContent.toString().contains(expectedOutput));
    }
}
