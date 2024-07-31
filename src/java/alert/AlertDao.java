
package alert;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rosal
 */

public interface AlertDao {
    void addAlert(Alert alert) throws SQLException;
    Alert getAlert(int alertID) throws SQLException;
    List<Alert> getAllAlerts() throws SQLException;
    void updateAlert(Alert alert) throws SQLException;
    void deleteAlert(int alertID) throws SQLException;
}
