/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit tests for the PriceTypeDAOImpl class.
 * This class tests the database operations for PriceType entities using mocks.
 */
public class PriceTypeDAOImplTest {

    private PriceTypeDAO priceTypeDAO;
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
        priceTypeDAO = new PriceTypeDAOImpl();
        ((PriceTypeDAOImpl) priceTypeDAO).queryRunner = queryRunner; // Inject mocked QueryRunner
    }

    /**
     * Tests the getPriceTypeBYID method of the PriceTypeDAOImpl class.
     * This test verifies that the price type description is retrieved based on priceTypeID.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testGetPriceTypeBYID() throws SQLException {
        when(queryRunner.query(any(Connection.class), anyString(), any(ScalarHandler.class), anyInt())).thenReturn("Retail");

        String priceType = priceTypeDAO.getPriceTypeBYID(1);
        assertNotNull(priceType);
        assertEquals("Retail", priceType);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select priceType from PriceType2 where priceTypeID = ?;"), any(ScalarHandler.class), eq(1));
    }
}
