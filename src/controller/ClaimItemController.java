package controller;

import entity.Charity;
import entity.Customer;
import entity.FoodItem;
import entity.Purchase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;
import service.PurchaseService;
import service.PurchaseServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;

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
