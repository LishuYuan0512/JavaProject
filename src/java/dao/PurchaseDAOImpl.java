package dao;

import entity.Purchase;
import org.apache.commons.dbutils.QueryRunner;
import utils.DbUtil;

import java.sql.SQLException;


/**
 * Implementation of the PurchaseDAO interface.
 * Provides database operations for Purchase entities using Apache Commons DbUtils.
 */

public class PurchaseDAOImpl implements PurchaseDAO {
    private QueryRunner queryRunner = new QueryRunner();
    
    /**
     * Inserts a new purchase record into the database.
     * @param purchase the Purchase object to insert
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public int insertPurchaseRecord(Purchase purchase) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "insert into Purchase(purchaseTime,userID,itemID,quantity,price,priceTypeID) values (?,?,?,?,?,?);",
                    purchase.getPurchaseTime(),purchase.getUserID(),purchase.getItemID(),purchase.getQuantity(),
                    purchase.getPrice(),purchase.getPriceTypeID() );
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
