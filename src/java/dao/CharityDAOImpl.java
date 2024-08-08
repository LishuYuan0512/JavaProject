package dao;

import entity.Charity;
import entity.Retailer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DbUtil;

import java.sql.SQLException;
/**
 * Implementation of the CharityDAO interface.
 * Provides database operations for Charity entities using Apache Commons DbUtils.
 */

public class CharityDAOImpl implements CharityDAO{
    private QueryRunner queryRunner = new QueryRunner();
    
    /**
     * Inserts a new charity into the database.
     * @param charity the Charity object to insert
     * @return the number of rows affected
     * @throws RuntimeException if a SQLException occurs
     */
    @Override
    public int insertCharity(Charity charity) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "insert into Charity (userName, password, email, phone, userType, locationID) values (?, ?,?,?,?,?);",
                    charity.getUsername(), charity.getPassword(), charity.getEmail(), charity.getPhone(),
                    charity.getUserType(),charity.getLocationID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        /**
     * Selects a charity from the database by its email.
     * @param email the email of the charity to select
     * @return the Charity object with the specified email, or null if not found
     * @throws RuntimeException if a SQLException occurs
     */

    @Override
    public Charity selectCharityByEmail(String email) {
        try {
            Charity charity = queryRunner.query(DbUtil.getConnection(),"select * from Charity where email = ?;",
                    new BeanHandler<Charity>(Charity.class),email);
            return charity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
