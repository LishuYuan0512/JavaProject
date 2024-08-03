/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jsp;

import dao.RetailerDAO;
import dao.RetailerDAOImpl;
import entity.FoodItem;
import entity.Retailer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowRetailerItemsServlet", urlPatterns = {"/retailer/safe/showRetailerItemsJSP"})
public class ShowItemsJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Retailer retailer = (Retailer) session.getAttribute("retailer");

        if (retailer == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        RetailerDAO retailerDAO = new RetailerDAOImpl();
        List<FoodItem> foodItems = retailerDAO.getRetailerItems(retailer.getUserID());

        request.setAttribute("foodItems", foodItems);
        request.getRequestDispatcher("/retailer.jsp").forward(request, response);
    }
}