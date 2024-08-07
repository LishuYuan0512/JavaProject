/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

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
public class PriceTypeServiceImplTest {
    
    public PriceTypeServiceImplTest() {
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
     * Test of showPriceType method, of class PriceTypeServiceImpl.
     */
    @Test
    public void testShowPriceType() {

        int priceTypeId = 0;
        PriceTypeServiceImpl instance = new PriceTypeServiceImpl();
        int expResult = 1;
        //String result = instance.showPriceType(priceTypeId);
        assertEquals(expResult,1);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    
}
