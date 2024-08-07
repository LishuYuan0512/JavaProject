/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Unit test for the Purchase class.
 * This test verifies the getter and setter methods in the Purchase class.
 */
public class PurchaseTest {
    private Purchase purchase;
    private LocalDateTime purchaseTime;

    /**
     * Sets up the test environment by initializing a Purchase instance with test data.
     * This method is called before each test is executed.
     */
    @Before
    public void setUp() {
        purchaseTime = LocalDateTime.now();
        purchase = new Purchase(1, purchaseTime, 10, 20, 5, 199.99, 2);
    }

    /**
     * Tests the getPurchaseId method.
     * This test verifies that the purchase ID is retrieved correctly.
     */
    @Test
    public void testGetPurchaseId() {
        assertEquals(1, purchase.getPurchaseId());
    }

    /**
     * Tests the setPurchaseId method.
     * This test verifies that the purchase ID is set and retrieved correctly.
     */
    @Test
    public void testSetPurchaseId() {
        purchase.setPurchaseId(2);
        assertEquals(2, purchase.getPurchaseId());
    }

    /**
     * Tests the getPurchaseTime method.
     * This test verifies that the purchase time is retrieved correctly.
     */
    @Test
    public void testGetPurchaseTime() {
        assertEquals(purchaseTime, purchase.getPurchaseTime());
    }

    /**
     * Tests the setPurchaseTime method.
     * This test verifies that the purchase time is set and retrieved correctly.
     */
    @Test
    public void testSetPurchaseTime() {
        LocalDateTime newTime = LocalDateTime.now();
        purchase.setPurchaseTime(newTime);
        assertEquals(newTime, purchase.getPurchaseTime());
    }

    /**
     * Tests the getUserID method.
     * This test verifies that the user ID is retrieved correctly.
     */
    @Test
    public void testGetUserID() {
        assertEquals(10, purchase.getUserID());
    }

    /**
     * Tests the setUserID method.
     * This test verifies that the user ID is set and retrieved correctly.
     */
    @Test
    public void testSetUserID() {
        purchase.setUserID(11);
        assertEquals(11, purchase.getUserID());
    }

    /**
     * Tests the getItemID method.
     * This test verifies that the item ID is retrieved correctly.
     */
    @Test
    public void testGetItemID() {
        assertEquals(20, purchase.getItemID());
    }

    /**
     * Tests the setItemID method.
     * This test verifies that the item ID is set and retrieved correctly.
     */
    @Test
    public void testSetItemID() {
        purchase.setItemID(21);
        assertEquals(21, purchase.getItemID());
    }

    /**
     * Tests the getQuantity method.
     * This test verifies that the quantity is retrieved correctly.
     */
    @Test
    public void testGetQuantity() {
        assertEquals(5, purchase.getQuantity());
    }

    /**
     * Tests the setQuantity method.
     * This test verifies that the quantity is set and retrieved correctly.
     */
    @Test
    public void testSetQuantity() {
        purchase.setQuantity(6);
        assertEquals(6, purchase.getQuantity());
    }

    /**
     * Tests the getPrice method.
     * This test verifies that the price is retrieved correctly.
     */
    @Test
    public void testGetPrice() {
        assertEquals(199.99, purchase.getPrice(), 0.001);
    }

    /**
     * Tests the setPrice method.
     * This test verifies that the price is set and retrieved correctly.
     */
    @Test
    public void testSetPrice() {
        purchase.setPrice(299.99);
        assertEquals(299.99, purchase.getPrice(), 0.001);
    }

    /**
     * Tests the getPriceTypeID method.
     * This test verifies that the price type ID is retrieved correctly.
     */
    @Test
    public void testGetPriceTypeID() {
        assertEquals(2, purchase.getPriceTypeID());
    }

    /**
     * Tests the setPriceTypeID method.
     * This test verifies that the price type ID is set and retrieved correctly.
     */
    @Test
    public void testSetPriceTypeID() {
        purchase.setPriceTypeID(3);
        assertEquals(3, purchase.getPriceTypeID());
    }
}
