/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.AlertDAO;
import entity.Alert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

/**
 * Unit tests for the AlertServiceImpl class.
 * This class tests the service methods for managing alerts using mocks.
 */
public class AlertServiceImplTest {

    private AlertService alertService;

    @Mock
    private AlertDAO alertDAO;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the service and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the DbUtil static methods
        mockStatic(DbUtil.class);

        // Initialize the service with the mocked DAO
        alertService = new AlertServiceImpl();
        ((AlertServiceImpl) alertService).alertDAO = alertDAO; // Inject mocked DAO
    }

    /**
     * Tests the createAlert method of the AlertServiceImpl class.
     * This test verifies that an alert is created and a transaction is handled correctly.
     */
    @Test
    public void testCreateAlert() {
        Alert alert = new Alert();
        alert.setAlertID(1);
        alert.setUserID(2);
        alert.setItemID(3);

        // Define the behavior of the mock
        doNothing().when(alertDAO).insertAlert(alert);

        // Call the method to test
        alertService.createAlert(alert);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verify(alertDAO).insertAlert(alert);

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the getAlertByAlertID method of the AlertServiceImpl class.
     * This test verifies that an alert is retrieved by its ID.
     */
    @Test
    public void testGetAlertByAlertID() {
        Alert alert = new Alert();
        alert.setAlertID(1);

        // Define the behavior of the mock
        when(alertDAO.selectAlertByID(1)).thenReturn(alert);

        // Call the method to test
        Alert result = alertService.getAlertByAlertID(1);

        // Verify the result
        assertNotNull(result);
        assertEquals(alert.getAlertID(), result.getAlertID());
    }

    /**
     * Tests the updateAlert method of the AlertServiceImpl class.
     * This test verifies that an alert is updated and a transaction is handled correctly.
     */
    @Test
    public void testUpdateAlert() {
        Alert alert = new Alert();
        alert.setAlertID(1);
        alert.setUserID(2);
        alert.setItemID(3);

        // Define the behavior of the mock
        doNothing().when(alertDAO).updateAlert(alert);

        // Call the method to test
        alertService.updateAlert(alert);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verify(alertDAO).updateAlert(alert);

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    private void verifyStatic(Class<DbUtil> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
