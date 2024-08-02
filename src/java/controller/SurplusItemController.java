package controller;

import entity.FoodItem;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SurplusItemController", value = "/retailer/safe/surplusItemController")
public class SurplusItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入surplus controller");
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer priceType = Integer.parseInt(request.getParameter("priceType"));
        double price = Double.parseDouble(request.getParameter("price"));
        System.out.println("price="+price+"priceType="+priceType);
        FoodItem foodItem = new FoodItem();
        foodItem.setIsPlus(1);
        foodItem.setPriceTypeID(priceType);
        foodItem.setPrice(price);

        FoodItemService foodItemService = new FoodItemServiceImpl();
        foodItemService.surplusItem(foodItem);
        response.sendRedirect(request.getContextPath()+"/retailer/safe/showRetailerItemsController");
    }
}
