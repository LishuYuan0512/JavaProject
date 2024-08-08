/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Servlet implementation class ShowCharityItemsController
 * Handles requests to display all available food items for a charity.
 * It retrieves the list of food items from the database and forwards them to the view for display.
 */

@WebServlet(name = "ShowCharityItemsController", value = "/charity/safe/showItemsController")
public class ShowCharityItemsController extends HttpServlet {
    
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
     * Processes POST requests to retrieve and display all food items available to a charity.
     * Sets the retrieved food items as a request attribute and forwards to the JSP for display.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodItemService fs = new FoodItemServiceImpl();
        
        // Retrieve all food items from the service
        List<FoodItem> foodItems = fs.getAllFoodItems();
        request.setAttribute("foodItems", foodItems);
         // Forward to the JSP page for display
        RequestDispatcher rd = request.getRequestDispatcher("/charity/safe/showItemsJSP");
        rd.forward(request,response);
    }
}