package dao;

import entity.Alert;

import java.util.List;

public interface AlertDAO {
    public int insertAlert(Alert alert);
    public int updateAlert(Alert alert);
    public int deleteAlert(Alert alert);
    public Alert selectAlertByID(int alertID);
    public List<Alert> selectAllAlerts();
}
