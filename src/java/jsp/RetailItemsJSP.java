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
import service.FoodItemService;
import service.FoodItemServiceImpl;
import service.PriceTypeService;
import service.PriceTypeServiceImpl;

@WebServlet(name = "RetailItems", value = "/retailer/safe/showRetailerItemsJSP")
public class RetailItemsJSP extends HttpServlet {
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
        FoodItemService fsService = new FoodItemServiceImpl();

        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"en\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        printWriter.println("<title>Retailer - Food Waste Reduction Platform</title>");
        printWriter.println(" <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        printWriter.println("<link href='" + request.getContextPath() + "/styles.css'rel='stylesheet'>");
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
        printWriter.println("<h2 class='text-center'>Welcome back, "+retailer.getUsername()+"</h2>");
        printWriter.println("<td><a href='" + request.getContextPath() +
                "/retailer/safe/showAddRetailerItemJSP' class='add-new-item' >Add New Items</a></td>");
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
        printWriter.println("<th>Options</th>");
        printWriter.println("<th> </th>");
        printWriter.println("<th>  </th>");


        printWriter.println("</tr>");
        printWriter.println("</thead>");
        printWriter.println("<tbody id='customer-items'>");
            for (FoodItem foodItem : foodItems) {
            int userID = foodItem.getUserID();

            if (retailerDAO.getUserTypeByUserID(retailer).equalsIgnoreCase("Retailer")){
                if (foodItem.isDateWithin7Days(foodItem.getExpirationDate())){
                    foodItem.setIsPlus(1);
                    fsService.updateFoodItemDate(foodItem);
                    System.out.println("========fooditem isplus:"+foodItem.getIsPlus());
                }

                printWriter.println("<tr>");
                printWriter.println("<td>" + foodItem.getItemID() + "</td>");
                printWriter.println("<td>" + foodItem.getItemName() + "</td>");
                printWriter.println("<td>" + foodItem.getQuantity() + "</td>");
                printWriter.println("<td>" + foodItem.getExpirationDate() + "</td>");

                int priceTypeID = foodItem.getPriceTypeID();
                printWriter.println("<td>" + priceTypeService.showPriceType(priceTypeID) + "</td>");
                printWriter.println("<td>" + foodItem.getPrice() + "</td>");

                if (foodItem.getIsPlus() == 1){
                    printWriter.println("<td>Yes</td>");
                }else if(foodItem.getIsPlus()  == 2){
                    printWriter.println("<td>No</td>");
                 } else {
                    printWriter.println("<td></td>"); // Empty cell for consistent alignment
    }

                printWriter.println("<td><a href='" + request.getContextPath() +
                        "/retailer/safe/showEditRetailerItemsJSP?editItemID=" + foodItem.getItemID() + "'class='update'>Update</a></td>");
                if (foodItem.getIsPlus() == 1){
                    printWriter.println("<td><a href='" + request.getContextPath() +
                            "/retailer/safe/showSurplusItemJSP?surplusItemID=" + foodItem.getItemID() + "'class='surplus'>Surplus</a></td>");
                }
                
                if (foodItem.getQuantity() <= 1 ){
                    System.out.println("foodItem.getQuantity() <= 1 ");
                    printWriter.println("<td>Need to restock</td>");
                }

                if (foodItem.isDateWithin7Days(foodItem.getExpirationDate())){
                    printWriter.println("<td>Within 7 days</td>");
                }
                else {
                    printWriter.println("<td></td>"); 
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
        printWriter.println("<div class=\"footer bg-light text-center p-3 mt-4\">");
        printWriter.println("<p>© 2024 Food Waste Reduction Platform. All rights reserved.</p>");
        printWriter.println("</div>");
        printWriter.println("</html>");

    }

}