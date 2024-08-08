/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import entity.Purchase;
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
public class PurchaseDAOImplTest {
    
    public PurchaseDAOImplTest() {
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
     * Test of insertPurchaseRecord method, of class PurchaseDAOImpl.
     */
    @Test
    public void testInsertPurchaseRecord() {
        System.out.println("insertPurchaseRecord");
        Purchase purchase = null;
        PurchaseDAOImpl instance = new PurchaseDAOImpl();
        int expResult = 0;
        int result = instance.insertPurchaseRecord(purchase);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
