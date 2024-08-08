/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import entity.Customer;
import entity.FoodItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Unit test for CheckoutController.
 * This class tests the functionality of the CheckoutController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class CheckoutControllerTest {

    private CheckoutController servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private FoodItemService foodItemService;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new CheckoutController();

        // Create mock objects for request, response, and session
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        // Mock FoodItemService
        foodItemService = mock(FoodItemServiceImpl.class);

        // Set up session to return a Customer object
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("customer")).thenReturn(new Customer() {
            @Override
            public int getUserID() {
                return 1; // Example customer user ID
            }
        });

        // Mock request parameters
        when(request.getParameter("itemID")).thenReturn("1");
        when(request.getParameter("enterQuantity")).thenReturn("2");
        when(request.getParameter("quantity")).thenReturn("10");
        when(request.getParameter("itemName")).thenReturn("ExampleItem");
        when(request.getParameter("priceTypeID")).thenReturn("1");
        when(request.getParameter("price")).thenReturn("9.99");
    }

    /**
     * Tests the doPost method of the CheckoutController.
     * This test verifies that the checkout operation handles valid quantities correctly.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostValidQuantity() throws ServletException, IOException {
        // Prepare the food item mock
        FoodItem foodItem = new FoodItem();
        foodItem.setItemID(1);
        foodItem.setQuantity(10);

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
        assertEquals(2, updatedFoodItem.getQuantity());

        // Verify alert script and redirect
        verify(response).setContentType("text/html;charset=UTF-8");
        assertTrue(stringWriter.toString().contains("alert('Checkout successful! Thank you for your purchase.')"));

        // Verify redirection
        verify(response).sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
    }

    /**
     * Tests the doPost method of the CheckoutController.
     * This test verifies that the checkout operation handles invalid quantities correctly.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostInvalidQuantity() throws ServletException, IOException {
        // Mock request parameters with invalid quantity
        when(request.getParameter("enterQuantity")).thenReturn("15");

        // Mock PrintWriter for capturing response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Prepare the food item mock
        FoodItem foodItem = new FoodItem();
        foodItem.setItemID(1);
        foodItem.setQuantity(10);

        when(foodItemService.getFoodItemById(1)).thenReturn(foodItem);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify alert script for invalid quantity
        verify(response).setContentType("text/html;charset=UTF-8");
        assertTrue(stringWriter.toString().contains("alert('Invalid quantity entered. Please enter a quantity that does not exceed the available quantity.')"));

        // Verify redirection to the checkout page
        verify(response).sendRedirect(request.getContextPath() + "/customer/safe/showCheckoutJSP?itemID=1");
    }
}
