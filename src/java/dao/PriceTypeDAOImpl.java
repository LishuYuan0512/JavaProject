package dao;

import entity.PriceType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;

/**
 * Implementation of the PriceTypeDAO interface.
 * Provides database operations for PriceType entities using Apache Commons DbUtils.
 */

public class PriceTypeDAOImpl implements PriceTypeDAO{
    QueryRunner queryRunner = new QueryRunner();
    
        /**
     * Retrieves the price type description by its ID.
     * @param priceTypeID the ID of the price type
     * @return the description of the price type, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public String getPriceTypeBYID(int priceTypeID) {
        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        try {
            String userType = String.valueOf(queryRunner.query(DbUtil.getConnection(),"select priceType from PriceType2 where priceTypeID = ?;",
                    scalarHandler,priceTypeID));
            return userType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
