package service;

import entity.Alert;


/**
 * The AlertService interface provides methods to create, retrieve, update, and list alerts.
 * It serves as a contract for implementing alert management functionality.
 */

public interface AlertService {
       /**
     * Creates a new alert.
     *
     * @param alert The Alert object containing the details of the alert to be created.
     * @return The created Alert object.
     */
    public Alert createAlert(Alert alert);
        /**
     * Retrieves an alert by its ID.
     *
     * @param alertID The ID of the alert to be retrieved.
     * @return The Alert object corresponding to the given ID, or null if not found.
     */
    public Alert getAlertByAlertID(int alertID);
        /**
     * Retrieves all alerts.
     *
     * @param alert The Alert object used as a filter for the search.
     * @return A list of Alert objects that match the given criteria.
     */
    public Alert getAllAlerts(Alert alert);
        /**
     * Updates an existing alert.
     *
     * @param alert The Alert object containing the updated details of the alert.
     * @return The updated Alert object.
     */
    public Alert updateAlert(Alert alert);
}
