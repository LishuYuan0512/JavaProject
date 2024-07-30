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
        System.out.println("item携带的数据如下：");
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        System.out.println("itemID:" + itemID);
        Integer enterQuantity = Integer.parseInt(request.getParameter("enterQuantity"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        System.out.println("enter quantity:" + enterQuantity);

        String itemName = request.getParameter("itemName");
        System.out.println("itemName:" + itemName);
        Integer priceTypeID = Integer.parseInt(request.getParameter("priceTypeID"));
        System.out.println("priceTypeID:" + priceTypeID);
        Double price = Double.parseDouble(request.getParameter("price"));
        System.out.println("price:" + price);

        System.out.println("item携带的数据如下："+itemName+"="+enterQuantity);

        Customer customer = (Customer) request.getSession().getAttribute("customer");
        System.out.println("======customer信息如下："+customer);
        int userID = customer.getUserID();

        Purchase purchase = new Purchase();
        purchase.setItemID(itemID);
        purchase.setQuantity(enterQuantity);
        purchase.setPrice(price);
        purchase.setPurchaseTime(LocalDateTime.now());

        purchase.setPriceTypeID(priceTypeID);
        purchase.setUserID(userID);
        PurchaseService purchaseService = new PurchaseServiceImpl();
        purchaseService.recordPurchase(purchase);

        FoodItem foodItem = new FoodItem();
        foodItem.setItemID(itemID);
        foodItem.setQuantity(enterQuantity);
        foodItem.setItemName(itemName);
        FoodItemService foodItemService = new FoodItemServiceImpl();
        foodItemService.modifyFoodItemQuantity(foodItem);
        response.sendRedirect(request.getContextPath()+"/customer/safe/showItemsController");
    }
}
