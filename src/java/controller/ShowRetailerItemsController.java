/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import entity.Retailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Servlet implementation class ShowRetailerItemsController
 * Handles requests to display food items associated with a retailer.
 * It retrieves the list of food items for the logged-in retailer and forwards them to the view for display.
 */

@WebServlet(name = "ShowRetailerItemsController", value = "/retailer/safe/showRetailerItemsController")
public class ShowRetailerItemsController extends HttpServlet {
    
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
     * Processes POST requests to retrieve and display food items associated with a retailer.
     * Ensures the retailer is logged in and retrieves items based on the retailer's user ID.
     * Sets the retrieved food items as a request attribute and forwards to the JSP for display.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Retailer retailer = (Retailer) session.getAttribute("retailer");
      // Redirect to login if no retailer is logged in
        if (retailer == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

         // Use the retailer's userID to get the food items associated with them
        int userID = retailer.getUserID();
        FoodItemService fs = new FoodItemServiceImpl();
        List<FoodItem> foodItems = fs.getFoodItemsByRetailerId(userID);
        // Set the list of food items as a request attribute
        request.setAttribute("foodItems", foodItems);
        // Forward to the JSP page for display
        RequestDispatcher rd = request.getRequestDispatcher("/retailer/safe/showRetailerItemsJSP");
        rd.forward(request,response);
    }
}