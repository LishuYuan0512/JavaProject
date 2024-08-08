/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

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
public class PriceTypeDAOImplTest {
    
    public PriceTypeDAOImplTest() {
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
     * Test of getPriceTypeBYID method, of class PriceTypeDAOImpl.
     */
    @Test
    public void testGetPriceTypeBYID() {
        System.out.println("getPriceTypeBYID");
        int priceTypeID = 0;
        PriceTypeDAOImpl instance = new PriceTypeDAOImpl();
        String expResult = "";
        String result = instance.getPriceTypeBYID(priceTypeID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
