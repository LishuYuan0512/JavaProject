/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import entity.Charity;
import entity.Customer;
import entity.Retailer;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import service.CharityService;
import service.CustomerService;
import service.RetailerService;

/**
 * Unit test for LoginController.
 * This class tests the functionality of the LoginController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class LoginControllerTest {

    private LoginController servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private CustomerService customerService;
    private RetailerService retailerService;
    private CharityService charityService;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new LoginController();

        // Create mock objects for request, response, and session
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        // Mock service classes
        customerService = mock(CustomerService.class);
        retailerService = mock(RetailerService.class);
        charityService = mock(CharityService.class);

        // Set the session in the request
        when(request.getSession()).thenReturn(session);

      
    }

    /**
     * Tests the doPost method of the LoginController for a successful customer login.
     * This test verifies that the user is redirected to the correct URL after login.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostCustomerLogin() throws ServletException, IOException {
        // Mock request parameters
        when(request.getParameter("email")).thenReturn("customer@example.com");
        when(request.getParameter("password")).thenReturn("password");

        // Mock a successful customer login
        Customer customer = new Customer();
        customer.setUserType("Customer");
        when(customerService.login("customer@example.com", "password")).thenReturn(customer);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify session attribute and redirection
        verify(session).setAttribute("customer", customer);
        verify(response).sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
    }

    /**
     * Tests the doPost method of the LoginController for a successful retailer login.
     * This test verifies that the user is redirected to the correct URL after login.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostRetailerLogin() throws ServletException, IOException {
        // Mock request parameters
        when(request.getParameter("email")).thenReturn("retailer@example.com");
        when(request.getParameter("password")).thenReturn("password");

        // Mock a successful retailer login
        Retailer retailer = new Retailer();
        retailer.setUserType("Retailer");
        when(retailerService.login("retailer@example.com", "password")).thenReturn(retailer);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify session attribute and redirection
        verify(session).setAttribute("retailer", retailer);
        verify(response).sendRedirect(request.getContextPath() + "/retailer/safe/showRetailerItemsController");
    }

    /**
     * Tests the doPost method of the LoginController for a successful charity login.
     * This test verifies that the user is redirected to the correct URL after login.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostCharityLogin() throws ServletException, IOException {
        // Mock request parameters
        when(request.getParameter("email")).thenReturn("charity@example.com");
        when(request.getParameter("password")).thenReturn("password");

        // Mock a successful charity login
        Charity charity = new Charity();
        charity.setUserType("Charity");
        when(charityService.login("charity@example.com", "password")).thenReturn(charity);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify session attribute and redirection
        verify(session).setAttribute("charity", charity);
        verify(response).sendRedirect(request.getContextPath() + "/charity/safe/showItemsController");
    }

    /**
     * Tests the doPost method of the LoginController for a failed login attempt.
     * This test verifies that the user is redirected to the login page with an error message.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostLoginFailed() throws ServletException, IOException {
        // Mock request parameters
        when(request.getParameter("email")).thenReturn("invalid@example.com");
        when(request.getParameter("password")).thenReturn("wrongpassword");

        // Mock failed login attempts
        when(customerService.login("invalid@example.com", "wrongpassword")).thenReturn(null);
        when(retailerService.login("invalid@example.com", "wrongpassword")).thenReturn(null);
        when(charityService.login("invalid@example.com", "wrongpassword")).thenReturn(null);

        // Mock RequestDispatcher for forwarding
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify forwarding to login page with error message
        verify(request).setAttribute("loginError", "Invalid email or password. Please try again.");
        verify(dispatcher).forward(request, response);
    }
}
