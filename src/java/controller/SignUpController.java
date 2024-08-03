
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CharityDAO;
import dao.CharityDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.RetailerDAO;
import dao.RetailerDAOImpl;
import entity.Charity;
import entity.Customer;
import entity.Retailer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZU
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
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
        HttpSession session = request.getSession();
        System.out.println("从表单接收的信息如下："+email+"-"+password);
        try {
            switch (type){
                case "Customer":
                    System.out.println("----进入customer");
                    Customer customer = new Customer(username, password, email, phone, type, locationID);
                    CustomerDAO customerDAO = new CustomerDAOImpl();
                    session.setAttribute("customer", customer);
                    customerDAO.insertCustomer(customer);
                    break;
                case "Retailer":
                    Retailer retailer = new Retailer(username, password, email, phone, type, locationID);
                    System.out.println("------接收的 retailer信息如下："+retailer.getEmail()+retailer.getPassword());
                    RetailerDAO retailerDAO = new RetailerDAOImpl();
                    session.setAttribute("retailer", retailer);
                    retailerDAO.insertRetailer(retailer);
                    break;
                case "Charity":
                    System.out.println("进入charity");
                    Charity charity = new Charity(username, password, email, phone, type, locationID);
                    CharityDAO charityDAO = new CharityDAOImpl();
                    session.setAttribute("charity", charity);
                    charityDAO.insertCharity(charity);
                    break;
            }
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}