/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 *
 * @author ZU
 */
@WebServlet(name = "ShowCustomerItems", value = "/customer/safe/showItemsController")
public class ShowCustomerItems extends HttpServlet {
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
