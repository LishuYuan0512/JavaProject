package controller;

import controller.AddRetailerItemController;
import static org.mockito.Mockito.*;

import entity.FoodItem;
import entity.Retailer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;

import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Unit test for AddRetailerItemController.
 * This class tests the functionality of the AddRetailerItemController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class AddRetailerItemControllerTest {

    private AddRetailerItemController servlet;
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
        servlet = new AddRetailerItemController();

        // Create mock objects for request, response, and session
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        // Mock FoodItemService
        foodItemService = mock(FoodItemServiceImpl.class);

        // Set up session to return a Retailer object
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("retailer")).thenReturn(new Retailer() {
            @Override
            public int getUserID() {
                return 1; // Example retailer user ID
            }
        });

        // Mock request parameters
        when(request.getParameter("itemName")).thenReturn("ExampleItem");
        when(request.getParameter("price")).thenReturn("9.99");
        when(request.getParameter("quantity")).thenReturn("100");
        when(request.getParameter("restockTime")).thenReturn("2024-08-10");
        when(request.getParameter("expirationData")).thenReturn("2024-12-31");
        when(request.getParameter("priceType")).thenReturn("1");
        when(request.getParameter("isSurplus")).thenReturn("0");
    }

    /**
     * Tests the doPost method of the AddRetailerItemController.
     * This test verifies that a food item is correctly added to the retailer's inventory.
     * 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPost() throws ServletException, IOException, ParseException {
     
      
        // Execute the doPost method
        servlet.doPost(request, response);

        // Capture the FoodItem object passed to the service
        ArgumentCaptor<FoodItem> captor = ArgumentCaptor.forClass(FoodItem.class);
        verify(foodItemService).insertFoodItem(captor.capture());

        // Validate the captured FoodItem
        FoodItem capturedFoodItem = captor.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        assertEquals("ExampleItem", capturedFoodItem.getItemName());
        assertEquals(9.99, capturedFoodItem.getPrice(), 0.01);
        assertEquals(100, capturedFoodItem.getQuantity());
        assertEquals(sdf.parse("2024-08-10"), capturedFoodItem.getRestockTime());
        assertEquals(sdf.parse("2024-12-31"), capturedFoodItem.getExpirationDate());
        assertEquals(1, capturedFoodItem.getUserID());
        assertEquals(1, capturedFoodItem.getPriceTypeID());
        assertEquals(0, capturedFoodItem.getIsPlus());

        // Verify that the response was redirected
        verify(response).sendRedirect(request.getContextPath() + "/retailer/safe/showRetailerItemsController");
    }
}
