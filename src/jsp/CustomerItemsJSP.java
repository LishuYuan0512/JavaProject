package jsp;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import entity.Customer;
import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CustomerItemsJSP", value = "/customer/safe/showItemsJSP")
public class CustomerItemsJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = null;
        List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
        HttpSession session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        CustomerDAO customerDAO = new CustomerDAOImpl();

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<meta name='viewport' content='width=device-width,initial-scale=1.0'>");
        printWriter.println("<title>Customer-XXX Website</title>");
        printWriter.println("<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'rel='stylesheet'>");
        printWriter.println("<link href='" + request.getContextPath() + "/styles.css'rel='stylesheet'>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='header'>");
        printWriter.println("<span>xxx website</span>");
        printWriter.println("<div>");
        printWriter.println("<a href='" + request.getContextPath() + "/logoutController' class='text-white'>Log out</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Welcome back, "+customer.getUsername()+"</h2>");
        printWriter.println("<table class='table table-striped'>");
        printWriter.println("<thead>");
        printWriter.println("<tr>");
        printWriter.println("<th>itemID</th>");
        printWriter.println("<th>itemName</th>");
        printWriter.println("<th>quantity</th>");
        printWriter.println("<th>price</th>");
        printWriter.println("<th>option</th>");
        printWriter.println("</tr>");
        printWriter.println("</thead>");
        printWriter.println("<tbody id='customer-items'>");
        for (FoodItem foodItem : foodItems) {
            int userID = foodItem.getUserID();
            if (customerDAO.getUserTypeByUserID(customer).equalsIgnoreCase("Customer")){
                printWriter.println("<tr>");
                printWriter.println("<td>" + foodItem.getItemID() + "</td>");
                printWriter.println("<td>" + foodItem.getItemName() + "</td>");
                printWriter.println("<td>" + foodItem.getQuantity() + "</td>");
                printWriter.println("<td>" + foodItem.getPrice() + "</td>");
                if (foodItem.getQuantity() > 0) {
                    System.out.println(request.getContextPath() +
                            "/customer/safe/showCheckoutJSP?id="+foodItem.getItemID());
                    printWriter.println("<td><a href='" + request.getContextPath() +
                            "/customer/safe/showCheckoutJSP?itemID=" + foodItem.getItemID() + "'>Purchase</a></td>");
                }
                printWriter.println("</tr>");
            }
        }

        printWriter.println("</tbody>");
        printWriter.println("</table>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
        printWriter.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
        printWriter.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
        printWriter.println("<script>");
        printWriter.println("function purchaseItem(itemID) {");
        printWriter.println("alert('Purchasing item with ID: ' + itemID);");
        printWriter.println("// Implement your purchase logic here");
        printWriter.println("}");
        printWriter.println("</script>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}