/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import entity.Purchase;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Unit tests for the PurchaseDAOImpl class.
 * This class tests the database operations for Purchase entities using mocks.
 */
public class PurchaseDAOImplTest {

    private PurchaseDAO purchaseDAO;
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
        purchaseDAO = new PurchaseDAOImpl();
        ((PurchaseDAOImpl) purchaseDAO).queryRunner = queryRunner; // Inject mocked QueryRunner
    }

    /**
     * Tests the insertPurchaseRecord method of the PurchaseDAOImpl class.
     * This test verifies that a new purchase record is inserted into the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertPurchaseRecord() throws SQLException {
        Purchase purchase = new Purchase(new Date(), 1, 1, 5, 10.0, 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int rowsAffected = purchaseDAO.insertPurchaseRecord(purchase);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection),
                eq("insert into Purchase(purchaseTime,userID,itemID,quantity,price,priceTypeID) values (?,?,?,?,?,?);"),
                eq(purchase.getPurchaseTime()), eq(purchase.getUserID()), eq(purchase.getItemID()), eq(purchase.getQuantity()),
                eq(purchase.getPrice()), eq(purchase.getPriceTypeID()));
    }
}
