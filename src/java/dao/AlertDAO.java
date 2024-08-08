package dao;

import entity.Alert;

import java.util.List;

/**
 * Interface for Alert Data Access Object (DAO).
 * Provides methods for CRUD operations on Alert entities.
 */

public interface AlertDAO {
    
    /**
     * Inserts a new alert into the database.
     * @param alert the Alert object to insert
     * @return the number of rows affected
     */
    public int insertAlert(Alert alert);
    
       /**
     * Updates an existing alert in the database.
     * @param alert the Alert object with updated information
     * @return the number of rows affected
     */
    public int updateAlert(Alert alert);
     /**
     * Deletes an alert from the database.
     * @param alert the Alert object to delete
     * @return the number of rows affected
     */
    public int deleteAlert(Alert alert);
     /**
     * Selects an alert from the database by its ID.
     * @param alertID the ID of the alert to select
     * @return the Alert object with the specified ID, or null if not found
     */
    public Alert selectAlertByID(int alertID);
       /**
     * Selects all alerts from the database.
     * @return a list of all Alert objects in the database
     */
    public List<Alert> selectAllAlerts();
}
