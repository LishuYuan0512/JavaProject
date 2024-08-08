package service;

import dao.AlertDAO;
import dao.AlertDAOImpl;
import entity.Alert;
import entity.Charity;
import utils.DbUtil;

/**
 * Implementation of the AlertService interface, providing methods to manage alerts.
 */

public class AlertServiceImpl implements AlertService{
    AlertDAO alertDAO = new AlertDAOImpl();
    
    /**
     * Creates a new alert and commits the transaction.
     *
     * @param alert The Alert object containing the details of the alert to be created.
     * @return The created Alert object.
     * @throws RuntimeException if an error occurs during the creation process.
     */
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
    
       /**
     * Retrieves an alert by its ID.
     *
     * @param alertID The ID of the alert to be retrieved.
     * @return The Alert object corresponding to the given ID, or null if not found.
     * @throws RuntimeException if an error occurs during the retrieval process.
     */

    @Override
    public Alert getAlertByAlertID(int alertID) {
        return null;
    }
    
      /**
     * Retrieves all alerts.
     *
     * @return A list of Alert objects.
     * @throws RuntimeException if an error occurs during the retrieval process.
     */

    @Override
    public Alert getAllAlerts(Alert alert) {
        return null;
    }
    
        /**
     * Updates an existing alert and commits the transaction.
     *
     * @param alert The Alert object containing the updated details of the alert.
     * @return The updated Alert object.
     * @throws RuntimeException if an error occurs during the update process.
     */

    @Override
    public Alert updateAlert(Alert alert) {
        return null;
    }
}
