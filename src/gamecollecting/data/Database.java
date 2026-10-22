
package gamecollecting.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        try (FileInputStream input =
                new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new SQLException(
                "Could not load config.properties. Check that the file exists.",
                e
            );
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        if (url == null || user == null || password == null) {
            throw new SQLException(
                "Database configuration is incomplete."
            );
        }

        return DriverManager.getConnection(url, user, password);
    }
}
