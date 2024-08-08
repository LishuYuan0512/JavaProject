/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import entity.Alert;
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
public class AlertServiceImplTest {
    
    public AlertServiceImplTest() {
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
     * Test of createAlert method, of class AlertServiceImpl.
     */
    @Test
    public void testCreateAlert() {
        System.out.println("createAlert");
        Alert alert = null;
        AlertServiceImpl instance = new AlertServiceImpl();
        Alert expResult = null;
        Alert result = instance.createAlert(alert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlertByAlertID method, of class AlertServiceImpl.
     */
    @Test
    public void testGetAlertByAlertID() {
        System.out.println("getAlertByAlertID");
        int alertID = 0;
        AlertServiceImpl instance = new AlertServiceImpl();
        Alert expResult = null;
        Alert result = instance.getAlertByAlertID(alertID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAlerts method, of class AlertServiceImpl.
     */
    @Test
    public void testGetAllAlerts() {
        System.out.println("getAllAlerts");
        Alert alert = null;
        AlertServiceImpl instance = new AlertServiceImpl();
        Alert expResult = null;
        Alert result = instance.getAllAlerts(alert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAlert method, of class AlertServiceImpl.
     */
    @Test
    public void testUpdateAlert() {
        System.out.println("updateAlert");
        Alert alert = null;
        AlertServiceImpl instance = new AlertServiceImpl();
        Alert expResult = null;
        Alert result = instance.updateAlert(alert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
