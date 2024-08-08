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
 * Servlet implementation class SignUpController
 * Handles user registration for customers, retailers, and charities.
 * It processes the signup form, creates the appropriate user entity, 
 * and persists it to the database using DAOs.
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {
    
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
     * Processes POST requests to handle user registration.
     * Based on the user type, it creates the appropriate entity, 
     * saves it to the database, and sets the session attribute.
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        int locationID = Integer.parseInt(request.getParameter("location"));
        HttpSession session = request.getSession();
       
        try {
            switch (type){
                case "Customer":
                   
                    Customer customer = new Customer(username, password, email, phone, type, locationID);
                    CustomerDAO customerDAO = new CustomerDAOImpl();
                    session.setAttribute("customer", customer);
                    customerDAO.insertCustomer(customer);
                    break;
                case "Retailer":
                    Retailer retailer = new Retailer(username, password, email, phone, type, locationID);
                  
                    RetailerDAO retailerDAO = new RetailerDAOImpl();
                    session.setAttribute("retailer", retailer);
                    retailerDAO.insertRetailer(retailer);
                    break;
                case "Charity":
                
                    Charity charity = new Charity(username, password, email, phone, type, locationID);
                    CharityDAO charityDAO = new CharityDAOImpl();
                    session.setAttribute("charity", charity);
                    charityDAO.insertCharity(charity);
                    break;
            }
             // Send success response and redirect to login page
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration successful! Redirecting to login page.');");
            out.println("window.location.href = '" + request.getContextPath() + "/login.jsp';");
            out.println("</script>");
            out.close();       
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}