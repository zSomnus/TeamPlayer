package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import bus.EnumType;
import bus.GamePlayer;

public class PlayerDB {
    public static Exception createTable(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;

        String sqlString = "create table Player(id number primary key not null, name varchar(50), type varchar(15));";

        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static Exception getTableDescription(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "desc Player;";

        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception alterTable(int id, Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "alter table Student add constraint pk_id primary key(id);";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static Exception dropTable(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "drop table Player;";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static HashMap<Integer, GamePlayer> getList() throws SQLException{
        HashMap<Integer, GamePlayer> myList = new HashMap<Integer, GamePlayer>();

        Connection myConnection = ConnectionDB.getInstance();
        String query = "select * from Player";
        Statement myStatement;
        ResultSet resultSet;

        myStatement = myConnection.createStatement();
        resultSet = myStatement.executeQuery(query);

        String id, name;
        EnumType type;
        GamePlayer aPlayer;

        while(resultSet.next()){
            id = resultSet.getString(1);
            name = resultSet.getString(2);
            type = resultSet.getString("type") == ""
        }
    }
}
