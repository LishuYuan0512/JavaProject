
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int locationID = Integer.parseInt(request.getParameter("locationID"));
        String userType = request.getParameter("userType");

        if (username == null || password == null || email == null || phone == null || userType == null ||
            username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        try {
            if ("Charity".equalsIgnoreCase(userType)) {
                Charity charity = new Charity();
                charity.setUsername(username);
                charity.setPassword(password);
                charity.setEmail(email);
                charity.setPhone(phone);
                charity.setUserType(userType);
                charity.setLocationID(locationID);

                CharityDAO charityDAO = new CharityDAOImpl();
                if (charityDAO.insertCharity(charity) > 0) {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    return;
                }

            } else if ("Retailer".equalsIgnoreCase(userType)) {
                Retailer retailer = new Retailer();
                retailer.setUsername(username);
                retailer.setPassword(password);
                retailer.setEmail(email);
                retailer.setPhone(phone);
                retailer.setUserType(userType);
                retailer.setLocationID(locationID);

                RetailerDAO retailerDAO = new RetailerDAOImpl();
                if (retailerDAO.insertRetailer(retailer) > 0) {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    return;
                }

            } else if ("Consumer".equalsIgnoreCase(userType)) {
                Customer customer = new Customer();
                customer.setUsername(username);
                customer.setPassword(password);
                customer.setEmail(email);
                customer.setPhone(phone);
                customer.setUserType(userType);
                customer.setLocationID(locationID);

                CustomerDAO customerDAO = new CustomerDAOImpl();
                if (customerDAO.insertCustomer(customer) > 0) {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    return;
                }
            }

            // 如果插入失败
            request.setAttribute("error", "Failed to register. User might already exist.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);

        } catch (Exception e) {
             e.printStackTrace();
            request.setAttribute("error", "An unexpected error occurred.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
    }
}
