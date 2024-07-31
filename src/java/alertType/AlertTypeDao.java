/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alertType;



import java.sql.SQLException;

public interface AlertTypeDao {
    void addAlertType(AlertType alertType) throws SQLException;
    AlertType getAlertType(int alertTypeID) throws SQLException;
}
