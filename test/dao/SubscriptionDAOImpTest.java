/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import entity.Subscription;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit tests for the SubscriptionDAOImp class.
 * This class tests the database operations for Subscription entities using mocks.
 */
public class SubscriptionDAOImpTest {

    private SubscriptionDao subscriptionDao;
    private QueryRunner queryRunner;

    @Mock
    private Connection connection;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the DAO and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the QueryRunner
        queryRunner = mock(QueryRunner.class);

        // Mock the DbUtil.getConnection() method
        mockStatic(DbUtil.class);
        when(DbUtil.getConnection()).thenReturn(connection);

        // Initialize the DAO
        subscriptionDao = new SubscriptionDAOImp();
        ((SubscriptionDAOImp) subscriptionDao).queryRunner = queryRunner; // Inject mocked QueryRunner
    }

    /**
     * Tests the addSubscription method of the SubscriptionDAOImp class.
     * This test verifies that a new subscription is added to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testAddSubscription() throws SQLException {
        Subscription subscription = new Subscription();
        subscription.setUserID(1);
        subscription.setLocationID(101);
        subscription.setFoodPrefer(5);
        subscription.setCommunicationMethod(1);
        subscription.setEmail("test@example.com");
        subscription.setPhone("1234567890");

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        subscriptionDao.addSubscription(subscription);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("INSERT INTO Subscription (userID, locationID, foodPrefer, communicationMethod, email, phone) VALUES (?, ?, ?, ?, ?, ?)"),
                eq(subscription.getUserID()), eq(subscription.getLocationID()), eq(subscription.getFoodPrefer()),
                eq(subscription.getCommunicationMethod()), eq(subscription.getEmail()), eq(subscription.getPhone()));
    }

    /**
     * Tests the updateSubscription method of the SubscriptionDAOImp class.
     * This test verifies that an existing subscription is updated in the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateSubscription() throws SQLException {
        Subscription subscription = new Subscription();
        subscription.setUserID(1);
        subscription.setLocationID(102);
        subscription.setFoodPrefer(6);
        subscription.setCommunicationMethod(2);
        subscription.setEmail("update@example.com");
        subscription.setPhone("0987654321");

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        subscriptionDao.updateSubscription(subscription);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("UPDATE Subscription SET locationID = ?, foodPrefer = ?, communicationMethod = ?, email = ?, phone = ? WHERE userID = ?"),
                eq(subscription.getLocationID()), eq(subscription.getFoodPrefer()), eq(subscription.getCommunicationMethod()),
                eq(subscription.getEmail()), eq(subscription.getPhone()), eq(subscription.getUserID()));
    }

    /**
     * Tests the subscriptionExists method of the SubscriptionDAOImp class.
     * This test verifies that the existence of a subscription is checked based on userID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSubscriptionExists() throws SQLException {
        when(queryRunner.query(any(Connection.class), anyString(), any(ScalarHandler.class), anyInt())).thenReturn(1L);

        boolean exists = subscriptionDao.subscriptionExists(1);
        assertTrue(exists);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("SELECT COUNT(*) FROM Subscription WHERE userID = ?"), any(ScalarHandler.class), eq(1));
    }
}
