/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jsp;

import dao.RetailerDAO;
import dao.RetailerDAOImpl;
import entity.FoodItem;
import entity.Retailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.PriceTypeService;
import service.PriceTypeServiceImpl;

/**
 *
 * @author ZU
 */
@WebServlet(name = "ShowRetailerItemsServlet", urlPatterns = {"/retailer/safe/showRetailerItemsJSP"})
public class showRetailerItemsJSP extends HttpServlet {
    
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