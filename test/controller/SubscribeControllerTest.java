/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;

import entity.Subscription;
import observer.CustomerAlertObserver;
import observer.SubscriptionObserve;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import service.SubscriptionService;

/**
 * Unit test for SubscribeController.
 * This class tests the functionality of the SubscribeController servlet
 * using mock objects to simulate HTTP requests and responses.
 */
public class SubscribeControllerTest {

    private SubscribeController servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private SubscriptionService subscriptionService;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the servlet and mocks necessary components.
     */
    @Before
    public void setUp() {
        // Initialize the servlet
        servlet = new SubscribeController();

        // Create mock objects for request and response
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        // Mock SubscriptionService
        subscriptionService = mock(SubscriptionService.class);

        // Inject the mocked SubscriptionService into the servlet
        servlet.subscriptionService = subscriptionService;
    }

    /**
     * Tests the doPost method of the SubscribeController for a new subscription.
     * This test verifies that a new subscription is created and the user is redirected.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostNewSubscription() throws ServletException, IOException {
        // Mock request parameters
        when(request.getParameter("userID")).thenReturn("1");
        when(request.getParameter("locationID")).thenReturn("101");
        when(request.getParameter("foodPrefer")).thenReturn("5");
        when(request.getParameter("communicationMethod")).thenReturn("Email");
        when(request.getParameter("email")).thenReturn("user@example.com");
        when(request.getParameter("phone")).thenReturn("1234567890");

        // Mock a new subscription
        when(subscriptionService.subscriptionExists(1)).thenReturn(false);
        when(subscriptionService.createSubscription(any(Subscription.class))).thenReturn(true);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Capture the Subscription object
        ArgumentCaptor<Subscription> captor = ArgumentCaptor.forClass(Subscription.class);
        verify(subscriptionService).createSubscription(captor.capture());

        // Validate the captured Subscription
        Subscription subscription = captor.getValue();
        assertEquals(1, subscription.getUserID().intValue());
        assertEquals(101, subscription.getLocationID().intValue());
        assertEquals(5, subscription.getFoodPrefer().intValue());
        assertEquals(1, subscription.getCommunicationMethod().intValue());
        assertEquals("user@example.com", subscription.getEmail());
        assertEquals("1234567890", subscription.getPhone());

        // Verify redirection
        verify(response).sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
    }

    /**
     * Tests the doPost method of the SubscribeController for an existing subscription.
     * This test verifies that an existing subscription is updated and the user is redirected.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostUpdateSubscription() throws ServletException, IOException {
        // Mock request parameters
        when(request.getParameter("userID")).thenReturn("1");
        when(request.getParameter("locationID")).thenReturn("101");
        when(request.getParameter("foodPrefer")).thenReturn("5");
        when(request.getParameter("communicationMethod")).thenReturn("Phone");
        when(request.getParameter("email")).thenReturn("user@example.com");
        when(request.getParameter("phone")).thenReturn("1234567890");

        // Mock an existing subscription
        when(subscriptionService.subscriptionExists(1)).thenReturn(true);
        when(subscriptionService.updateSubscription(any(Subscription.class))).thenReturn(true);

        // Execute the doPost method
        servlet.doPost(request, response);

        // Capture the Subscription object
        ArgumentCaptor<Subscription> captor = ArgumentCaptor.forClass(Subscription.class);
        verify(subscriptionService).updateSubscription(captor.capture());

        // Validate the captured Subscription
        Subscription subscription = captor.getValue();
        assertEquals(1, subscription.getUserID().intValue());
        assertEquals(101, subscription.getLocationID().intValue());
        assertEquals(5, subscription.getFoodPrefer().intValue());
        assertEquals(2, subscription.getCommunicationMethod().intValue());
        assertEquals("user@example.com", subscription.getEmail());
        assertEquals("1234567890", subscription.getPhone());

        // Verify redirection
        verify(response).sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
    }

    /**
     * Tests the doPost method of the SubscribeController when required parameters are missing.
     * This test verifies that no subscription is created or updated and no redirection occurs.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Test
    public void testDoPostMissingParameters() throws ServletException, IOException {
        // Mock request parameters with missing userID
        when(request.getParameter("locationID")).thenReturn("101");
        when(request.getParameter("foodPrefer")).thenReturn("5");
        when(request.getParameter("communicationMethod")).thenReturn("Email");
        when(request.getParameter("email")).thenReturn("user@example.com");
        when(request.getParameter("phone")).thenReturn("1234567890");

        // Execute the doPost method
        servlet.doPost(request, response);

        // Verify that no subscription is created or updated
        verify(subscriptionService, never()).createSubscription(any(Subscription.class));
        verify(subscriptionService, never()).updateSubscription(any(Subscription.class));

        // Verify that no redirection occurs
        verify(response, never()).sendRedirect(anyString());
    }
}
