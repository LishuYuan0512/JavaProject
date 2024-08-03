package controller;

import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;

@WebServlet(name = "SurplusItemController", value = "/retailer/safe/surplusItemController")
public class SurplusItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer priceType = Integer.parseInt(request.getParameter("priceType"));
        double discount = Double.parseDouble(request.getParameter("discount"));

        FoodItemService foodItemService = new FoodItemServiceImpl();
        FoodItem foodItem = foodItemService.getFoodItemById(itemID);
        foodItem.setPriceTypeID(priceType);
        foodItem.setDiscount(discount);
        foodItemService.updateFoodItem(foodItem);

        response.sendRedirect(request.getContextPath()+"/retailer/safe/showRetailerItemsController");
    }
}
