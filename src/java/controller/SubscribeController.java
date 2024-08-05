/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SubscriptionService;
import service.SubscriptionServiceImpl;

/**
 *
 * @author ZU
 */
/**
 * Servlet implementation class SubscribeController
 */
@WebServlet(name = "SubscribeController", value = "/customer/safe/SubscribeController")
public class SubscribeController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Retrieve parameters from the request
    String userIDParam = request.getParameter("userID");
    Integer userID = null;
    if (userIDParam != null && !userIDParam.isEmpty()) {
        userID = Integer.parseInt(userIDParam);
    }

    String locationIDParam = request.getParameter("locationID");
    Integer locationID = null;
    if (locationIDParam != null && !locationIDParam.isEmpty()) {
        locationID = Integer.parseInt(locationIDParam);
    }

    String foodPreferStr = request.getParameter("foodPrefer");
    int foodPrefer = Integer.parseInt(foodPreferStr);

    String communicationMethodParam = request.getParameter("communicationMethod");
    Integer communicationMethod = null;
    if (communicationMethodParam != null) {
        if (communicationMethodParam.equals("Email")) {
            communicationMethod = 1;
        } else if (communicationMethodParam.equals("Phone")) {
            communicationMethod = 2;
        }
    }

    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    // Check if required parameters are present
    if (userID == null) {
        // Handle missing required parameters (e.g., show an error message)
        System.out.println("userID");
        return;
    }
    
        if (locationID == null) {
        // Handle missing required parameters (e.g., show an error message)
        System.out.println("locationID");
        return;
    }
        
            if (communicationMethod == null) {
        // Handle missing required parameters (e.g., show an error message)
        System.out.println("communicationMethod");
        return;
    }

    // Create Subscription object and set its properties
    Subscription subscription = new Subscription();
    subscription.setUserID(userID);
    subscription.setLocationID(locationID);
    subscription.setFoodPrefer(foodPrefer);
    subscription.setCommunicationMethod(communicationMethod); 
    subscription.setEmail(email);
    subscription.setPhone(phone);

    // Create and call the SubscriptionService to handle database operations
    SubscriptionService subscriptionService = new SubscriptionServiceImpl();
    boolean isSuccess;

    // Check if a subscription with this userID already exists
        boolean exists = subscriptionService.subscriptionExists(userID);

        if (exists) {
            // Update existing subscription
            isSuccess = subscriptionService.updateSubscription(subscription);
        } else {
            // Create new subscription
            isSuccess = subscriptionService.createSubscription(subscription);
        }

        if (isSuccess) {
            // Redirect to confirmation page if successful
            response.sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
        } else {
            // Handle failure case (e.g., show an error message)
            response.getWriter().println("Error processing request.");
        }
}
}
