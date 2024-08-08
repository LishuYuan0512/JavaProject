/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jsp;

import entity.FoodItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FoodItemService;
import service.FoodItemServiceImpl;

/**
 * A servlet that displays an edit page for retailer items.
 * It retrieves the details of a food item and renders a form for updating the item details.
 */

@WebServlet(name = "ShowEditRetailerItemsJSP", value = "/retailer/safe/showEditRetailerItemsJSP")
public class ShowEditRetailerItemsJSP extends HttpServlet {
    
        /**
     * Handles the HTTP GET request.
     * Forwards the request to the doPost method.
     *
     * @param request  The HttpServletRequest object that contains the request the client made to the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet returns to the client.
     * @throws ServletException If an error occurs during the request handling.
     * @throws IOException      If an I/O error occurs during the request handling.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
        /**
     * Handles the HTTP POST request.
     * Retrieves the food item details by ID and displays the edit form.
     *
     * @param request  The HttpServletRequest object that contains the request the client made to the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet returns to the client.
     * @throws ServletException If an error occurs during the request handling.
     * @throws IOException      If an I/O error occurs during the request handling.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer editItemID = Integer.parseInt(request.getParameter("editItemID"));
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(editItemID);

        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"en\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        printWriter.println("<title>Update item details - Food Waste Reduction Platform</title>");
        printWriter.println(" <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        printWriter.println("<link href='" + request.getContextPath() + "/styles.css'rel='stylesheet'>");
        
        printWriter.println("<style>");
        printWriter.println(".error { border: 1px solid red; }");
        printWriter.println(".error-message { color: red; font-size: 14px; margin-top: 5px; }");
        printWriter.println("</style>");
        
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class=\"header navbar navbar-expand-lg\">");
        printWriter.println("<a class=\"navbar-brand\" href=\"" + request.getContextPath() + "/index.jsp\">Food Waste Reduction Platform</a>");
        printWriter.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"");
        printWriter.println("<span class=\"navbar-toggler-icon\"></span>");
        
        printWriter.println("</button>");
        printWriter.println("<div>");
        printWriter.println("<a href='" + request.getContextPath() + "/LogoutController' class='text-white'>Log out</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        
        
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Please Change Details</h2>");
        printWriter.println("<form id='editItemForm' action='" + request.getContextPath() + "/retailer/safe/editRetailerItemsController' method='post'>");

        System.out.println("itemID:" + foodItem.getItemID());

        printWriter.println("<div class='form-group'>");
        printWriter.println("<input type='hidden' class='form-control' id='itemID' name='itemID' value='" + foodItem.getItemID() + "'>");
        printWriter.println("</div>");

        System.out.println("priceTypeID:" + foodItem.getPriceTypeID());
        printWriter.println("<div class='form-group'>");
        printWriter.println("<input type='hidden' class='form-control' id='priceTypeID' name='priceTypeID' value='" + foodItem.getPriceTypeID() + "' >");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='itemName'>Item Name</label>");
        printWriter.println("<input type='text' class='form-control' id='itemName' name='itemName' value='" + foodItem.getItemName() + "' readonly>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='price'>Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price' value='" + foodItem.getPrice() + "' readonly>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='quantity'>Quantity</label>");
        printWriter.println("<input type='number' class='form-control' id='enterQuantity' name='enterQuantity' placeholder='Enter replenishment quantity' min='1' required>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='expirationData'>Expiration date</label>");
        printWriter.println("<input type='date' class='form-control' id='expirationData' name='expirationData' placeholder='Expiration date' required>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<input type='submit' value='Update Item' class='btn btn-custom btn-block'>");
        printWriter.println("</div>");

        printWriter.println("</form>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
        printWriter.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
        printWriter.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
        printWriter.println("<script>");
        printWriter.println("document.getElementById('editItemForm').addEventListener('submit', function(e) {");
        printWriter.println("e.preventDefault();");
        printWriter.println("var isValid = validateForm();");
        printWriter.println("if (isValid) { this.submit(); }");
        printWriter.println("});");

        printWriter.println("function validateForm() {");
        printWriter.println("var isValid = true;");
        printWriter.println("$('.error-message').text('');");
        printWriter.println("$('.form-control').removeClass('error');");
        
                // Validate quantity
        printWriter.println("var enterQuantity = parseInt($('#enterQuantity').val());");
        printWriter.println("if (isNaN(enterQuantity) || enterQuantity <= 0) {");
        printWriter.println("setError('#enterQuantity', 'Quantity should be a positive integer.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate expiration date
        printWriter.println("var expirationData = $('#expirationData').val();");
        printWriter.println("if (expirationData === '') {");
        printWriter.println("setError('#expirationData', 'Expiration date is required.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        printWriter.println("return isValid;");
        printWriter.println("}");

        printWriter.println("function setError(selector, message) {");
        printWriter.println("$(selector).addClass('error');");
        printWriter.println("$(selector).next('.error-message').text(message);");
        printWriter.println("}");
        printWriter.println("</script>");

 
        printWriter.println("<div class=\"footer bg-light text-center p-3 mt-4\">");
        printWriter.println("<p>© 2024 Food Waste Reduction Platform. All rights reserved.</p>");
        printWriter.println("</div>"); 
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}