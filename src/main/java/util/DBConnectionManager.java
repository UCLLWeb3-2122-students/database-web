package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Creates connection with database, specifically for properties in web.xml and postgresql
 */
public class DBConnectionManager {
    public static Connection connection;
    private static DBConnectionManager dbConnectionManager_instance = null;
    private static Properties properties;
    private static String url;

    private DBConnectionManager(String dbURL) {
        Properties dbProperties = new Properties();
        try {
            Class.forName("util.Secret");  // implementation of abstract class Credentials
            Secret.setPass(dbProperties);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Secret with credentials not found!");
            throw new ConnectionException(e);
        }
        dbProperties.setProperty("ssl", "true");
        dbProperties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        dbProperties.setProperty("sslmode", "prefer");

        properties = dbProperties;
        url = dbURL;

        setConnection();
    }

    public static DBConnectionManager getInstance(String dbURL) {
        if (dbConnectionManager_instance == null) {
            dbConnectionManager_instance = new DBConnectionManager(dbURL);
        }
        return dbConnectionManager_instance;
    }

    /**
     * @return open connection with database
     * when existing connection has been closed: reopens connection
     */
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())
                setConnection();
        } catch (SQLException throwables) {
            throw new ConnectionException(throwables);
        }
        return connection;
    }

    /**
     * Create connection with db
     */
    public static void setConnection() {
        try {
            System.out.print("reconnecting to database ...");
            Class.forName("org.postgresql.Driver");
            System.out.println("url:"+url);
            connection = DriverManager.getConnection(url, properties);
            System.out.println("done");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("connection troubles");
            throw new ConnectionException(e);
        }

    }
}
