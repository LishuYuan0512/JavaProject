/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import entity.Alert;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DbUtil;

/**
 * Unit tests for the AlertDAOImpl class.
 * This class tests the database operations for Alert entities using mocks.
 */
public class AlertDAOImplTest {

    private AlertDAO alertDAO;
    private QueryRunner queryRunner;
    private Connection connection;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the DAO and mocks necessary components.
     *
     * @throws Exception if an error occurs during setup
     */
    @Before
    public void setUp() throws Exception {
        // Mock the QueryRunner and Connection
        queryRunner = mock(QueryRunner.class);
        connection = mock(Connection.class);

        // Mock the DbUtil.getConnection() method
        mockStatic(DbUtil.class);
        when(DbUtil.getConnection()).thenReturn(connection);

       
    }

    /**
     * Tests the insertAlert method of the AlertDAOImpl class.
     * This test verifies that a new alert is inserted into the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertAlert() throws SQLException {
        Alert alert = new Alert(");

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int rowsAffected = alertDAO.insertAlert(alert);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("insert into Alert (userID, itemID, alertTypeID, alertTime, email, phone) values (?, ?,?,?,?,?);"),
                eq(alert.getAlertID()), eq(alert.getItemID()), eq(alert.getAlertTypeID()), any(), eq(alert.getEmail()), eq(alert.getPhone()));
    }

    /**
     * Tests the updateAlert method of the AlertDAOImpl class.
     * This test verifies that an existing alert is updated in the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateAlert() throws SQLException {
        Alert alert = new Alert(1, 2, 1, new java.util.Date(), "test@example.com", "1234567890");

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any())).thenReturn(1);

        int rowsAffected = alertDAO.updateAlert(alert);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update Alert set userID=?,itemID=?,alertType=?,alertTime=? where alertID =?;"),
                eq(alert.getUserID()), eq(alert.getItemID()), eq(alert.getAlertTypeID()), any(), eq(alert.getAlertID()));
    }

    /**
     * Tests the deleteAlert method of the AlertDAOImpl class.
     * This test verifies that an alert is deleted from the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testDeleteAlert() throws SQLException {
        Alert alert = new Alert(1, 2, 1, new java.util.Date(), "test@example.com", "1234567890");

        when(queryRunner.update(any(Connection.class), anyString(), any())).thenReturn(1);

        int rowsAffected = alertDAO.deleteAlert(alert);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("delete from Alert where alertID =?;"), eq(alert.getAlertID()));
    }

    /**
     * Tests the selectAlertByID method of the AlertDAOImpl class.
     * This test verifies that an alert is selected by its ID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectAlertByID() throws SQLException {
        Alert expectedAlert = new Alert(1, 2, 1, new java.util.Date(), "test@example.com", "1234567890");

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanHandler.class), anyInt())).thenReturn(expectedAlert);

        Alert actualAlert = alertDAO.selectAlertByID(1);
        assertNotNull(actualAlert);
        assertEquals(expectedAlert, actualAlert);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from Alert where alertID =?;"), any(BeanHandler.class), eq(1));
    }

    /**
     * Tests the selectAllAlerts method of the AlertDAOImpl class.
     * This test verifies that all alerts are selected from the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectAllAlerts() throws SQLException {
        List<Alert> expectedAlerts = new ArrayList<>();
        expectedAlerts.add(new Alert(1, 2, 1, new java.util.Date(), "test1@example.com", "1234567890"));
        expectedAlerts.add(new Alert(2, 3, 1, new java.util.Date(), "test2@example.com", "0987654321"));

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanListHandler.class))).thenReturn(expectedAlerts);

        List<Alert> actualAlerts = alertDAO.selectAllAlerts();
        assertNotNull(actualAlerts);
        assertEquals(expectedAlerts.size(), actualAlerts.size());

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from Alert ;"), any(BeanListHandler.class));
    }
}
