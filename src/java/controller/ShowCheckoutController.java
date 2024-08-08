/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Servlet implementation class ShowCheckoutController
 * Handles requests to display the checkout page for a selected food item.
 * It retrieves the food item details and forwards them to the checkout JSP for display.
 */
@WebServlet(name = "ShowCheckoutController", urlPatterns = {"/ShowCheckoutController"})
public class ShowCheckoutController extends HttpServlet {
    
        /**
     * Processes GET requests by delegating to the doPost method.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
       /**
     * Processes POST requests to retrieve food item details for checkout.
     * Sets the food item as a request attribute and forwards to the checkout JSP for display.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        // Retrieve the food item ID from the request
        Integer foodId = Integer.parseInt(request.getParameter("itemID"));
          // Get the food item details from the service
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(foodId);
             // Set the food item as a request attribute
        request.setAttribute("foodItem", foodItem);
        // Forward to the checkout JSP page for display
        request.getRequestDispatcher("/customer/safe/showCheckoutJSP").forward(request, response);


    }
}
