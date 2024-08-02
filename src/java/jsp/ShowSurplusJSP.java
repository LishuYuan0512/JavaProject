package jsp;

import entity.FoodItem;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowSurplusJSP", value = "/retailer/safe/showSurplusItemJSP")
public class ShowSurplusJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemID = Integer.parseInt(request.getParameter("surplusItemID"));
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(itemID);

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
        printWriter.println("<a href='" + request.getContextPath() + "/customer/safe/showItemsController' class='text-white'>back</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Checkout</h2>");
        printWriter.println("<form action='" + request.getContextPath() + "/retailer/safe/surplusItemController' method='post'>");


        printWriter.println("<div class='form-group'>");
        printWriter.println("<input type='hidden' class='form-control' id='itemID' name='itemID' value='" + foodItem.getItemID() + "'>");
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
        printWriter.println("<label for='price'>Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price'>");
        printWriter.println("</div>");


//        printWriter.println("<script>");
//        printWriter.println("function updatePriceInput() {");
//        printWriter.println("    var priceType = document.getElementById('priceType').value;");
//        printWriter.println("    var priceInput = document.getElementById('price');");
//        printWriter.println("    if (priceType === '1') {"); // '1' corresponds to 'Donate'
//        printWriter.println("        priceInput.value = '0';");
//        printWriter.println("        priceInput.disabled = true;"); // Disable input field
//        printWriter.println("    } else if (priceType === '2') {"); // '2' corresponds to 'Sales'
//        printWriter.println("        priceInput.disabled = false;"); // Enable input field
//        printWriter.println("    } else {");
//        printWriter.println("        priceInput.value = '';");
//        printWriter.println("        priceInput.disabled = false;"); // Enable input field
//        printWriter.println("    }");
//        printWriter.println("}");
//        printWriter.println("</script>");


        printWriter.println("<div class='text-center mt-3'>");
        printWriter.println("<input type='submit' value='Surplus' class='btn btn-custom btn-block'>");
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
