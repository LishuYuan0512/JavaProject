/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import entity.FoodItem;
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
public class FoodItemServiceImplTest {
    
    public FoodItemServiceImplTest() {
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
     * Test of getAllFoodItems method, of class FoodItemServiceImpl.
     */
    @Test
    public void testGetAllFoodItems() {
        System.out.println("getAllFoodItems");
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        List<FoodItem> expResult = null;
        List<FoodItem> result = instance.getAllFoodItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoodItemById method, of class FoodItemServiceImpl.
     */
    @Test
    public void testGetFoodItemById() {
        System.out.println("getFoodItemById");
        int id = 0;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        FoodItem expResult = null;
        FoodItem result = instance.getFoodItemById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of purchaseFoodItemQuantity method, of class FoodItemServiceImpl.
     */
    @Test
    public void testPurchaseFoodItemQuantity() {
        System.out.println("purchaseFoodItemQuantity");
        FoodItem foodItem = null;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.purchaseFoodItemQuantity(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFoodItemQuantity method, of class FoodItemServiceImpl.
     */
    @Test
    public void testAddFoodItemQuantity() {
        System.out.println("addFoodItemQuantity");
        FoodItem foodItem = null;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.addFoodItemQuantity(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFoodItemDate method, of class FoodItemServiceImpl.
     */
    @Test
    public void testUpdateFoodItemDate() {
        System.out.println("updateFoodItemDate");
        FoodItem foodItem = null;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.updateFoodItemDate(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertFoodItem method, of class FoodItemServiceImpl.
     */
    @Test
    public void testInsertFoodItem() {
        System.out.println("insertFoodItem");
        FoodItem foodItem = null;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.insertFoodItem(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSurplusItem method, of class FoodItemServiceImpl.
     */
    @Test
    public void testUpdateSurplusItem() {
        System.out.println("updateSurplusItem");
        FoodItem foodItem = null;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.updateSurplusItem(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoodItemIsPlus method, of class FoodItemServiceImpl.
     */
    @Test
    public void testGetFoodItemIsPlus() {
        System.out.println("getFoodItemIsPlus");
        int foodItemID = 0;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.getFoodItemIsPlus(foodItemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFoodItem method, of class FoodItemServiceImpl.
     */
    @Test
    public void testUpdateFoodItem() {
        System.out.println("updateFoodItem");
        FoodItem foodItem = null;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        int expResult = 0;
        int result = instance.updateFoodItem(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoodItemsByRetailerId method, of class FoodItemServiceImpl.
     */
    @Test
    public void testGetFoodItemsByRetailerId() {
        System.out.println("getFoodItemsByRetailerId");
        int retailerId = 0;
        FoodItemServiceImpl instance = new FoodItemServiceImpl();
        List<FoodItem> expResult = null;
        List<FoodItem> result = instance.getFoodItemsByRetailerId(retailerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
