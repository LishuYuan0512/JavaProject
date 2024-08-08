package service;

import entity.Purchase;

/**
 * The PurchaseService interface provides methods related to purchase operations.
 * This includes functionality for recording a new purchase.
 */
public interface PurchaseService {

    /**
     * Records a new purchase in the system.
     *
     * @param purchase The Purchase object containing the details of the purchase to be recorded.
     * @return An integer indicating the result of the recording operation, such as the number of records updated or inserted.
     * @throws IllegalArgumentException if the purchase object is null or contains invalid data.
     */
    public int recordPurchase(Purchase purchase);
}
