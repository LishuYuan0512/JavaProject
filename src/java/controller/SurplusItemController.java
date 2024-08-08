/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Servlet implementation class SurplusItemController
 * Handles requests to update surplus food items by setting a price type and discount.
 */

@WebServlet(name = "SurplusItemController", value = "/retailer/safe/surplusItemController")
public class SurplusItemController extends HttpServlet {
    
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
     * Processes POST requests to update the details of surplus food items.
     * Updates the price type and discount for the specified food item.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          // Parse request parameters
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer priceType = Integer.parseInt(request.getParameter("priceType"));
        double discount = Double.parseDouble(request.getParameter("discount"));

      // Retrieve the food item and update its price type and discount
        FoodItemService foodItemService = new FoodItemServiceImpl();
        FoodItem foodItem = foodItemService.getFoodItemById(itemID);
        foodItem.setPriceTypeID(priceType);
        foodItem.setDiscount(discount);
        
         // Persist the updated food item details
        foodItemService.updateFoodItem(foodItem);
        // Redirect to the retailer items display page
        response.sendRedirect(request.getContextPath()+"/retailer/safe/showRetailerItemsController");
    }
}