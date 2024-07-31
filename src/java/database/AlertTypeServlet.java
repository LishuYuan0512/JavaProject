/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import alertType.AlertType;
import alertType.AlertTypeBusinessLogic;
import alertType.AlertTypeDAOImp;
import alertType.AlertTypeDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rosal
 */
public class AlertTypeServlet {
     private AlertTypeBusinessLogic alertTypeBusinessLogic;

    public void init() throws ServletException {
        Connection connection = DataSource.getInstance().getConnection();
        AlertTypeDao alertTypeDao = new AlertTypeDAOImp(connection);
        alertTypeBusinessLogic = new AlertTypeBusinessLogic(alertTypeDao);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("get".equals(action)) {
                int alertTypeID = Integer.parseInt(request.getParameter("id"));
                AlertType alertType = alertTypeBusinessLogic.getAlertType(alertTypeID);
                request.setAttribute("alertType", alertType);
                request.getRequestDispatcher("/alertTypeDetail.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("create".equals(action)) {
                int alertTypeID = Integer.parseInt(request.getParameter("alertTypeID"));
                String alertTypeName = request.getParameter("alertTypeName");

                AlertType alertType = new AlertType(alertTypeID, alertTypeName);
                alertTypeBusinessLogic.addAlertType(alertType);
            }
            response.sendRedirect("alertType?action=get&id=" + request.getParameter("alertTypeID"));
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}