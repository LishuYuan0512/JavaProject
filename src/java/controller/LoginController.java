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

        if (customer != null) {
            session.setAttribute("customer", customer);
            System.out.println("customer不为空");
            if (customer.getUserType().equalsIgnoreCase("Customer")) {
                System.out.println("进入判断customer密码");
                response.sendRedirect(request.getContextPath() + "/customer/safe/showItemsController");
            }
        }else if (retailer != null) {
            System.out.println("进入判断retailer不为空");
            session.setAttribute("retailer", retailer);
            if (retailer.getUserType().equalsIgnoreCase("Retailer")) {
                System.out.println("进入判断retailer密码");
                response.sendRedirect(request.getContextPath() + "/retailer/safe/showRetailerItemsController");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        }else if (charity != null) {
            session.setAttribute("charity", charity);
            System.out.println("charity不为空");
            if (charity.getUserType().equalsIgnoreCase("Charity")) {
                response.sendRedirect(request.getContextPath() + "/charity/safe/showItemsController");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        }else {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }

    }
}