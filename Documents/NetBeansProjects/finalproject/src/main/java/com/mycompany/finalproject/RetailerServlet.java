package com.mycompany.finalproject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/retailer/*")
public class RetailerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FoodItemBusinessLogic foodItemService;

    @Override
    public void init() {
        foodItemService = new FoodItemBusinessLogic(new FoodItemDaoImpl());
    }
    
    private void listFoodItems(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    List<FoodItem> foodItems = foodItemService.getAllItems();
    request.setAttribute("foodItems", foodItems);
    request.getRequestDispatcher("/WEB-INF/retailer.jsp").forward(request, response);
}
//        private void listFoodItems(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setAttribute("foodItems", foodItemService.getAllItems());
//        request.getRequestDispatcher("/WEB-INF/retailer.jsp").forward(request, response);
//    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    private void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "list";
//        }
//        switch (action) {
//            case "add":
//                showAddForm(request, response);
//                break;
//            case "update":
//                showUpdateForm(request, response);
//                break;
//            case "delete":
//                deleteFoodItem(request, response);
//                break;
//            case "markAsSurplus":
//                markAsSurplus(request, response);
//                break;
//            case "list":
//            default:
//                listFoodItems(request, response);
//                break;
//        }
//    }

//    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/add-item.jsp").forward(request, response);
//    }
//
//    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int itemID = Integer.parseInt(request.getParameter("itemID"));
//        FoodItem existingItem = foodItemService.getItem(itemID);
//        request.setAttribute("foodItem", existingItem);
//        request.getRequestDispatcher("/WEB-INF/add-item.jsp").forward(request, response);
//    }
//
//    private void deleteFoodItem(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        int itemID = Integer.parseInt(request.getParameter("itemID"));
//        foodItemService.deleteItem(itemID);
//        response.sendRedirect("retailer?action=list");
//    }
//
//    private void markAsSurplus(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        int itemID = Integer.parseInt(request.getParameter("itemID"));
//        foodItemService.markAsSurplus(itemID);
//        response.sendRedirect("retailer?action=list");
//    }
//
//    private void listFoodItems(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setAttribute("foodItems", foodItemService.getAllItems());
//        request.getRequestDispatcher("/WEB-INF/retailer.jsp").forward(request, response);
//    }

//    private void addFoodItem(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        FoodItem newItem = new FoodItem();
//        populateFoodItemFromRequest(newItem, request);
//        foodItemService.addItem(newItem);
//        response.sendRedirect("retailer?action=list");
//    }
//
//    private void updateFoodItem(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        int itemID = Integer.parseInt(request.getParameter("itemID"));
//        FoodItem existingItem = foodItemService.getItem(itemID);
//        populateFoodItemFromRequest(existingItem, request);
//        foodItemService.updateItem(existingItem);
//        response.sendRedirect("retailer?action=list");
//    }
//
//    private void populateFoodItemFromRequest(FoodItem item, HttpServletRequest request)
//            throws ServletException {
//        try {
//            item.setUserID(Integer.parseInt(request.getParameter("userID")));
//            item.setItemName(request.getParameter("itemName"));
//            item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
//            item.setPrice(Double.parseDouble(request.getParameter("price")));
//            item.setPriceTypeID(Integer.parseInt(request.getParameter("priceTypeID")));
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            item.setRestockTime(formatter.parse(request.getParameter("restockTime")));
//            item.setExpirationDate(formatter.parse(request.getParameter("expirationDate")));
//            item.setIsSurplus(Boolean.parseBoolean(request.getParameter("isSurplus")));
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//    }
}
