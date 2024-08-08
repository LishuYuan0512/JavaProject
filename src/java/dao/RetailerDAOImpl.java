package dao;

import entity.Customer;
import entity.Retailer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the RetailerDAO interface.
 * Provides database operations for Retailer entities using Apache Commons DbUtils.
 */

public class RetailerDAOImpl implements RetailerDAO{
    private QueryRunner queryRunner = new QueryRunner();
    
        /**
     * Selects all retailers from the database.
     * @return a list of all Retailer objects in the database
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public List<Retailer> selectAllRetailers() {
        try {
            List<Retailer> retailers = queryRunner.query(DbUtil.getConnection(),
                    "select * from Users where userType = 'Retailer';", new BeanListHandler<Retailer>(Retailer.class));
            return retailers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Deletes a retailer from the database by their ID.
     * @param retailerID the ID of the retailer to delete
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int deleteRetailer(int retailerID) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"delete","delete from Users where email=?;",retailerID);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Inserts a new retailer into the database.
     * @param retailer the Retailer object to insert
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int insertRetailer(Retailer retailer) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "insert into Retailer (userName, password, email, phone, userType, locationID) values (?, ?,?,?,?,?);",
                    retailer.getUsername(), retailer.getPassword(), retailer.getEmail(), retailer.getPhone(),
                    retailer.getUserType(),retailer.getLocationID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        /**
     * Retrieves the retailer ID for a retailer based on their email.
     * @param email the email of the retailer
     * @return the retailer ID of the retailer
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public int getRetailerIDByEmail(String email) {
        try {
            ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
            Long userID = queryRunner.query(DbUtil.getConnection(),"select userID from Retailer where email = ?;",
                    scalarHandler,email);
            return userID.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        /**
     * Selects a retailer from the database by email.
     * @param email the email of the retailer to select
     * @return the Retailer object with the specified email, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public Retailer selectRetailerByEmail(String email) {
        try {
            Retailer retailer = queryRunner.query(DbUtil.getConnection(),"select * from Retailer where email = ?;",
                    new BeanHandler<Retailer>(Retailer.class),email);
            return retailer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
       /**
     * Retrieves the user type for a retailer based on their user ID.
     * @param retailer the Retailer object
     * @return the user type of the retailer
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public String getUserTypeByUserID(Retailer retailer) {
        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        try {
            String userType = String.valueOf(queryRunner.query(DbUtil.getConnection(),"select userType from Retailer where userID = ?;",
                    scalarHandler,retailer.getUserID()));
            return userType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
