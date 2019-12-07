package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection getInstance() throws SQLException{
        Connection myConnection;

        String username = "system";
        String password = "123";
        String service = "localhost";
        String url = "jdbc:oracle:thin";

        myConnection = DriverManager.getConnection(url + username + '/' + password + '@' + service);

        return myConnection;
    }

}
