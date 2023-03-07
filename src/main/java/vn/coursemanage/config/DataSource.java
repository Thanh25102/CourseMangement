package vn.coursemanage.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.dao.BaseDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static final Logger LOGGER = LogManager.getLogger(DataSource.class);
    private static HikariConfig config = new HikariConfig(getProperties());
    private static HikariDataSource ds = new HikariDataSource(config);
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            LOGGER.error("Can not establish connection with information in datasource.properties file to database");
            return null;
        }
    }
    public static Properties getProperties()   {
        try (InputStream input = DataSource.class.getClassLoader().getResourceAsStream("datasource.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            return prop;
        }catch (IOException e){
            LOGGER.error("Can not load datasource.properties file");
            return null;
        }
    }
}
