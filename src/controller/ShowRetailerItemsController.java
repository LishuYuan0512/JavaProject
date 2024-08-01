package controller;

import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowRetailerItemsController", value = "/retailer/safe/showRetailerItemsController")
public class ShowRetailerItemsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //filter已经做了权限验证
        System.out.println("进入controller");
        FoodItemService fs = new FoodItemServiceImpl();
        List<FoodItem> foodItems = fs.getAllFoodItems();
        request.setAttribute("foodItems", foodItems);
        RequestDispatcher rd = request.getRequestDispatcher("/retailer/safe/showRetailerItemsJSP");
        rd.forward(request,response);
    }
}
