/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import entity.FoodItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit tests for the FoodItemDAOImpl class.
 * This class tests the database operations for FoodItem entities using mocks.
 */
public class FoodItemDAOImplTest {

    private FoodItemDAO foodItemDAO;
    private QueryRunner queryRunner;

    @Mock
    private Connection connection;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the DAO and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the QueryRunner
        queryRunner = mock(QueryRunner.class);

        // Mock the DbUtil.getConnection() method
        mockStatic(DbUtil.class);
        when(DbUtil.getConnection()).thenReturn(connection);

        // Initialize the DAO
        foodItemDAO = new FoodItemDAOImpl();
        ((FoodItemDAOImpl) foodItemDAO).queryRunner = queryRunner; // Inject mocked QueryRunner
    }

    /**
     * Tests the selectAllFoodItems method of the FoodItemDAOImpl class.
     * This test verifies that all food items are selected from the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectAllFoodItems() throws SQLException {
        List<FoodItem> expectedFoodItems = new ArrayList<>();
        expectedFoodItems.add(new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1));
        expectedFoodItems.add(new FoodItem(2, "Banana", 20, new Date(), new Date(), 0.5, 1, 0, 1));

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanListHandler.class))).thenReturn(expectedFoodItems);

        List<FoodItem> actualFoodItems = foodItemDAO.selectAllFoodItems();
        assertNotNull(actualFoodItems);
        assertEquals(expectedFoodItems.size(), actualFoodItems.size());

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from FoodItem2;"), any(BeanListHandler.class));
    }

    /**
     * Tests the selectFoodItemById method of the FoodItemDAOImpl class.
     * This test verifies that a food item is selected by its ID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectFoodItemById() throws SQLException {
        FoodItem expectedFoodItem = new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanHandler.class), anyInt())).thenReturn(expectedFoodItem);

        FoodItem actualFoodItem = foodItemDAO.selectFoodItemById(1);
        assertNotNull(actualFoodItem);
        assertEquals(expectedFoodItem, actualFoodItem);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from FoodItem2 where itemID =?;"), any(BeanHandler.class), eq(1));
    }

    /**
     * Tests the consumeFoodItemQuantity method of the FoodItemDAOImpl class.
     * This test verifies that the quantity of a food item is consumed.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testConsumeFoodItemQuantity() throws SQLException {
        FoodItem foodItem = new FoodItem(1, "Apple", 5, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.update(any(Connection.class), anyString(), anyInt(), anyInt())).thenReturn(1);

        int rowsAffected = foodItemDAO.consumeFoodItemQuantity(foodItem);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update FoodItem2 set quantity= quantity - ? where itemID =?;"),
                eq(foodItem.getQuantity()), eq(foodItem.getItemID()));
    }

    /**
     * Tests the addFoodItemQuantity method of the FoodItemDAOImpl class.
     * This test verifies that the quantity of a food item is added.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testAddFoodItemQuantity() throws SQLException {
        FoodItem foodItem = new FoodItem(1, "Apple", 5, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.update(any(Connection.class), anyString(), anyInt(), anyInt())).thenReturn(1);

        int rowsAffected = foodItemDAO.addFoodItemQuantity(foodItem);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update FoodItem2 set quantity= quantity + ? where itemID =?;"),
                eq(foodItem.getQuantity()), eq(foodItem.getItemID()));
    }

    /**
     * Tests the selectFoodItemByItemName method of the FoodItemDAOImpl class.
     * This test verifies that a food item is selected by its name.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectFoodItemByItemName() throws SQLException {
        FoodItem expectedFoodItem;
        expectedFoodItem = new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanHandler.class), anyString())).thenReturn(expectedFoodItem);

        FoodItem actualFoodItem = foodItemDAO.selectFoodItemByItemName("Apple");
        assertNotNull(actualFoodItem);
        assertEquals(expectedFoodItem, actualFoodItem);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from FoodItem2 where itemName =?;"), any(BeanHandler.class), eq("Apple"));
    }

    /**
     * Tests the updateFoodItemExpirationDates method of the FoodItemDAOImpl class.
     * This test verifies that the expiration dates of a food item are updated.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateFoodItemExpirationDates() throws SQLException {
        FoodItem foodItem = new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), anyInt())).thenReturn(1);

        int rowsAffected = foodItemDAO.updateFoodItemExpirationDates(foodItem);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update FoodItem2 set expirationDate = ? where itemID =?;"),
                eq(foodItem.getExpirationDate()), eq(foodItem.getItemID()));
    }

    /**
     * Tests the insertFoodItem method of the FoodItemDAOImpl class.
     * This test verifies that a new food item is inserted into the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertFoodItem() throws SQLException {
        FoodItem foodItem = new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int rowsAffected = foodItemDAO.insertFoodItem(foodItem);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection),
                eq("INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price,priceTypeID,isPlus) VALUES (?, ?, ?, ?, ?, ?,?,?);"),
                eq(foodItem.getUserID()), eq(foodItem.getItemName()), eq(foodItem.getQuantity()), eq(foodItem.getRestockTime()),
                eq(foodItem.getExpirationDate()), eq(foodItem.getPrice()), eq(foodItem.getPriceTypeID()), eq(foodItem.getIsPlus()));
    }

    /**
     * Tests the updateFoodItemSurplus method of the FoodItemDAOImpl class.
     * This test verifies that the surplus status of a food item is updated.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateFoodItemSurplus() throws SQLException {
        FoodItem foodItem = new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), anyInt())).thenReturn(1);

        int rowsAffected = foodItemDAO.updateFoodItemSurplus(foodItem);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update FoodItem2 set isPlus = ?, priceTypeID=? where itemID =?;"),
                eq(foodItem.getIsPlus()), eq(foodItem.getPriceTypeID()), eq(foodItem.getItemID()));
    }

    /**
     * Tests the getFoodItemIsPlusID method of the FoodItemDAOImpl class.
     * This test verifies that the surplus ID is retrieved based on item ID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testGetFoodItemIsPlusID() throws SQLException {
        when(queryRunner.query(any(Connection.class), anyString(), any(ScalarHandler.class), anyInt())).thenReturn(1);

        int isPlus = foodItemDAO.getFoodItemIsPlusID(1);
        assertEquals(1, isPlus);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select isPlus from fooditem2 where itemID = ?;"), any(ScalarHandler.class), eq(1));
    }

    /**
     * Tests the updatePriceTypeAndPrice method of the FoodItemDAOImpl class.
     * This test verifies that the price type and price of a food item are updated.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdatePriceTypeAndPrice() throws SQLException {
        FoodItem foodItem = new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1);
        foodItem.setDiscount(0.1); // 10% discount

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), anyInt())).thenReturn(1);

        int rowsAffected = foodItemDAO.updatePriceTypeAndPrice(foodItem);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("update FoodItem2 set priceTypeID = ?, price=price*(1-?) where itemID =?;"),
                eq(foodItem.getPriceTypeID()), eq(foodItem.getDiscount()), eq(foodItem.getItemID()));
    }

    /**
     * Tests the selectFoodItemsByRetailerId method of the FoodItemDAOImpl class.
     * This test verifies that food items are selected by retailer ID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectFoodItemsByRetailerId() throws SQLException {
        List<FoodItem> expectedFoodItems = new ArrayList<>();
        expectedFoodItems.add(new FoodItem(1, "Apple", 10, new Date(), new Date(), 1.0, 1, 0, 1));

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanListHandler.class), anyInt())).thenReturn(expectedFoodItems);

        List<FoodItem> actualFoodItems = foodItemDAO.selectFoodItemsByRetailerId(1);
        assertNotNull(actualFoodItems);
        assertEquals(expectedFoodItems.size(), actualFoodItems.size());

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("SELECT * FROM FoodItem2 WHERE userID = ?"), any(BeanListHandler.class), eq(1));
    }
}
