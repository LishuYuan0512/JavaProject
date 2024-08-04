/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Charity;
import entity.Customer;
import entity.Retailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.CharityService;
import service.CharityServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.RetailerService;
import service.RetailerServiceImpl;

/**
 *
 * @author ZU
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 收取参数
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 调用服务来处理登录
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.login(email, password);

        RetailerService retailerService = new RetailerServiceImpl();
        Retailer retailer = retailerService.login(email, password);

        CharityService charityService = new CharityServiceImpl();
        Charity charity = charityService.login(email, password);

        HttpSession session = request.getSession();
        String redirectURL = request.getContextPath() + "/login.jsp";
        boolean loginSuccess = false;

        if (customer != null) {
            session.setAttribute("customer", customer);
            if (customer.getUserType().equalsIgnoreCase("Customer")) {
                redirectURL = request.getContextPath() + "/customer/safe/showItemsController";
                loginSuccess = true;
            }
        } else if (retailer != null) {
            session.setAttribute("retailer", retailer);
            if (retailer.getUserType().equalsIgnoreCase("Retailer")) {
                redirectURL = request.getContextPath() + "/retailer/safe/showRetailerItemsController";
                loginSuccess = true;
            }
        } else if (charity != null) {
            session.setAttribute("charity", charity);
            if (charity.getUserType().equalsIgnoreCase("Charity")) {
                redirectURL = request.getContextPath() + "/charity/safe/showItemsController";
                loginSuccess = true;
            }
        }

        if (!loginSuccess) {
            request.setAttribute("loginError", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(redirectURL);
        }
    }
}