/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import service.CustomerService;
import service.CustomerServiceImpl;

/**
 *
 * @author ZU
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 收取参数
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        logger.info("Received login request with email: " + email);

        // 调用服务来处理登录
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.login(email, password);

        if (customer != null) {
            logger.info("Login successful for email: " + email);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            logger.info("Customer type: " + customer.getUserType());

            if (customer.getUserType().equalsIgnoreCase("Customer")) {
                logger.info("Redirecting to customer page");
                response.sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
            } else {
                logger.warning("Unexpected user type: " + customer.getUserType());
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        } else {
            logger.warning("Login failed for email: " + email);
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

}
