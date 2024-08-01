/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

@WebServlet(name = "AddRetailerItemJSP", value = "/retailer/safe/showAddRetailerItemJSP")
public class ShowAddRetailerItemJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodItemService fs = new FoodItemServiceImpl();


        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        printWriter.println("<title>Checkout - XXX Website</title>");
        printWriter.println("<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
        printWriter.println("<link href='" + request.getContextPath() + "/styles.css' rel='stylesheet'>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='header'>");
        printWriter.println("<span>xxx website</span>");
        printWriter.println("<div>");
        printWriter.println("<a href='" + request.getContextPath() + "/retailer/safe//retailer/safe/addRetailerItemController' class='text-white'>back</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Checkout</h2>");
        printWriter.println("<form action='" + request.getContextPath() + "/retailer/safe/addRetailerItemController' method='post'>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='itemName'>Item Name</label>");
        printWriter.println("<input type='text' class='form-control' id='itemName' name='itemName'>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='price'>Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price' >");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='quantity'>Quantity</label>");
        printWriter.println("<input type='number' class='form-control' id='quantity' name='quantity'> ");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='restockTime'>Restock date</label>");
        printWriter.println("<input type='date' class='form-control' id='restockTime' name='restockTime' placeholder='Restock date' >");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='expirationData'>Expiration date</label>");
        printWriter.println("<input type='date' class='form-control' id='expirationData' name='expirationData' placeholder='Expiration date' >");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='priceType'>Price Type</label>");
        printWriter.println("<select class='form-control' id='priceType' name='priceType'>");
        printWriter.println("<option value='' disabled selected>Select a price type</option>");
        printWriter.println("<option value='1'>Donate</option>");
        printWriter.println("<option value='2'>Sales</option>");
        printWriter.println("</select>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='isSurplus'>Is Surplus</label>");
        printWriter.println("<select class='form-control' id='isSurplus' name='isSurplus'>");
        printWriter.println("<option value='' disabled selected>Select an option</option>");
        printWriter.println("<option value='1'>Yes</option>");
        printWriter.println("<option value='2'>No</option>");
        printWriter.println("</select>");
        printWriter.println("</div>");


        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<input type='submit' value='Add Item' class='btn btn-custom btn-block'>");
        printWriter.println("</div>");

        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<a href='" + request.getContextPath() + "/retailer/safe/showRetailerItemsController' class='btn btn-secondary btn-block'>Go Back</a>");
        printWriter.println("</div>");

        printWriter.println("</form>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
        printWriter.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
        printWriter.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}