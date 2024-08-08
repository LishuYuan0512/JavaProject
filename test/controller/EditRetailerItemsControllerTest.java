/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import entity.FoodItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;

import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Unit test for EditRetailerItemsController.
 * This class tests the functionality of the EditRetailerItemsController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class EditRetailerItemsControllerTest {

    private EditRetailerItemsController servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FoodItemService foodItemService;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new EditRetailerItemsController();

        // Create mock objects for request and response
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        // Mock FoodItemService
        foodItemService = mock(FoodItemServiceImpl.class);

        // Mock request parameters
        when(request.getParameter("itemID")).thenReturn("1");
        when(request.getParameter("enterQuantity")).thenReturn("20");
        when(request.getParameter("expirationData")).thenReturn("2024-12-31");
    }

    /**
     * Tests the doPost method of the EditRetailerItemsController.
     * This test verifies that the food item is correctly updated in the inventory.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Prepare the food item mock
        FoodItem foodItem = new FoodItem();
        foodItem.setItemID(1);
        foodItem.setQuantity(10);
        foodItem.setExpirationDate(new Date());
        
        when(foodItemService.getFoodItemById(1)).thenReturn(foodItem);



        // Capture the updated FoodItem object
        ArgumentCaptor<FoodItem> captor = ArgumentCaptor.forClass(FoodItem.class);
        verify(foodItemService).addFoodItemQuantity(captor.capture());

        // Validate the updated FoodItem
        FoodItem updatedFoodItem = captor.getValue();
        assertEquals(20, updatedFoodItem.getQuantity());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("2024-12-31", sdf.format(updatedFoodItem.getExpirationDate()));

        // Verify surplus status update
        if (foodItem.isDateWithin7Days(updatedFoodItem.getExpirationDate())) {
            assertEquals(1, updatedFoodItem.getIsPlus());
        } else {
            assertEquals(2, updatedFoodItem.getIsPlus());
        }

        // Verify that the correct methods were called
        verify(foodItemService).updateFoodItemDate(updatedFoodItem);
        verify(foodItemService).updateSurplusItem(updatedFoodItem);

        // Verify redirection
        verify(response).sendRedirect(request.getContextPath() + "/retailer/safe/showRetailerItemsController");
    }
}
