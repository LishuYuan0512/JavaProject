package jsp;

import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowEditRetailerItemsJSP", value = "/retailer/safe/showEditRetailerItemsJSP")
public class ShowEditRetailerItemsJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer editItemID = Integer.parseInt(request.getParameter("editItemID"));
        FoodItemService fs = new FoodItemServiceImpl();
        FoodItem foodItem = fs.getFoodItemById(editItemID);

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
        printWriter.println("<form action='" + request.getContextPath() + "/retailer/safe/editRetailerItemsController' method='post'>");

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
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='price'>Price</label>");
        printWriter.println("<input type='text' class='form-control' id='price' name='price' value='" + foodItem.getPrice() + "' readonly>");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='quantity'>Quantity</label>");
        printWriter.println("<input type='number' class='form-control' id='enterQuantity' name='enterQuantity' placeholder='Enter replenishment quantity' min='1'> required");
        printWriter.println("</div>");

        printWriter.println("<div class='form-group'>");
        printWriter.println("<label for='expirationData'>Expiration date</label>");
        printWriter.println("<input type='date' class='form-control' id='expirationData' name='expirationData' placeholder='Expiration date' required>");
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
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}