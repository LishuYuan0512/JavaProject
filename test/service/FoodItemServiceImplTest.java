/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.FoodItemDAO;
import entity.FoodItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit tests for the FoodItemServiceImpl class.
 * This class tests the service methods for managing food items and transaction management using mocks.
 */
public class FoodItemServiceImplTest {

    private FoodItemService foodItemService;

    @Mock
    private FoodItemDAO foodItemDAO;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the service and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the DbUtil static methods
        mockStatic(DbUtil.class);


    }

    /**
     * Tests the getAllFoodItems method of the FoodItemServiceImpl class.
     * This test verifies that all food items are retrieved correctly.
     */
    @Test
    public void testGetAllFoodItems() {
        List<FoodItem> expectedFoodItems = new ArrayList<>();
        expectedFoodItems.add(new FoodItem(1, 101, "Apple", 10, new Date(), new Date(), 1.0, 1, 0));
        expectedFoodItems.add(new FoodItem(2, 102, "Banana", 20, new Date(), new Date(), 0.5, 1, 0));

        // Define the behavior of the mock
        when(foodItemDAO.selectAllFoodItems()).thenReturn(expectedFoodItems);

        // Call the method to test
        List<FoodItem> actualFoodItems = foodItemService.getAllFoodItems();

        // Verify the result
        assertEquals(expectedFoodItems, actualFoodItems);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the getFoodItemById method of the FoodItemServiceImpl class.
     * This test verifies that a food item is retrieved correctly by its ID.
     */
    @Test
    public void testGetFoodItemById() {
        int itemId = 1;
        FoodItem expectedFoodItem = new FoodItem(itemId, 101, "Apple", 10, new Date(), new Date(), 1.0, 1, 0);

        // Define the behavior of the mock
        when(foodItemDAO.selectFoodItemById(itemId)).thenReturn(expectedFoodItem);

        // Call the method to test
        FoodItem actualFoodItem = foodItemService.getFoodItemById(itemId);

        // Verify the result
        assertEquals(expectedFoodItem, actualFoodItem);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the purchaseFoodItemQuantity method of the FoodItemServiceImpl class.
     * This test verifies that a food item quantity is reduced correctly.
     */
    @Test
    public void testPurchaseFoodItemQuantity() {
        FoodItem foodItem = new FoodItem(1, 101, "Apple", 10, new Date(), new Date(), 1.0, 1, 0);

        // Define the behavior of the mock
        when(foodItemDAO.consumeFoodItemQuantity(foodItem)).thenReturn(5);

        // Call the method to test
        int remainingQuantity = foodItemService.purchaseFoodItemQuantity(foodItem);

        // Verify the result
        assertEquals(5, remainingQuantity);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the addFoodItemQuantity method of the FoodItemServiceImpl class.
     * This test verifies that a food item quantity is increased correctly.
     */
    @Test
    public void testAddFoodItemQuantity() {
        FoodItem foodItem = new FoodItem(1, 101, "Apple", 10, new Date(), new Date(), 1.0, 1, 0);

        // Define the behavior of the mock
        when(foodItemDAO.addFoodItemQuantity(foodItem)).thenReturn(15);

        // Call the method to test
        int newQuantity = foodItemService.addFoodItemQuantity(foodItem);

        // Verify the result
        assertEquals(15, newQuantity);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the insertFoodItem method of the FoodItemServiceImpl class.
     * This test verifies that a new food item is inserted correctly.
     */
    @Test
    public void testInsertFoodItem() {
        FoodItem foodItem = new FoodItem(1, 101, "Orange", 10, new Date(), new Date(), 1.2, 1, 0);

        // Define the behavior of the mock
        when(foodItemDAO.insertFoodItem(foodItem)).thenReturn(1);

        // Call the method to test
        int insertResult = foodItemService.insertFoodItem(foodItem);

        // Verify the result
        assertEquals(1, insertResult);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the getFoodItemsByRetailerId method of the FoodItemServiceImpl class.
     * This test verifies that food items are retrieved correctly by retailer ID.
     */
    @Test
    public void testGetFoodItemsByRetailerId() {
        int retailerId = 101;
        List<FoodItem> expectedFoodItems = new ArrayList<>();
        expectedFoodItems.add(new FoodItem(1, retailerId, "Apple", 10, new Date(), new Date(), 1.0, 1, 0));
        expectedFoodItems.add(new FoodItem(2, retailerId, "Banana", 20, new Date(), new Date(), 0.5, 1, 0));

        // Define the behavior of the mock
        when(foodItemDAO.selectFoodItemsByRetailerId(retailerId)).thenReturn(expectedFoodItems);

        // Call the method to test
        List<FoodItem> actualFoodItems = foodItemService.getFoodItemsByRetailerId(retailerId);

        // Verify the result
        assertEquals(expectedFoodItems, actualFoodItems);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    private void verifyStatic(Class<DbUtil> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
