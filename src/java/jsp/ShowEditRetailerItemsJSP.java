package jsp;

import entity.FoodItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import service.FoodItemService;
import service.FoodItemServiceImpl;

import java.io.IOException;

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

        // Set the food item as a request attribute
        request.setAttribute("foodItem", foodItem);

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editRetailerItem.jsp");
        dispatcher.forward(request, response);
    }
}
