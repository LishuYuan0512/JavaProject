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

public class RetailerDAOImpl implements RetailerDAO{
    private QueryRunner queryRunner = new QueryRunner();

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

    @Override
    public int deleteRetailer(int retailerID) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"delete","delete from Users where email=?;",retailerID);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
