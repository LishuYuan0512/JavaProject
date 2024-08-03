package service;

import entity.Alert;

public interface AlertService {
    public Alert createAlert(Alert alert);
    public Alert getAlertByAlertID(int alertID);
    public Alert getAllAlerts(Alert alert);
    public Alert updateAlert(Alert alert);
}
