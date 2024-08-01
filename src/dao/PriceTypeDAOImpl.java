package dao;

import entity.PriceType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;

public class PriceTypeDAOImpl implements PriceTypeDAO{
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public String getPriceTypeBYID(int priceTypeID) {
        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        try {
            String userType = String.valueOf(queryRunner.query(DbUtil.getConnection(),"select priceType from PriceType where priceTypeID = ?;",
                    scalarHandler,priceTypeID));
            return userType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
