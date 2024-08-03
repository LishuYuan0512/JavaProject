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

@WebServlet(name = "ClaimItemController", value = "/charity/safe/claimItemsController")
public class ClaimItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer enterQuantity = Integer.parseInt(request.getParameter("quantity"));


        FoodItemService foodItemService = new FoodItemServiceImpl();

        FoodItem foodItem = foodItemService.getFoodItemById(itemID);
        foodItem.setQuantity(enterQuantity);
        foodItemService.purchaseFoodItemQuantity(foodItem);


        response.sendRedirect(request.getContextPath()+"/charity/safe/showItemsController");
    }
}