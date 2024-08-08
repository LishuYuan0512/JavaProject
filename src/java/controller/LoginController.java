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
 * Servlet implementation class LoginController
 * Handles user login for customers, retailers, and charities.
 * It verifies user credentials and redirects users based on their role.
 * If login fails, it redirects to the login page with an error message.
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
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
     * Processes POST requests to handle user login.
     * Verifies user credentials and sets session attributes based on user role.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Receive parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

          // Call services to handle login
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.login(email, password);

        RetailerService retailerService = new RetailerServiceImpl();
        Retailer retailer = retailerService.login(email, password);

        CharityService charityService = new CharityServiceImpl();
        Charity charity = charityService.login(email, password);

        HttpSession session = request.getSession();
        String redirectURL = request.getContextPath() + "/login.jsp";
        boolean loginSuccess = false;
      // Redirect user or show login error
        if (customer != null) {
            session.setAttribute("customer", customer);
            if (customer.getUserType().equalsIgnoreCase("Customer")) {
                session.setAttribute("customer", customer);
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