/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class EditRetailerItemsController
 * Handles requests for editing food items in a retailer's inventory.
 */

@WebServlet(name = "EditRetailerItemsController", value = "/retailer/safe/editRetailerItemsController")
public class EditRetailerItemsController extends HttpServlet {
    
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
     * Processes POST requests to update the quantity and expiration date of a food item.
     * Also updates the surplus status based on the expiration date.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        Integer itemId = (Integer.parseInt(request.getParameter("itemID")));
        int enterQuantity = Integer.parseInt(request.getParameter("enterQuantity"));
      
        String date = request.getParameter("expirationData");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate = null;
        try {
            expirationDate = sdf.parse(date);
          
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        FoodItemService foodItemService = new FoodItemServiceImpl();
        FoodItem foodItem = foodItemService.getFoodItemById(itemId);
        foodItem.setQuantity(enterQuantity);
        foodItem.setExpirationDate(expirationDate);
        if (foodItem.isDateWithin7Days(foodItem.getExpirationDate())){
            foodItem.setIsPlus(1);
        }else {
            foodItem.setIsPlus(2);
        }
        foodItemService.addFoodItemQuantity(foodItem);
        foodItemService.updateFoodItemDate(foodItem);
        foodItemService.updateSurplusItem(foodItem);
        response.sendRedirect(request.getContextPath()+"/retailer/safe/showRetailerItemsController");

    }
}