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
 * A servlet that displays a claim page for charities.
 * It retrieves the details of a food item for claiming and renders a form for entering the claim quantity.
 */

@WebServlet(name = "ShowClaimJSP", value = "/charity/safe/showClaimJSP")
public class ShowClaimJSP extends HttpServlet {
    
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
     * Retrieves the food item details by ID and displays the claim form.
     *
     * @param request  The HttpServletRequest object that contains the request the client made to the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet returns to the client.
     * @throws ServletException If an error occurs during the request handling.
     * @throws IOException      If an I/O error occurs during the request handling.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer foodId = Integer.parseInt(request.getParameter("claimItemID"));
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(foodId);

        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"en\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        printWriter.println("<title>CheckOut - Food Waste Reduction Platform</title>");
        printWriter.println("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        printWriter.println("<link href='" + request.getContextPath() + "/styles.css'rel='stylesheet'>");
        printWriter.println("<style>");
        printWriter.println(".error { border-color: red; }");
        printWriter.println(".error-message { color: red; font-size: 14px; }");
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
        printWriter.println("<a href='" + request.getContextPath() + "/charity/safe/claimItemsController' class='text-white'>back</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Checkout</h2>");
        printWriter.println("<form id='claimForm' action='" + request.getContextPath() + "/charity/safe/claimItemsController' method='post'>");

        System.out.println("itemID:" + foodItem.getItemID());

        printWriter.println("<div class='form-group'>");
        printWriter.println("<input type='hidden' class='form-control' id='itemID' name='itemID' value='" + foodItem.getItemID() + "'>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='itemName'>Item Name</label>");
        printWriter.println("<input type='text' class='form-control' id='itemName' name='itemName' value='" + foodItem.getItemName() + "' readonly>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='price'>Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price' value='" + foodItem.getPrice() + "' readonly>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='enterQuantity'>Quantity</label>");
        printWriter.println("<input type='text' class='form-control' id='quantity' name='quantity' >");
        printWriter.println("<div class='error-message'></div>");
        printWriter.println("</div>");


        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<input type='submit' value='Check out' class='btn btn-custom btn-block'>");
        printWriter.println("</div>");

        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<a href='" + request.getContextPath() + "/charity/safe/showItemsController' class='btn btn-secondary btn-block'>Go Back</a>");
        printWriter.println("</div>");

        printWriter.println("</form>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
        printWriter.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
        printWriter.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
        printWriter.println("<script>");
        printWriter.println("document.querySelector('#claimForm').addEventListener('submit', function(e) {");
        printWriter.println("    var isValid = validateForm();");
        printWriter.println("    if (!isValid) {");
        printWriter.println("        e.preventDefault();"); // Prevent form submission if invalid
        printWriter.println("    }");
        printWriter.println("});");

        printWriter.println("function validateForm() {");
        printWriter.println("    var isValid = true;");
        printWriter.println("    $('.error-message').text('');");
        printWriter.println("    $('.form-control').removeClass('error');");

        // Get available quantity
        printWriter.println("    var availableQuantity = parseInt('" + foodItem.getQuantity() + "');");
        
        // Validate entered quantity
        printWriter.println("    var quantity = parseInt($('#quantity').val());");
        printWriter.println("    if (isNaN(quantity) || quantity <= 0) {");
        printWriter.println("        setError('#quantity', 'Quantity should be a positive integer.');");
        printWriter.println("        isValid = false;");
        printWriter.println("    } else if (quantity > availableQuantity) {");
        printWriter.println("        setError('#quantity', 'Quantity exceeds available stock.');");
        printWriter.println("        isValid = false;");
        printWriter.println("    }");

        printWriter.println("    return isValid;");
        printWriter.println("}");

        printWriter.println("function setError(selector, message) {");
        printWriter.println("    $(selector).addClass('error');");
        printWriter.println("    $(selector).next('.error-message').text(message);");
        printWriter.println("}");
        printWriter.println("</script>");
        
        
        printWriter.println("</body>");
        printWriter.println("<div class=\"footer bg-light text-center p-3 mt-4\">");
        printWriter.println("<p>© 2024 Food Waste Reduction Platform. All rights reserved.</p>");
        printWriter.println("</div>");
        printWriter.println("</html>");
    }

}