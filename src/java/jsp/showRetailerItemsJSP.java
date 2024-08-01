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
@WebServlet(name = "showRetailerItemsJSP", value = "/retailer/safe/showRetailerItemsJSP")
public class showRetailerItemsJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Retailer retailer = null;
        List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");

        HttpSession session = request.getSession();
        retailer = (Retailer) session.getAttribute("retailer");
        RetailerDAO retailerDAO = new RetailerDAOImpl();
        PriceTypeService priceTypeService = new PriceTypeServiceImpl();


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
        printWriter.println("<a href='" + request.getContextPath() + "/LogoutController' class='text-white'>Log out</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("<div class='main'>");
        printWriter.println("<div class='container'>");
        printWriter.println("<h2 class='text-center'>Welcome back, "+retailer.getUsername()+"</h2>");
        printWriter.println("<td><a href='" + request.getContextPath() +
                "/retailer/safe/showAddRetailerItemJSP'>Add</a></td>");
        printWriter.println("<table class='table table-striped'>");
        printWriter.println("<thead>");
        printWriter.println("<tr>");
        printWriter.println("<th>itemID</th>");
        printWriter.println("<th>itemName</th>");
        printWriter.println("<th>quantity</th>");
        printWriter.println("<th>Expiration Date</th>");
        printWriter.println("<th>Price Type</th>");
        printWriter.println("<th>price</th>");
        printWriter.println("<th>isSurplus</th>");
        printWriter.println("<th colspan='3'>Options</th>");
        printWriter.println("</tr>");
        printWriter.println("</thead>");
        printWriter.println("<tbody id='customer-items'>");
        for (FoodItem foodItem : foodItems) {
            int userID = foodItem.getUserID();
            if (retailerDAO.getUserTypeByUserID(retailer).equalsIgnoreCase("Retailer")){
                printWriter.println("<tr>");
                printWriter.println("<td>" + foodItem.getItemID() + "</td>");
                printWriter.println("<td>" + foodItem.getItemName() + "</td>");
                printWriter.println("<td>" + foodItem.getQuantity() + "</td>");
                printWriter.println("<td>" + foodItem.getExpirationDate() + "</td>");

                int priceTypeID = foodItem.getIsPlus();
                printWriter.println("<td>" + priceTypeService.showPriceType(priceTypeID) + "</td>");
                printWriter.println("<td>" + foodItem.getPrice() + "</td>");

                if (foodItem.getIsPlus() == 1){
                    printWriter.println("<td>Yes</td>");
                }else if(foodItem.getIsPlus() == 2){
                    printWriter.println("<td>No</td>");
                }

                printWriter.println("<td><a href='" + request.getContextPath() +
                        "/retailer/safe/showEditRetailerItemsJSP?editItemID=" + foodItem.getItemID() + "'>Update</a></td>");
                if (foodItem.getIsPlus() == 1){
                    printWriter.println("<td><a href='" + request.getContextPath() +
                            "/retailer/safe/showSurplusItemJSP?surplusItemID=" + foodItem.getItemID() + "'>Surplus</a></td>");
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
