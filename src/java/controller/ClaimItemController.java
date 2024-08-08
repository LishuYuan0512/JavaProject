/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Charity;
import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * Servlet implementation class ClaimItemController
 * Handles requests for claiming food items by a charity organization.
 */

@WebServlet(name = "ClaimItemController", value = "/charity/safe/claimItemsController")
public class ClaimItemController extends HttpServlet {
    
    /**
     * Processes GET requests by delegating to the doPost method.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
        /**
     * Processes POST requests to claim a specified quantity of a food item.
     * Updates the inventory to reflect the claimed quantity.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemID = Integer.parseInt(request.getParameter("itemID"));
        Integer enterQuantity = Integer.parseInt(request.getParameter("quantity"));


        FoodItemService foodItemService = new FoodItemServiceImpl();

        FoodItem foodItem = foodItemService.getFoodItemById(itemID);
        foodItem.setQuantity(enterQuantity);
        foodItemService.purchaseFoodItemQuantity(foodItem);


        // Alert the user of successful claim and redirect to items page
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Claim successful! You have claimed " + enterQuantity + " " + foodItem.getItemName() + "(s).');");
        out.println("window.location.href = '" + request.getContextPath() + "/charity/safe/showItemsController';");
        out.println("</script>");
        out.close();
        
        response.sendRedirect(request.getContextPath()+"/charity/safe/showItemsController");
    }
}