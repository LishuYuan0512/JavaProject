package utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class DbUtil {
    private static DruidDataSource ds;
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
    static {
        Properties prop = new Properties();
        InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("/database2.properties");
        try {
            prop.load(is);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection conn = THREAD_LOCAL.get();
        try {
            if (conn == null){
                conn = ds.getConnection();
                THREAD_LOCAL.set(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void begin(){
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void commit(){
        Connection conn = null;
        try {
            conn = getConnection();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeAll(conn,null,null);
        }
    }

    public static void rollback(){
        Connection conn = null;
        try {
            conn = getConnection();
            conn.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeAll(conn,null,null);
        }
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
