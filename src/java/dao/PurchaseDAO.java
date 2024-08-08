package dao;

import entity.Purchase;

/**
 * Interface for Purchase Data Access Object (DAO).
 * Provides methods for operations on Purchase entities.
 */

public interface PurchaseDAO {
       /**
     * Inserts a new purchase record into the database.
     * @param purchase the Purchase object to insert
     * @return the number of rows affected
     */
    public int insertPurchaseRecord(Purchase purchase);

}
