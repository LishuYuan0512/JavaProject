/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.FoodItem;
import entity.Retailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.FoodItemService;
import service.FoodItemServiceImpl;

@WebServlet(name = "AddRetailerItemController", value = "/retailer/safe/addRetailerItemController")
public class AddRetailerItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Retailer retailer = (Retailer) session.getAttribute("retailer");
        int userID = retailer.getUserID();
       String itemName = request.getParameter("itemName");
       double price = Double.parseDouble(request.getParameter("price"));
       int quantity = Integer.parseInt(request.getParameter("quantity"));
       String restockTime = request.getParameter("restockTime");
       String expirationDate = request.getParameter("expirationDate");
       int priceTypeID = Integer.parseInt(request.getParameter("priceType"));
       int isSurplus = Integer.parseInt(request.getParameter("isSurplus"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate1 = null;
        Date restockTime2 = null;
        try {
            expirationDate1 = sdf.parse(expirationDate);
            restockTime2 = sdf.parse(restockTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        FoodItem foodItem = new FoodItem();
        foodItem.setItemName(itemName);
        foodItem.setPrice(price);
        foodItem.setQuantity(quantity);
        foodItem.setRestockTime(restockTime2);
        foodItem.setExpirationDate(expirationDate1);
        foodItem.setUserID(userID);
        foodItem.setPriceTypeID(priceTypeID);
        foodItem.setIsPlus(isSurplus);
        System.out.println("add item controller: priceTypeID: " + priceTypeID + ", isSurplus: " + isSurplus);
        System.out.println("foodItem priceTypeID: " + foodItem.getPriceTypeID());
        FoodItemService foodItemService = new FoodItemServiceImpl();
        foodItemService.insertFoodItem(foodItem);
        response.sendRedirect(request.getContextPath()+"/retailer/safe/showRetailerItemsController");
    }
}