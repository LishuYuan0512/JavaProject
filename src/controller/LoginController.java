package controller;

import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "LoginController", value = "/LoginController")
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

