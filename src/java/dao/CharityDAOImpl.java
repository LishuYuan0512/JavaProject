package dao;

import entity.Charity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DbUtil;

import java.sql.SQLException;

public class CharityDAOImpl implements CharityDAO{
    private QueryRunner queryRunner = new QueryRunner();
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
