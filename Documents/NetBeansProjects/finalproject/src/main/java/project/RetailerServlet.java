package project;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.FoodItemBusinessLogic;
import java.util.Map;

//@WebServlet("/retailer/*")
public class RetailerServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FoodItemBusinessLogic foodItemBusinessLogic = new FoodItemBusinessLogic();
        List<FoodItem> items = null;

        try {
            items = foodItemBusinessLogic.getAllItems();
        } catch (SQLException ex) {
           log(ex.getMessage());
      }

        request.setAttribute("items", items);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    if ("add".equals(action)) {
        // Get parameters from the request
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date expirationDate = Date.valueOf(request.getParameter("expirationDate"));
        int priceTypeID = Integer.parseInt(request.getParameter("priceTypeID"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new FoodItem object and set its properties
        FoodItem newItem = new FoodItem();
        newItem.setItemName(itemName);
        newItem.setQuantity(quantity);
        newItem.setExpirationDate(expirationDate);
        newItem.setPriceTypeID(priceTypeID);
        newItem.setPrice(price);

        // Use business logic to add the new item
        FoodItemBusinessLogic foodItemBusinessLogic = new FoodItemBusinessLogic();
        try {
            foodItemBusinessLogic.addItem(newItem);
        } catch (SQLException e) {
            log(e.getMessage());
        }

        // Redirect back to the retailer page to show the updated list
        response.sendRedirect("RetailerServlet");
    } else {
        // Handle other actions (if any)
        doGet(request, response);
    }
}


    
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

//    private static final long serialVersionUID = 1L;
//
//    private FoodItemBusinessLogic foodItemService;
//
//    @Override
//    public void init() {
//        foodItemService = new FoodItemBusinessLogic(new FoodItemDaoImpl());
//    }
//    
//    private void listFoodItems(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    List<FoodItem> foodItems = foodItemService.getAllItems();
//    request.setAttribute("foodItems", foodItems);
//    request.getRequestDispatcher("/WEB-INF/retailer.jsp").forward(request, response);
//}
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
