/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alertType;

import java.sql.SQLException;
/**
 *
 * @author rosal
 */
public class AlertTypeBusinessLogic {
    private final AlertTypeDao alertTypeDao;

    public AlertTypeBusinessLogic(AlertTypeDao alertTypeDao) {
        this.alertTypeDao = alertTypeDao;
    }

    public void addAlertType(AlertType alertType) throws SQLException {
        alertTypeDao.addAlertType(alertType);
    }

    public AlertType getAlertType(int alertTypeID) throws SQLException {
        return alertTypeDao.getAlertType(alertTypeID);
    }
}