/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import entity.FoodItem;
import entity.Purchase;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;
import service.PurchaseService;
import service.PurchaseServiceImpl;

/**
 *
 * @author ZU
 */
@WebServlet(name = "CheckoutController", value = "/customer/safe/checkoutController")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer enterQuantity = Integer.parseInt(request.getParameter("enterQuantity"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        int userID = customer.getUserID();
        
        String itemName = request.getParameter("itemName");
        Integer priceTypeID = Integer.parseInt(request.getParameter("priceTypeID"));
        Double price = Double.parseDouble(request.getParameter("price"));


        

//        Purchase purchase = new Purchase();
//        purchase.setItemID(itemID);
//        purchase.setQuantity(enterQuantity);
//        purchase.setPrice(price);
//        purchase.setPurchaseTime(LocalDateTime.now());
//        purchase.setPriceTypeID(priceTypeID);
//        purchase.setUserID(userID);
//        PurchaseService purchaseService = new PurchaseServiceImpl();
//        purchaseService.recordPurchase(purchase);

        FoodItemService foodItemService = new FoodItemServiceImpl();
        FoodItem foodItem = foodItemService.getFoodItemById(itemID);
        
        if (enterQuantity <= 0 || enterQuantity > quantity) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid quantity entered. Please enter a quantity that does not exceed the available quantity.');");
            out.println("window.location.href = '" + request.getContextPath() + "/customer/safe/showCheckoutJSP?itemID=" + itemID + "';");
            out.println("</script>");
            out.close();
            return;
        }
        
        foodItem.setQuantity(enterQuantity);
        foodItemService.purchaseFoodItemQuantity(foodItem);
        // Alert the user of successful purchase and redirect to items page
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Checkout successful! Thank you for your purchase.');");
        out.println("window.location.href = '" + request.getContextPath() + "/customer/safe/showItemsController';");
        out.println("</script>");
        out.close();
        
        response.sendRedirect(request.getContextPath()+"/customer/safe/showItemsController");

    }
}