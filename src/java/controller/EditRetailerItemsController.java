package controller;

import entity.FoodItem;
import entity.Retailer;
import jakarta.servlet.http.HttpSession;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
