package service;

import dao.PriceTypeDAO;
import dao.PriceTypeDAOImpl;
import utils.DbUtil;

/**
 * Implementation of the PriceTypeService interface, providing methods for price type operations.
 * This class handles retrieving the description of a price type by its ID with transaction management.
 */
public class PriceTypeServiceImpl implements PriceTypeService {

    private final PriceTypeDAO priceTypeDAO = new PriceTypeDAOImpl();

    /**
     * Retrieves the description of a price type based on its ID.
     * Begins a transaction, retrieves the price type from the database, and commits the transaction.
     *
     * @param priceTypeId The ID of the price type to be retrieved.
     * @return A String representing the description of the specified price type.
     * @throws RuntimeException if an error occurs during the retrieval process or if the priceTypeId is invalid.
     */
    @Override
    public String showPriceType(int priceTypeId) {
        try {
            // Begin a transaction
            DbUtil.begin();

            // Retrieve the price type by ID
            String priceType = priceTypeDAO.getPriceTypeBYID(priceTypeId);

            // Commit the transaction
            DbUtil.commit();

            return priceType;
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            DbUtil.rollback();
            throw new RuntimeException("Error retrieving price type: " + e.getMessage(), e);
        }
    }
}
