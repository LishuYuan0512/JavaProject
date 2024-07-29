package dao;

import entity.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<Customer> selectAllCustomer() {
        try {
            List<Customer> customers = queryRunner.query(DbUtil.getConnection(), "select * from Users;",
                    new BeanListHandler<Customer>(Customer.class));
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int deleteCustomer(String email) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"delete from Users where email = ?;",email);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public int updateCustomer(Customer customer) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),"update Users set username=?,password=?;",
                    customer.getUsername(),customer.getPassword());
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertCustomer(Customer customer) {
        try {
            int result = queryRunner.update(DbUtil.getConnection(),
                    "insert into Users (userName, password, email, phone, userType, locationID) values (?, ?,?,?,?,?);",
                    customer.getUsername(), customer.getPassword(), customer.getEmail(), customer.getPhone(),
                    customer.getUserType(),customer.getLocationID());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer selectCustomerByEmail(String email) {
        try {
            Customer customer = queryRunner.query(DbUtil.getConnection(),"select * from Users where email = ?;",
                    new BeanHandler<Customer>(Customer.class),email);
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getUserIDByEmail(String email) {
        try {
            ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
            Long userID = queryRunner.query(DbUtil.getConnection(),"select userID from Users where email = ?;",
                    scalarHandler,email);
            return userID.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getUserTypeByUserID(Customer customer) {
        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        try {
            String userType = String.valueOf(queryRunner.query(DbUtil.getConnection(),"select userType from Users where userID = ?;",
                    scalarHandler,customer.getUserID()));
            return userType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}



