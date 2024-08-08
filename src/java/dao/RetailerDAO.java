package dao;

import entity.Customer;
import entity.Retailer;

import java.util.List;

/**
 * Interface for Retailer Data Access Object (DAO).
 * Provides methods for CRUD operations on Retailer entities.
 */

public interface RetailerDAO {
    
       /**
     * Selects all retailers from the database.
     * @return a list of all Retailer objects in the database
     */
    public List<Retailer> selectAllRetailers();
       /**
     * Deletes a retailer from the database by their ID.
     * @param retailerID the ID of the retailer to delete
     * @return the number of rows affected
     */
    public int deleteRetailer(int retailerID);
        /**
     * Inserts a new retailer into the database.
     * @param retailer the Retailer object to insert
     * @return the number of rows affected
     */
    public int insertRetailer(Retailer retailer);
       /**
     * Retrieves the retailer ID for a retailer based on their email.
     * @param email the email of the retailer
     * @return the retailer ID of the retailer
     */
    public int getRetailerIDByEmail(String email);
       /**
     * Selects a retailer from the database by email.
     * @param email the email of the retailer to select
     * @return the Retailer object with the specified email, or null if not found
     */
    public Retailer selectRetailerByEmail(String email);
    
    /**
     * Retrieves the user type for a retailer based on their user ID.
     * @param retailer the Retailer object
     * @return the user type of the retailer
     */
    public String getUserTypeByUserID(Retailer retailer);
}
