/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import entity.Alert;
import java.util.List;
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
public class AlertDAOImplTest {
    
    public AlertDAOImplTest() {
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
     * Test of insertAlert method, of class AlertDAOImpl.
     */
    @Test
    public void testInsertAlert() {
        System.out.println("insertAlert");
        Alert alert = null;
        AlertDAOImpl instance = new AlertDAOImpl();
        int expResult = 0;
        int result = instance.insertAlert(alert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAlert method, of class AlertDAOImpl.
     */
    @Test
    public void testUpdateAlert() {
        System.out.println("updateAlert");
        Alert alert = null;
        AlertDAOImpl instance = new AlertDAOImpl();
        int expResult = 0;
        int result = instance.updateAlert(alert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAlert method, of class AlertDAOImpl.
     */
    @Test
    public void testDeleteAlert() {
        System.out.println("deleteAlert");
        Alert alert = null;
        AlertDAOImpl instance = new AlertDAOImpl();
        int expResult = 0;
        int result = instance.deleteAlert(alert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAlertByID method, of class AlertDAOImpl.
     */
    @Test
    public void testSelectAlertByID() {
        System.out.println("selectAlertByID");
        int alertID = 0;
        AlertDAOImpl instance = new AlertDAOImpl();
        Alert expResult = null;
        Alert result = instance.selectAlertByID(alertID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllAlerts method, of class AlertDAOImpl.
     */
    @Test
    public void testSelectAllAlerts() {
        System.out.println("selectAllAlerts");
        AlertDAOImpl instance = new AlertDAOImpl();
        List<Alert> expResult = null;
        List<Alert> result = instance.selectAllAlerts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
