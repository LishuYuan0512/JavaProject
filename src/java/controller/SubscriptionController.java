/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Subscription.Subscription;
import dao.SubscriptionDAOImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SubscriptionServiceImpl;

/**
 *
 * @author ZU
 */
@WebServlet(name = "SubscriptionController", urlPatterns = {"/SubscriptionController"})
public class SubscriptionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
//        try {
            if ("create".equals(action)) {
                int userID = Integer.parseInt(request.getParameter("userID")); // 假设 userID 是从 session 或其他来源获取
                String foodPreference = request.getParameter("foodPreference");
                String location = request.getParameter("location");
                String contactMethod = request.getParameter("contactMethod");
                String email = "Email".equals(contactMethod) ? request.getParameter("email") : null;
                String phone = "Phone".equals(contactMethod) ? request.getParameter("phone") : null;

                Subscription subscription = new Subscription(0, userID, location, foodPreference, email, phone);
//                SubscriptionDAOImp.createSubscription(subscription);
                response.sendRedirect("subscriptionSuccess.html");
            }
//        } 
//        catch (SQLException e) {
//            throw new ServletException(e);
//        } 
    }

}
