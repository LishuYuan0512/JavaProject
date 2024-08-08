/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import entity.FoodItem;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import service.FoodItemService;

/**
 * Unit test for ShowCustomerItems servlet.
 * This class tests the functionality of the ShowCustomerItems servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class ShowCustomerItemsTest {

    private ShowCustomerItems servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private FoodItemService foodItemService;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new ShowCustomerItems();

        // Create mock objects for request, response, and dispatcher
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);

        // Mock the request dispatcher for forwarding
        when(request.getRequestDispatcher("/customer/safe/showItemsJSP")).thenReturn(dispatcher);

        // Mock the FoodItemService
        foodItemService = mock(FoodItemService.class);

       
    }

    /**
     * Tests the doPost method of the ShowCustomerItems servlet.
     * This test verifies that the list of food items is retrieved and forwarded to the JSP.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Mock the list of food items
        List<FoodItem> mockFoodItems = new ArrayList<>();
   

        when(foodItemService.getAllFoodItems()).thenReturn(mockFoodItems);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the list of food items is set as a request attribute
        verify(request).setAttribute("foodItems", mockFoodItems);

        // Verify forwarding to the JSP
        verify(dispatcher).forward(request, response);
    }

    /**
     * Tests the doPost method of the ShowCustomerItems servlet when no food items are available.
     * This test verifies that an empty list is handled correctly and forwarded to the JSP.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostNoFoodItems() throws ServletException, IOException {
        // Mock an empty list of food items
        List<FoodItem> mockFoodItems = new ArrayList<>();

        when(foodItemService.getAllFoodItems()).thenReturn(mockFoodItems);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that an empty list of food items is set as a request attribute
        verify(request).setAttribute("foodItems", mockFoodItems);

        // Verify forwarding to the JSP
        verify(dispatcher).forward(request, response);
    }
}
