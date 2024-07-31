package database;

import alert.Alert;
import alert.AlertBusinessLogic;
import alert.AlertDAOImp;
import alert.AlertDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rosal
 */
@WebServlet("/alert")
public class AlertServlet extends HttpServlet {
    private AlertBusinessLogic alertBusinessLogic;

    @Override
    public void init() throws ServletException {
        Connection connection = DataSource.getInstance().getConnection();
        AlertDao alertDao = new AlertDAOImp(connection);
        alertBusinessLogic = new AlertBusinessLogic(alertDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Alert> alerts = null;
            try {
                alerts = alertBusinessLogic.getAllAlerts();
            } catch (SQLException ex) {
                Logger.getLogger(AlertServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("alerts", alerts);
            request.getRequestDispatcher("/alertList.jsp").forward(request, response);
        } else {
            int alertID = Integer.parseInt(request.getParameter("id"));
            Alert alert = null;
            try {
                alert = alertBusinessLogic.getAlert(alertID);
            } catch (SQLException ex) {
                Logger.getLogger(AlertServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("/alertDetail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (null != action) switch (action) {
            case "create" -> {
                int userID = Integer.parseInt(request.getParameter("userID"));
                int itemID = Integer.parseInt(request.getParameter("itemID"));
                int alertTypeID = Integer.parseInt(request.getParameter("alertTypeID"));
                Timestamp alertTime = Timestamp.valueOf(request.getParameter("alertTime"));
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                Alert alert = new Alert(0, userID, itemID, alertTypeID, alertTime, email, phone);
            try {
                alertBusinessLogic.addAlert(alert);
            } catch (SQLException ex) {
                Logger.getLogger(AlertServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            case "update" -> {
                int alertID = Integer.parseInt(request.getParameter("alertID"));
                int userID = Integer.parseInt(request.getParameter("userID"));
                int itemID = Integer.parseInt(request.getParameter("itemID"));
                int alertTypeID = Integer.parseInt(request.getParameter("alertTypeID"));
                Timestamp alertTime = Timestamp.valueOf(request.getParameter("alertTime"));
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                Alert alert = new Alert(alertID, userID, itemID, alertTypeID, alertTime, email, phone);
            try {
                alertBusinessLogic.updateAlert(alert);
            } catch (SQLException ex) {
                Logger.getLogger(AlertServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            case "delete" -> {
                int alertID = Integer.parseInt(request.getParameter("alertID"));
            try {
                alertBusinessLogic.deleteAlert(alertID);
            } catch (SQLException ex) {
                Logger.getLogger(AlertServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            default -> {
            }
        }
        response.sendRedirect("alert?action=list");
    }
}


