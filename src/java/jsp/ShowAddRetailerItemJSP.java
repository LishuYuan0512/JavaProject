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
        printWriter.println("<html lang=\"en\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        printWriter.println("<title>AddRetailerItems - Food Waste Reduction Platform</title>");
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
        printWriter.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
        printWriter.println("<span class=\"navbar-toggler-icon\"></span>");
        printWriter.println("</button>");
        printWriter.println("<div>");
        printWriter.println("<a href='" + request.getContextPath() + "/LogoutController' class='text-white'>Log out</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");

        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Please Enter the New Item</h2>");
        printWriter.println("<form id='addItemForm' action='" + request.getContextPath() + "/retailer/safe/addRetailerItemController' method='post' novalidate>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='itemName'>Item Name</label>");
        printWriter.println("<input type='text' class='form-control' id='itemName' name='itemName'>");
        printWriter.println("<div class='error-message'></div>");  // Error message placeholder
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='price'>Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price'>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='quantity'>Quantity</label>");
        printWriter.println("<input type='number' class='form-control' id='quantity' name='quantity'>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='restockTime'>Restock date</label>");
        printWriter.println("<input type='date' class='form-control' id='restockTime' name='restockTime'>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='expirationDate'>Expiration date</label>");
        printWriter.println("<input type='date' class='form-control' id='expirationDate' name='expirationDate'>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='priceType'>Price Type</label>");
        printWriter.println("<select class='form-control' id='priceType' name='priceType'>");
        printWriter.println("<option value='' disabled selected>Select a price type</option>");
        printWriter.println("<option value='1'>Donate</option>");
        printWriter.println("<option value='2'>Sales</option>");
        printWriter.println("</select>");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='isSurplus'>Is Surplus</label>");
        printWriter.println("<select class='form-control' id='isSurplus' name='isSurplus'>");
        printWriter.println("<option value='' disabled selected>Select an option</option>");
        printWriter.println("<option value='1'>Yes</option>");
        printWriter.println("<option value='2'>No</option>");
        printWriter.println("</select>");
        printWriter.println("<div class='error-message'></div>");
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

        printWriter.println("<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>");
        printWriter.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
        printWriter.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");

        // JavaScript for form validation
        printWriter.println("<script>");
        printWriter.println("document.getElementById('addItemForm').addEventListener('submit', function(e) {");
        printWriter.println("e.preventDefault();");
        printWriter.println("var isValid = validateForm();");
        printWriter.println("if (isValid) { this.submit(); }");
        printWriter.println("});");

        printWriter.println("function validateForm() {");
        printWriter.println("var isValid = true;");
        printWriter.println("$('.error-message').text('');");
        printWriter.println("$('.form-control').removeClass('error');");

        // Validate item name
        printWriter.println("var itemName = $('#itemName').val();");
        printWriter.println("if (itemName === '') {");
        printWriter.println("setError('#itemName', 'Item name should not be empty.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate price
        printWriter.println("var price = parseFloat($('#price').val());");
        printWriter.println("if (isNaN(price) || price < 0) {");
        printWriter.println("setError('#price', 'Price should be a non-negative number.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate quantity
        printWriter.println("var quantity = parseInt($('#quantity').val());");
        printWriter.println("if (isNaN(quantity) || quantity < 0) {");
        printWriter.println("setError('#quantity', 'Quantity should be a non-negative number.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate restock time
        printWriter.println("var restockTime = $('#restockTime').val();");
        printWriter.println("if (restockTime === '') {");
        printWriter.println("setError('#restockTime', 'Restock date is required.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate expiration date
        printWriter.println("var expirationDate = $('#expirationDate').val();");
        printWriter.println("if (expirationDate === '') {");
        printWriter.println("setError('#expirationDate', 'Expiration date is required.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate price type
        printWriter.println("var priceType = $('#priceType').val();");
        printWriter.println("if (priceType === null) {");
        printWriter.println("setError('#priceType', 'Please select a price type.');");
        printWriter.println("isValid = false;");
        printWriter.println("}");

        // Validate isSurplus
        printWriter.println("var isSurplus = $('#isSurplus').val();");
        printWriter.println("if (isSurplus === null) {");
        printWriter.println("setError('#isSurplus', 'Please select if this item is surplus.');");
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