package jsp;

import entity.FoodItem;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowEditRetailerItemsJSP", value = "/retailer/safe/showEditRetailerItemsJSP")
public class ShowEditRetailerItemsJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer editItemID = Integer.parseInt(request.getParameter("editItemID"));
            FoodItemService fs = new FoodItemServiceImpl();
            FoodItem foodItem = fs.getFoodItemById(editItemID);

            request.setAttribute("foodItem", foodItem);
            request.getRequestDispatcher("/editRetailerItem.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid item ID.");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }
}