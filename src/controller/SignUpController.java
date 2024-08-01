package controller;

import dao.*;
import entity.Charity;
import entity.Customer;
import entity.Retailer;
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
            response.sendRedirect(request.getContextPath() + "/login.html");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
