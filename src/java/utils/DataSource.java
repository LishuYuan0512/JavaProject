package utils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.LMSLogger;
import logger.LogLevel;


    /**
     * This class parses database.properties file and connect database.
     */
    public class DataSource {
        private static Connection connection = null;
        private DataSource(){}

        private static String connectionString = "";

        /**
         * This method is to get connection instance using singleton design pattern.
         * @return connection
         * @throws ClassNotFoundException
         */
        public static Connection getConnection() throws ClassNotFoundException{
            String[] connectionInfo = openPropsFile();
            LMSLogger logger = null;
            try {
                logger = LMSLogger.getInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (connection == null) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(connectionInfo[0],
                            connectionInfo[1], connectionInfo[2]);
                    logger.log(LogLevel.TRACE, "Successfully connect to database.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                logger.logException(ex);
            }
            return connection;
        }
        /**
         * This method parses database.properties file and generates database
         * connection URL, userName and password.
         * @return array of connection URL, userName and password
         */
        private static String[] openPropsFile() {
            // added use of Properties and try-with-resources - kriger
            Properties props = new Properties();
            LMSLogger logger = null;
            try {
                logger = LMSLogger.getInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (InputStream in = Files.newInputStream(
                    Paths.get("./data/database.properties"));)
            {
                props.load(in);
                logger.log(LogLevel.TRACE, "Successfully parse the database.properties file.");
            } catch (IOException e) {
                e.printStackTrace();
                logger.logException(e);
            }

            connectionString = "jdbc:"+ props.getProperty("db")+"://"
                    +props.getProperty("host")+":"+props.getProperty("port")+"/"
                    +props.getProperty("name");
            String username = props.getProperty("user");
            String password = props.getProperty("pass");

            String[] info = new String[3];
            info[0] = connectionString;
            info[1] = username;
            info[2] = password;

            return info;
        }



    }


