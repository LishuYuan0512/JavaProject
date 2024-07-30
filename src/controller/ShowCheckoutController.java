package controller;

import entity.Customer;
import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckoutController", value = "/customer/safe/showCheckoutController")
public class ShowCheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        Integer foodId = Integer.parseInt(request.getParameter("itemID"));
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(foodId);
        request.setAttribute("foodItem", foodItem);
        request.getRequestDispatcher("/customer/safe/showCheckoutJSP").forward(request, response);


    }
}
