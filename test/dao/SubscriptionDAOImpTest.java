/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

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
public class SubscriptionDAOImpTest {
    
    public SubscriptionDAOImpTest() {
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
     * Test of addSubscription method, of class SubscriptionDAOImp.
     */
    @Test
    public void testAddSubscription() {
        System.out.println("addSubscription");
        Subscription subscription = null;
        SubscriptionDAOImp instance = new SubscriptionDAOImp();
        instance.addSubscription(subscription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSubscription method, of class SubscriptionDAOImp.
     */
    @Test
    public void testUpdateSubscription() {
        System.out.println("updateSubscription");
        Subscription subscription = null;
        SubscriptionDAOImp instance = new SubscriptionDAOImp();
        instance.updateSubscription(subscription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subscriptionExists method, of class SubscriptionDAOImp.
     */
    @Test
    public void testSubscriptionExists() {
        System.out.println("subscriptionExists");
        int userID = 0;
        SubscriptionDAOImp instance = new SubscriptionDAOImp();
        boolean expResult = false;
        boolean result = instance.subscriptionExists(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
