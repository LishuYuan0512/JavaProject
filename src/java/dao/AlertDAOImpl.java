package dao;

import entity.Alert;
import entity.Customer;
import entity.FoodItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the AlertDAO interface.
 * Provides database operations for Alert entities using Apache Commons DbUtils.
 */

public class AlertDAOImpl implements AlertDAO{
    private QueryRunner queryRunner = new QueryRunner();
    
    /**
     * Inserts a new alert into the database.
     * @param alert the Alert object to insert
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public int insertAlert(Alert alert) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "insert into Alert (userID, itemID, alertTypeID, alertTime, email, phone) values (?, ?,?,?,?,?);",
                   alert.getAlertID(),alert.getItemID(),alert.getAlertTypeID(),alert.getAlertTime(),alert.getEmail(),alert.getPhone());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Updates an existing alert in the database.
     * @param alert the Alert object with updated information
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int updateAlert(Alert alert) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"update Alert set userID=?,itemID=?,alertType=?,alertTime=? where alertID =?;",
                    alert.getUserID(),alert.getItemID(),alert.getAlertTypeID(),alert.getAlertTime(),alert.getAlertID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
     /**
     * Deletes an alert from the database.
     * @param alert the Alert object to delete
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int deleteAlert(Alert alert) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"delete from Alert where alertID =?;",
                    alert.getAlertID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Selects an alert from the database by its ID.
     * @param alertID the ID of the alert to select
     * @return the Alert object with the specified ID, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public Alert selectAlertByID(int alertID) {
        try {
            Alert alert = queryRunner.query(DbUtil.getConnection(),"select * from Alert where alertID =?;",
                    new BeanHandler<Alert>(Alert.class),alertID);
            return alert;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Selects all alerts from the database.
     * @return a list of all Alert objects in the database
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public List<Alert> selectAllAlerts() {
        try {
            List<Alert> alerts = queryRunner.query(DbUtil.getConnection(), "select * from Alert ;",
                    new BeanListHandler<Alert>(Alert.class));
            return alerts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
