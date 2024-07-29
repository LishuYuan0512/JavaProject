package controller;

import dao.FoodItemDAO;
import dao.FoodItemDAOImpl;
import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;

@WebServlet(name = "CheckoutController", value = "/customer/safe/checkoutController")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String itemName = request.getParameter("itemName");


        FoodItem foodItem = new FoodItem();
        foodItem.setItemID(itemID);
        foodItem.setQuantity(quantity);
        foodItem.setItemName(itemName);
        System.out.println("CheckoutController里的foodItem:========"+foodItem);
        FoodItemService foodItemService = new FoodItemServiceImpl();
        foodItemService.modifyFoodItemQuantity(foodItem);
        System.out.println("经过修改之后的foodItem:========"+foodItem);
        response.sendRedirect(request.getContextPath()+"/customer/safe/showItemsController");
    }
}
