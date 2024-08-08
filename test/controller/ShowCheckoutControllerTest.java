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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import service.FoodItemService;

/**
 * Unit test for ShowCheckoutController servlet.
 * This class tests the functionality of the ShowCheckoutController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class ShowCheckoutControllerTest {

    private ShowCheckoutController servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;
    private FoodItemService foodItemService;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new ShowCheckoutController();

        // Create mock objects for request, response, session, and dispatcher
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);

        // Mock the session and request dispatcher
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/customer/safe/showCheckoutJSP")).thenReturn(dispatcher);

        // Mock the FoodItemService
        foodItemService = mock(FoodItemService.class);

   
    }

    /**
     * Tests the doPost method of the ShowCheckoutController servlet.
     * This test verifies that the food item details are retrieved and forwarded to the checkout JSP.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Mock session attribute for customer
        Customer customer = new Customer();
        when(session.getAttribute("customer")).thenReturn(customer);

        // Mock request parameters
        when(request.getParameter("itemID")).thenReturn("1");

        // Mock the food item retrieval
        FoodItem mockFoodItem = new FoodItem();
        when(foodItemService.getFoodItemById(1)).thenReturn(mockFoodItem);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the food item is set as a request attribute
        verify(request).setAttribute("foodItem", mockFoodItem);

        // Verify forwarding to the checkout JSP
        verify(dispatcher).forward(request, response);
    }

    /**
     * Tests the doPost method of the ShowCheckoutController servlet with an invalid itemID.
     * This test verifies that an exception is handled correctly when parsing the itemID.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test(expected = NumberFormatException.class)
    public void testDoPostInvalidItemId() throws ServletException, IOException {
        // Mock session attribute for customer
        Customer customer = new Customer();
        when(session.getAttribute("customer")).thenReturn(customer);

        // Mock invalid request parameters
        when(request.getParameter("itemID")).thenReturn("invalid");

        // Execute the doPost method
        servlet.doPost(request, response);
    }
}
