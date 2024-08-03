package service;

import dao.AlertDAO;
import dao.AlertDAOImpl;
import entity.Alert;
import entity.Charity;
import utils.DbUtil;

public class AlertServiceImpl implements AlertService{
    AlertDAO alertDAO = new AlertDAOImpl();
    @Override
    public Alert createAlert(Alert alert) {
        Charity charity = null;
        try {
            DbUtil.begin();

            DbUtil.commit();

        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Alert getAlertByAlertID(int alertID) {
        return null;
    }

    @Override
    public Alert getAllAlerts(Alert alert) {
        return null;
    }

    @Override
    public Alert updateAlert(Alert alert) {
        return null;
    }
}
