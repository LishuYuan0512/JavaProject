/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.SubscriptionDao;
import entity.Subscription;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

/**
 * Unit tests for the SubscriptionServiceImpl class.
 * This class tests the subscription management logic and transaction handling using mocks.
 */
public class SubscriptionServiceImplTest {

    private SubscriptionService subscriptionService;

    @Mock
    private SubscriptionDao subscriptionDao;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the service and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the DbUtil static methods
        mockStatic(DbUtil.class);

//        // Initialize the service with the mocked DAO
//        subscriptionService = new SubscriptionServiceImpl();
//        ((SubscriptionServiceImpl) subscriptionService).subscriptionDao = subscriptionDao; // Inject mocked DAO
    }

    /**
     * Tests the createSubscription method of the SubscriptionServiceImpl class for successful creation.
     * This test verifies that a subscription is created correctly and the transaction is committed.
     */
    @Test
    public void testCreateSubscription_Successful() {
        Subscription subscription = new Subscription();
        subscription.setUserID(1);
        subscription.setLocationID(101);

        // Define the behavior of the mock
        doNothing().when(subscriptionDao).addSubscription(subscription);

        // Call the method to test
        boolean result = subscriptionService.createSubscription(subscription);

        // Verify the result
        assertTrue(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the createSubscription method of the SubscriptionServiceImpl class for failed creation.
     * This test verifies that an exception is thrown and the transaction is rolled back when an error occurs.
     */
    @Test(expected = RuntimeException.class)
    public void testCreateSubscription_Failed() {
        Subscription subscription = new Subscription();
        subscription.setUserID(1);
        subscription.setLocationID(101);

        // Define the behavior of the mock to throw an exception
        doThrow(new RuntimeException("Database error")).when(subscriptionDao).addSubscription(subscription);

        // Call the method to test
        subscriptionService.createSubscription(subscription);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.rollback();
    }

    /**
     * Tests the updateSubscription method of the SubscriptionServiceImpl class for successful update.
     * This test verifies that a subscription is updated correctly and the transaction is committed.
     */
    @Test
    public void testUpdateSubscription_Successful() {
        Subscription subscription = new Subscription();
        subscription.setUserID(1);
        subscription.setLocationID(101);

        // Define the behavior of the mock
        doNothing().when(subscriptionDao).updateSubscription(subscription);

        // Call the method to test
        boolean result = subscriptionService.updateSubscription(subscription);

        // Verify the result
        assertTrue(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the subscriptionExists method of the SubscriptionServiceImpl class.
     * This test verifies that the existence of a subscription is checked correctly.
     */
    @Test
    public void testSubscriptionExists() {
        int userID = 1;

        // Define the behavior of the mock
        when(subscriptionDao.subscriptionExists(userID)).thenReturn(true);

        // Call the method to test
        boolean result = subscriptionService.subscriptionExists(userID);

        // Verify the result
        assertTrue(result);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();
    }

    private void verifyStatic(Class<DbUtil> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
