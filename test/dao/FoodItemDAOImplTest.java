/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

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
public class FoodItemDAOImplTest {
    
    public FoodItemDAOImplTest() {
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
     * Test of selectAllFoodItems method, of class FoodItemDAOImpl.
     */
    @Test
    public void testSelectAllFoodItems() {
        System.out.println("selectAllFoodItems");
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        List<FoodItem> expResult = null;
        List<FoodItem> result = instance.selectAllFoodItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectFoodItemById method, of class FoodItemDAOImpl.
     */
    @Test
    public void testSelectFoodItemById() {
        System.out.println("selectFoodItemById");
        int id = 0;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        FoodItem expResult = null;
        FoodItem result = instance.selectFoodItemById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consumeFoodItemQuantity method, of class FoodItemDAOImpl.
     */
    @Test
    public void testConsumeFoodItemQuantity() {
        System.out.println("consumeFoodItemQuantity");
        FoodItem foodItem = null;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.consumeFoodItemQuantity(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFoodItemQuantity method, of class FoodItemDAOImpl.
     */
    @Test
    public void testAddFoodItemQuantity() {
        System.out.println("addFoodItemQuantity");
        FoodItem foodItem = null;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.addFoodItemQuantity(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectFoodItemByItemName method, of class FoodItemDAOImpl.
     */
    @Test
    public void testSelectFoodItemByItemName() {
        System.out.println("selectFoodItemByItemName");
        String itemName = "";
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        FoodItem expResult = null;
        FoodItem result = instance.selectFoodItemByItemName(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFoodItemExpirationDates method, of class FoodItemDAOImpl.
     */
    @Test
    public void testUpdateFoodItemExpirationDates() {
        System.out.println("updateFoodItemExpirationDates");
        FoodItem foodItem = null;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.updateFoodItemExpirationDates(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertFoodItem method, of class FoodItemDAOImpl.
     */
    @Test
    public void testInsertFoodItem() {
        System.out.println("insertFoodItem");
        FoodItem foodItem = null;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.insertFoodItem(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFoodItemSurplus method, of class FoodItemDAOImpl.
     */
    @Test
    public void testUpdateFoodItemSurplus() {
        System.out.println("updateFoodItemSurplus");
        FoodItem foodItem = null;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.updateFoodItemSurplus(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoodItemIsPlusID method, of class FoodItemDAOImpl.
     */
    @Test
    public void testGetFoodItemIsPlusID() {
        System.out.println("getFoodItemIsPlusID");
        int itemID = 0;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.getFoodItemIsPlusID(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePriceTypeAndPrice method, of class FoodItemDAOImpl.
     */
    @Test
    public void testUpdatePriceTypeAndPrice() {
        System.out.println("updatePriceTypeAndPrice");
        FoodItem foodItem = null;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        int expResult = 0;
        int result = instance.updatePriceTypeAndPrice(foodItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectFoodItemsByRetailerId method, of class FoodItemDAOImpl.
     */
    @Test
    public void testSelectFoodItemsByRetailerId() {
        System.out.println("selectFoodItemsByRetailerId");
        int userID = 0;
        FoodItemDAOImpl instance = new FoodItemDAOImpl();
        List<FoodItem> expResult = null;
        List<FoodItem> result = instance.selectFoodItemsByRetailerId(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
