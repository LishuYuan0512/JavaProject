/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import dao.PriceTypeDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

/**
 * Unit tests for the PriceTypeServiceImpl class.
 * This class tests the service methods for managing price types and transaction management using mocks.
 */
public class PriceTypeServiceImplTest {

    private PriceTypeService priceTypeService;

    @Mock
    private PriceTypeDAO priceTypeDAO;

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
     * Tests the showPriceType method of the PriceTypeServiceImpl class.
     * This test verifies that a price type description is retrieved correctly by its ID.
     */
    @Test
    public void testShowPriceType_Success() {
        int priceTypeId = 1;
        String expectedPriceType = "Retail";

        // Define the behavior of the mock
        when(priceTypeDAO.getPriceTypeBYID(priceTypeId)).thenReturn(expectedPriceType);

        // Call the method to test
        String actualPriceType = priceTypeService.showPriceType(priceTypeId);

        // Verify the result
        assertEquals(expectedPriceType, actualPriceType);

        // Verify that transaction methods are called
        verifyStatic(DbUtil.class);
        DbUtil.begin();

        verifyStatic(DbUtil.class);
        DbUtil.commit();
    }

    /**
     * Tests the showPriceType method of the PriceTypeServiceImpl class when an exception occurs.
     * This test verifies that the transaction is rolled back and an exception is thrown.
     */
    @Test(expected = RuntimeException.class)
    public void testShowPriceType_Exception() {
        int priceTypeId = 1;

        // Define the behavior of the mock to throw an exception
        when(priceTypeDAO.getPriceTypeBYID(priceTypeId)).thenThrow(new RuntimeException("Database error"));

        try {
            // Call the method to test
            priceTypeService.showPriceType(priceTypeId);
        } finally {
            // Verify that transaction methods are called
            verifyStatic(DbUtil.class);
            DbUtil.begin();

            verifyStatic(DbUtil.class);
            DbUtil.rollback();
        }
    }

    private void verifyStatic(Class<DbUtil> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
