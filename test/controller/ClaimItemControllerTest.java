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
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Unit test for ClaimItemController.
 * This class tests the functionality of the ClaimItemController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class ClaimItemControllerTest {

    private ClaimItemController servlet;
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
        servlet = new ClaimItemController();

        // Create mock objects for request and response
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        // Mock FoodItemService
        foodItemService = mock(FoodItemServiceImpl.class);

        // Mock request parameters
        when(request.getParameter("itemID")).thenReturn("1");
        when(request.getParameter("quantity")).thenReturn("5");
    }

    /**
     * Tests the doPost method of the ClaimItemController.
     * This test verifies that claiming an item updates the inventory correctly
     * and that the user is notified of a successful claim.
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
        foodItem.setItemName("ExampleItem");

        when(foodItemService.getFoodItemById(1)).thenReturn(foodItem);

        // Mock PrintWriter for capturing response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

      

        // Execute the doPost method
        servlet.doPost(request, response);

        // Capture the updated FoodItem object
        ArgumentCaptor<FoodItem> captor = ArgumentCaptor.forClass(FoodItem.class);
        verify(foodItemService).purchaseFoodItemQuantity(captor.capture());

        // Validate the updated FoodItem
        FoodItem updatedFoodItem = captor.getValue();
        assertEquals(5, updatedFoodItem.getQuantity());

        // Verify alert script and redirection
        verify(response).setContentType("text/html;charset=UTF-8");
        assertTrue(stringWriter.toString().contains("alert('Claim successful! You have claimed 5 ExampleItem(s).')"));

        // Verify redirection
        verify(response).sendRedirect(request.getContextPath() + "/charity/safe/showItemsController");
    }
}
