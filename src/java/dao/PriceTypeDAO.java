package dao;

import entity.PriceType;

/**
 * Interface for PriceType Data Access Object (DAO).
 * Provides methods for operations on PriceType entities.
 */

public interface PriceTypeDAO {
    
      /**
     * Retrieves the price type description by its ID.
     * @param priceTypeID the ID of the price type
     * @return the description of the price type, or null if not found
     */
    public String getPriceTypeBYID(int priceTypeID);
}
