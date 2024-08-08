package dao;

import entity.Charity;
import entity.Retailer;

/**
 * Interface for Charity Data Access Object (DAO).
 * Provides methods for operations on Charity entities.
 */

public interface CharityDAO {
    
       /**
     * Inserts a new charity into the database.
     * @param charity the Charity object to insert
     * @return the number of rows affected
     */
    public int insertCharity(Charity charity);
    
      /**
     * Selects a charity from the database by its email.
     * @param email the email of the charity to select
     * @return the Charity object with the specified email, or null if not found
     */
    public Charity selectCharityByEmail(String email);
}
