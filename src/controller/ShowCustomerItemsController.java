package controller;

import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerItemsController", value = "/customer/safe/showItemsController")
public class ShowCustomerItemsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //filter已经做了权限验证
        FoodItemService fs = new FoodItemServiceImpl();
        List<FoodItem> foodItems = fs.getAllFoodItems();
        request.setAttribute("foodItems", foodItems);
        RequestDispatcher rd = request.getRequestDispatcher("/customer/safe/showItemsJSP");
        rd.forward(request,response);
    }
}
