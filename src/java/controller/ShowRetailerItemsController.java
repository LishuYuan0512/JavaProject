/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import entity.Retailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.FoodItemService;
import service.FoodItemServiceImpl;

@WebServlet(name = "ShowRetailerItemsController", value = "/retailer/safe/showRetailerItemsController")
public class ShowRetailerItemsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //filter已经做了权限验证
        HttpSession session = request.getSession();
        Retailer retailer = (Retailer) session.getAttribute("retailer");

        if (retailer == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 使用零售商的userID来获取该零售商的商品
        int userID = retailer.getUserID();
        FoodItemService fs = new FoodItemServiceImpl();
        List<FoodItem> foodItems = fs.getFoodItemsByRetailerId(userID);
        request.setAttribute("foodItems", foodItems);
        RequestDispatcher rd = request.getRequestDispatcher("/retailer/safe/showRetailerItemsJSP");
        rd.forward(request,response);
    }
}