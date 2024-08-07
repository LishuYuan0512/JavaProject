/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the PriceType class.
 * This test verifies the getter and setter methods in the PriceType class.
 */
public class PriceTypeTest {
    private PriceType priceType;

    /**
     * Sets up the test environment by initializing a PriceType instance with test data.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        priceType = new PriceType(1, "Retail");
    }

    /**
     * Tests the getPriceTypeID method.
     * This test verifies that the priceTypeID is retrieved correctly.
     */
    @Test
    public void testGetPriceTypeID() {
        assertEquals(1, priceType.getPriceTypeID());
    }

    /**
     * Tests the setPriceTypeID method.
     * This test verifies that the priceTypeID is set and retrieved correctly.
     */
    @Test
    public void testSetPriceTypeID() {
        priceType.setPriceTypeID(2);
        assertEquals(2, priceType.getPriceTypeID());
    }

    /**
     * Tests the getPriceType method.
     * This test verifies that the priceType is retrieved correctly.
     */
    @Test
    public void testGetPriceType() {
        assertEquals("Retail", priceType.getPriceType());
    }

    /**
     * Tests the setPriceType method.
     * This test verifies that the priceType is set and retrieved correctly.
     */
    @Test
    public void testSetPriceType() {
        priceType.setPriceType("Wholesale");
        assertEquals("Wholesale", priceType.getPriceType());
    }
}
