/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

@WebServlet(name = "EditRetailerItemsController", value = "/retailer/safe/editRetailerItemsController")
public class EditRetailerItemsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入doPost方法");
        Integer itemId = (Integer.parseInt(request.getParameter("itemID")));
        int enterQuantity = Integer.parseInt(request.getParameter("enterQuantity"));
        System.out.println("表单数据："+itemId +"-"+enterQuantity);
        String date = request.getParameter("expirationData");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate = null;
        try {
            expirationDate = sdf.parse(date);
            System.out.println("======传递的日期为："+expirationDate);
        } catch (ParseException ex) {
            Logger.getLogger(EditRetailerItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FoodItemService foodItemService = new FoodItemServiceImpl();
        FoodItem foodItem = foodItemService.getFoodItemById(itemId);
        foodItem.setQuantity(enterQuantity);
        foodItem.setExpirationDate(expirationDate);
        foodItemService.addFoodItemQuantity(foodItem);
        foodItemService.updateFoodItemDate(foodItem);
        response.sendRedirect(request.getContextPath()+"/retailer/safe/showRetailerItemsController");

    }
}