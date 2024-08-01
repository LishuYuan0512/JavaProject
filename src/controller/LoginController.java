package controller;

import entity.Charity;
import entity.Customer;
import entity.Retailer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.*;

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
