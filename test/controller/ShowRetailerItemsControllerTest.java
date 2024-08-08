/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import entity.FoodItem;
import entity.Retailer;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import service.FoodItemService;

/**
 * Unit test for ShowRetailerItemsController servlet.
 * This class tests the functionality of the ShowRetailerItemsController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class ShowRetailerItemsControllerTest {

    private ShowRetailerItemsController servlet;
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
        servlet = new ShowRetailerItemsController();

        // Create mock objects for request, response, session, and dispatcher
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);

        // Mock the session and request dispatcher
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/retailer/safe/showRetailerItemsJSP")).thenReturn(dispatcher);

        // Mock the FoodItemService
        foodItemService = mock(FoodItemService.class);

 
    }

    /**
     * Tests the doPost method of the ShowRetailerItemsController servlet.
     * This test verifies that the list of food items for a retailer is retrieved and forwarded to the JSP.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostWithRetailer() throws ServletException, IOException {
        // Mock session attribute for retailer
        Retailer retailer = new Retailer();
        retailer.setUserID(1);
        when(session.getAttribute("retailer")).thenReturn(retailer);

        // Mock the list of food items
        List<FoodItem> mockFoodItems = new ArrayList<>();

        when(foodItemService.getFoodItemsByRetailerId(1)).thenReturn(mockFoodItems);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the list of food items is set as a request attribute
        verify(request).setAttribute("foodItems", mockFoodItems);

        // Verify forwarding to the JSP
        verify(dispatcher).forward(request, response);
    }

    /**
     * Tests the doPost method of the ShowRetailerItemsController servlet when no retailer is logged in.
     * This test verifies that the user is redirected to the login page.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostWithoutRetailer() throws ServletException, IOException {
        // Mock no retailer logged in
        when(session.getAttribute("retailer")).thenReturn(null);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify redirection to login page
        verify(response).sendRedirect(request.getContextPath() + "/login.jsp");

        // Verify that no forwarding occurs
        verify(dispatcher, never()).forward(request, response);
    }
}
