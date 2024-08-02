package controller;

import dao.*;
import entity.Charity;
import entity.Customer;
import entity.Retailer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Validation.InputValidator;

import java.io.IOException;

@WebServlet(name = "SignUpController", value = "/SignUpController")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        int locationID = Integer.parseInt(request.getParameter("location"));
        HttpSession session = request.getSession();
        System.out.println("Received form data: " + email + "-" + password);
        
        // Validate inputs
        String validationError = validateInputs(email, phone, password, retypePassword);
        if (validationError != null) {
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            request.setAttribute("error", validationError);
            return;
        }

        try {
            switch (type) {
                case "Customer":
                    System.out.println("Processing customer registration");
                    Customer customer = new Customer(username, password, email, phone, type, locationID);
                    CustomerDAO customerDAO = new CustomerDAOImpl();
                    customerDAO.insertCustomer(customer);
                    session.setAttribute("customer", customer);
                    break;
                case "Retailer":
                    System.out.println("Processing retailer registration");
                    Retailer retailer = new Retailer(username, password, email, phone, type, locationID);
                    RetailerDAO retailerDAO = new RetailerDAOImpl();
                    retailerDAO.insertRetailer(retailer);
                    session.setAttribute("retailer", retailer);
                    break;
                case "Charity":
                    System.out.println("Processing charity registration");
                    Charity charity = new Charity(username, password, email, phone, type, locationID);
                    CharityDAO charityDAO = new CharityDAOImpl();
                    charityDAO.insertCharity(charity);
                    session.setAttribute("charity", charity);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid user type: " + type);
            }
            
            // Redirect to login page after successful registration
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } catch (Exception e) {
            // Log the exception and set an error message
            e.printStackTrace();
            request.setAttribute("error", "Registration failed due to a server error.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

    private String validateInputs(String email, String phone, String password, String retypePassword) {
        if (!InputValidator.isValidEmail(email)) {
            return "Invalid email format.";
        }
        if (!InputValidator.isValidPhone(phone)) {
            return "Phone number must be 10 digits.";
        }
        if (!InputValidator.isValidPassword(password)) {
            return "Password must be at least 4 characters long and contain at least one letter and one number.";
        }
        if (!InputValidator.doPasswordsMatch(password, retypePassword)) {
            return "Passwords do not match.";
        }
        return null;
    }
}