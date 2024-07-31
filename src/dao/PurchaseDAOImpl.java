package dao;

import entity.Purchase;
import org.apache.commons.dbutils.QueryRunner;
import utils.DbUtil;

import java.sql.SQLException;

public class PurchaseDAOImpl implements PurchaseDAO {
    private QueryRunner queryRunner = new QueryRunner();
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
