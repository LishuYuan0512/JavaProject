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

public class AlertDAOImpl implements AlertDAO{
    private QueryRunner queryRunner = new QueryRunner();
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
