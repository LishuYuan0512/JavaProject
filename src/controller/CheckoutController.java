package controller;

import dao.FoodItemDAO;
import dao.FoodItemDAOImpl;
import entity.Customer;
import entity.FoodItem;
import entity.Purchase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;
import service.PurchaseService;
import service.PurchaseServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

        String itemName = request.getParameter("itemName");
        Integer priceTypeID = Integer.parseInt(request.getParameter("priceTypeID"));
        Double price = Double.parseDouble(request.getParameter("price"));


        Customer customer = (Customer) request.getSession().getAttribute("customer");
        int userID = customer.getUserID();

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
        foodItem.setQuantity(enterQuantity);


        foodItemService.purchaseFoodItemQuantity(foodItem);
        response.sendRedirect(request.getContextPath()+"/customer/safe/showItemsController");
    }
}
