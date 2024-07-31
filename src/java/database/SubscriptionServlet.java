/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Subscription.Subscription;
import Subscription.SubscriptionBusinessLogic;
import Subscription.SubscriptionDao;
import Subscription.SubscriptionDAOImp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author rosal
 */
public class SubscriptionServlet extends HttpServlet {
    private SubscriptionBusinessLogic subscriptionService;

    @Override
    public void init() throws ServletException {
        Connection connection = DataSource.getInstance().getConnection();
        SubscriptionDao subscriptionDao = new SubscriptionDAOImp(connection);
        subscriptionService = new SubscriptionBusinessLogic(subscriptionDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests (if needed)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("create".equals(action)) {
                int userID = Integer.parseInt(request.getParameter("userID")); // 假设 userID 是从 session 或其他来源获取
                String foodPreference = request.getParameter("foodPreference");
                String location = request.getParameter("location");
                String contactMethod = request.getParameter("contactMethod");
                String email = "Email".equals(contactMethod) ? request.getParameter("email") : null;
                String phone = "Phone".equals(contactMethod) ? request.getParameter("phone") : null;

                Subscription subscription = new Subscription(0, userID, location, foodPreference, email, phone);
                subscriptionService.createSubscription(subscription);
                response.sendRedirect("subscriptionSuccess.html");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}