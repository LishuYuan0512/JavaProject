package alert;

import alert.Alert;
import alert.AlertDao;
import java.sql.SQLException;
import java.util.List;

public class AlertBusinessLogic {
    private final AlertDao alertDao;

    public AlertBusinessLogic(AlertDao alertDao) {
        this.alertDao = alertDao;
    }

    public void addAlert(Alert alert) throws SQLException {
        alertDao.addAlert(alert);
    }

    public Alert getAlert(int alertID) throws SQLException {
        return alertDao.getAlert(alertID);
    }

    public List<Alert> getAllAlerts() throws SQLException {
        return alertDao.getAllAlerts();
    }

    public void updateAlert(Alert alert) throws SQLException {
        alertDao.updateAlert(alert);
    }

    public void deleteAlert(int alertID) throws SQLException {
        alertDao.deleteAlert(alertID);
    }
}

