/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import entity.Subscription;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tangy
 */
public class SubscriptionServiceImplTest {
    
    public SubscriptionServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSubscription method, of class SubscriptionServiceImpl.
     */
    @Test
    public void testCreateSubscription() {
        System.out.println("createSubscription");
        Subscription subscription = null;
        SubscriptionServiceImpl instance = new SubscriptionServiceImpl();
        boolean expResult = false;
        boolean result = instance.createSubscription(subscription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSubscription method, of class SubscriptionServiceImpl.
     */
    @Test
    public void testUpdateSubscription() {
        System.out.println("updateSubscription");
        Subscription subscription = null;
        SubscriptionServiceImpl instance = new SubscriptionServiceImpl();
        boolean expResult = false;
        boolean result = instance.updateSubscription(subscription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subscriptionExists method, of class SubscriptionServiceImpl.
     */
    @Test
    public void testSubscriptionExists() {
        System.out.println("subscriptionExists");
        int userID = 0;
        SubscriptionServiceImpl instance = new SubscriptionServiceImpl();
        boolean expResult = false;
        boolean result = instance.subscriptionExists(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
