package service;

/**
 * The PriceTypeService interface provides methods related to price type operations.
 * This includes functionality for retrieving the description of a price type by its ID.
 */
public interface PriceTypeService {

    /**
     * Retrieves the description of a price type based on its ID.
     *
     * @param priceTypeId The ID of the price type to be retrieved.
     * @return A String representing the description of the specified price type.
     * @throws IllegalArgumentException if the priceTypeId is invalid or does not exist.
     */
    public String showPriceType(int priceTypeId);
}
