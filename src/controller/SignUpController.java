package controller;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "SignUpController", value = "/SignUpController")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收参数
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        int locationID = Integer.parseInt(request.getParameter("location"));
        Customer customer = new Customer(username, password, email, phone, type, locationID);
        CustomerDAO customerDAO = new CustomerDAOImpl();
        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);
        customerDAO.insertCustomer(customer);
        response.sendRedirect(request.getContextPath()+"/login.html");


    }
}
