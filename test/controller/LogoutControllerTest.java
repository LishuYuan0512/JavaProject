/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Unit test for LogoutController.
 * This class tests the functionality of the LogoutController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class LogoutControllerTest {

    private LogoutController servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new LogoutController();

        // Create mock objects for request, response, and session
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        // Set the session in the request
        when(request.getSession()).thenReturn(session);
    }

    /**
     * Tests the doPost method of the LogoutController when a customer is logged in.
     * This test verifies that the session is invalidated and the user is redirected to the login page.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostCustomerLogout() throws ServletException, IOException {
        // Mock session attribute for customer
        when(session.getAttribute("customer")).thenReturn(new Object());

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the session is invalidated and the user is redirected
        verify(session).invalidate();
        verify(response).sendRedirect(request.getContextPath() + "/login.jsp");
    }

    /**
     * Tests the doPost method of the LogoutController when a retailer is logged in.
     * This test verifies that the session is invalidated and the user is redirected to the login page.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostRetailerLogout() throws ServletException, IOException {
        // Mock session attribute for retailer
        when(session.getAttribute("retailer")).thenReturn(new Object());

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the session is invalidated and the user is redirected
        verify(session).invalidate();
        verify(response).sendRedirect(request.getContextPath() + "/login.jsp");
    }

    /**
     * Tests the doPost method of the LogoutController when a charity is logged in.
     * This test verifies that the session is invalidated and the user is redirected to the login page.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostCharityLogout() throws ServletException, IOException {
        // Mock session attribute for charity
        when(session.getAttribute("charity")).thenReturn(new Object());

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the session is invalidated and the user is redirected
        verify(session).invalidate();
        verify(response).sendRedirect(request.getContextPath() + "/login.jsp");
    }

    /**
     * Tests the doPost method of the LogoutController when no user is logged in.
     * This test verifies that the user is redirected to the login page without invalidating the session.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostNoUserLogout() throws ServletException, IOException {
        // Mock no session attributes
        when(session.getAttribute("customer")).thenReturn(null);
        when(session.getAttribute("retailer")).thenReturn(null);
        when(session.getAttribute("charity")).thenReturn(null);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that the session is not invalidated but the user is redirected
        verify(session, never()).invalidate();
        verify(response).sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
