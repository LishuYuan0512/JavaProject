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
 * A servlet that displays a form for updating the status of a surplus food item.
 * It allows the retailer to change the price type and apply a discount to the item.
 */

@WebServlet(name = "ShowSurplusJSP", value = "/retailer/safe/showSurplusItemJSP")
public class ShowSurplusJSP extends HttpServlet {
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
     * Retrieves the food item details by ID and displays a form to change its surplus status.
     *
     * @param request  The HttpServletRequest object that contains the request the client made to the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet returns to the client.
     * @throws ServletException If an error occurs during the request handling.
     * @throws IOException      If an I/O error occurs during the request handling.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemID = Integer.parseInt(request.getParameter("surplusItemID"));
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(itemID);
        
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"en\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        printWriter.println("<title>SurplusItem - Food Waste Reduction Platform</title>");
        printWriter.println(" <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        printWriter.println("<link href='" + request.getContextPath() + "/styles.css'rel='stylesheet'>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class=\"header navbar navbar-expand-lg\">");
        printWriter.println("<a class=\"navbar-brand\" href=\"" + request.getContextPath() + "/index.jsp\">Food Waste Reduction Platform</a>");
        printWriter.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
        printWriter.println("<span class=\"navbar-toggler-icon\"></span>");
        
        printWriter.println("</button>");
        printWriter.println("<div>");
        printWriter.println("<a href='" + request.getContextPath() + "/customer/safe/showItemsController' class='text-white'>BACK</a>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<a href='" + request.getContextPath() + "/LogoutController' class='text-white'>Log out</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Change Status of Surplus</h2>");
        printWriter.println("<form action='" + request.getContextPath() + "/retailer/safe/surplusItemController' method='post'>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<input type='hidden' class='form-control' id='itemID' name='itemID' value='" + foodItem.getItemID() + "'>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='price'>Current Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price' value='" + foodItem.getPrice() + "' readonly>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='priceType'>Price Type</label>");
        printWriter.println("<select class='form-control' id='priceType' name='priceType' onchange='updatePriceInput()'>");
        printWriter.println("<option value='' disabled selected>Select a price type</option>");
        printWriter.println("<option value='1'>Donate</option>");
        printWriter.println("<option value='2'>Sales</option>");
        printWriter.println("</select>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='discount'>Discount</label>");
        printWriter.println("<input type='text' class='form-control' id='discount' name='discount'>");
        printWriter.println("<div class='error-message text-danger'></div>");
        printWriter.println("</div>");

        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<input type='submit' value='Surplus' class='btn btn-custom btn-block'>");
        printWriter.println("</div>");

        printWriter.println("</form>");
        printWriter.println("</div>");
        printWriter.println("</div>");

        printWriter.println("<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>");
        printWriter.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
        printWriter.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
        printWriter.println("<script>");
        printWriter.println("document.querySelector('form').addEventListener('submit', function(e) {");
        printWriter.println("    e.preventDefault();");
        printWriter.println("    var isValid = validateForm();");
        printWriter.println("    if (isValid) {");
        printWriter.println("        this.submit();");
        printWriter.println("    }");
        printWriter.println("});");

        printWriter.println("function validateForm() {");
        printWriter.println("    var isValid = true;");
        printWriter.println("    $('.error-message').text('');");
        printWriter.println("    $('.form-control').removeClass('error');");

        // Get the current price
        printWriter.println("    var currentPrice = parseFloat($('#price').val());");

        // Validate discount
        printWriter.println("    var discount = parseFloat($('#discount').val());");
        printWriter.println("    if (isNaN(discount) || discount < 0) {");
        printWriter.println("        setError('#discount', 'Discount should be a non-negative number.');");
        printWriter.println("        isValid = false;");
        printWriter.println("    }");

        // Ensure discount is less than the current price
        printWriter.println("    if (!isNaN(currentPrice) && discount >= currentPrice) {");
        printWriter.println("        setError('#discount', 'Discount should be less than the current price.');");
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
