package service;

import dao.PurchaseDAO;
import dao.PurchaseDAOImpl;
import entity.Purchase;
import utils.DbUtil;

/**
 * Implementation of the PurchaseService interface, providing methods for purchase operations.
 * This class handles recording new purchases with transaction management.
 */
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseDAO purchaseDAO = new PurchaseDAOImpl();

    /**
     * Records a new purchase in the system.
     * Begins a transaction, inserts the purchase record into the database, and commits the transaction.
     *
     * @param purchase The Purchase object containing the details of the purchase to be recorded.
     * @return An integer indicating the result of the recording operation. Returns 1 if the operation is successful, otherwise 0.
     * @throws RuntimeException if an error occurs during the recording process or if the purchase object contains invalid data.
     */
    @Override
    public int recordPurchase(Purchase purchase) {
        int result = 0;
        try {
            // Begin a transaction
            DbUtil.begin();

            // Insert the purchase record
            result = purchaseDAO.insertPurchaseRecord(purchase);

            // Commit the transaction
            DbUtil.commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            DbUtil.rollback();
            throw new RuntimeException("Error recording purchase: " + e.getMessage(), e);
        }
        return result;
    }
}
