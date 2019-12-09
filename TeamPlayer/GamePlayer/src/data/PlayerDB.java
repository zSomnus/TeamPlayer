package data;
import java.sql.Connection;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import bus.EnumType;
import bus.GamePlayer;

public class PlayerDB {
    public static Exception createTable(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;

        String sqlString = "create table Player(id number primary key not null, name varchar(50), type varchar(16), score int)";

        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static Exception getTableDescription(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "desc Player";

        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception alterTable(int id, Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "alter table Student add constraint pk_id primary key(id)";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static Exception dropTable(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "drop table Player";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static HashMap<Long, GamePlayer> getList() throws SQLException{
        HashMap<Long, GamePlayer> myList = new HashMap<Long, GamePlayer>();

        Connection myConnection = ConnectionDB.getInstance();
        String query = "select * from Player";
        Statement myStatement;
        ResultSet resultSet;

        myStatement = myConnection.createStatement();
        resultSet = myStatement.executeQuery(query);

        String id, name;
        EnumType type = null;
        int score;
        GamePlayer aPlayer;

        while(resultSet.next()){
            id = resultSet.getString(1);
            name = resultSet.getString(2);
            score = resultSet.getInt(4);

            if(resultSet.getString("type").equals("BasketballPlayer")){
                type = EnumType.BasketballPlayer;
            }else if(resultSet.getString("type").equals("GuitarPlayer")){
                type = EnumType.GuitarPlayer;
            }else if(resultSet.getString("type").equals("DicePlayer")){
                type = EnumType.DicePlayer;
            }else {
            	type = EnumType.DicePlayer;
            }

            aPlayer = new GamePlayer(Long.parseLong(id), name, type, score);
            myList.put(((GamePlayer)aPlayer).getId(), aPlayer);
            
        }
        myConnection.close();
        return myList;
    }

    public static int insert(GamePlayer aPlayer) throws SQLException{
        int success = -1;

        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();

        String request = "insert into Player (id, name, type, score)" + "values (" 
        + aPlayer.getId() + "," + "\'"
        + aPlayer.getName() + "\'" + "," + "\'"
        + aPlayer.getCategory() + "\'" + ","
        + aPlayer.getScore()
        + ")";

        success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();

        return success;
    }

    public static int delete(GamePlayer aPlayer) throws SQLException{
        int success = -1;
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();

        String request = "delete from Player where id=" + aPlayer.getId();

        success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static long delete(long key) throws SQLException{
        int success = -1;
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();
        String request = "delete from Player where id=" + key;

        success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();;
        return success;
    }

    public static GamePlayer search(long key) throws SQLException{
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();

        String request = "SELECT * FROM Player WHERE ID = " + key;
        
        ResultSet myResultSet = myStatement.executeQuery(request);
        GamePlayer aPlayer = null;
        EnumType type;
        if(myResultSet.getString("type") == "BasketballPlayer"){
            type = EnumType.BasketballPlayer;
        }else if(myResultSet.getString("type") == "GuitarPlayer"){
            type = EnumType.GuitarPlayer;
        }else if(myResultSet.getString("type") == "DicePlayer"){
            type = EnumType.DicePlayer;
        }else {
        	type = EnumType.BasketballPlayer;
        }

        if(myResultSet.next()){
            aPlayer = new GamePlayer(myResultSet.getLong("id"), myResultSet.getString("name"), type, myResultSet.getInt("score"));
        }
        return aPlayer;
    }

    public static GamePlayer search(String key) throws SQLException{
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();
        String request = "SELECT * FROM Player WHERE name = " + key;

        ResultSet myResultSet = myStatement.executeQuery(request);
        GamePlayer aPlayer = null;

        EnumType type;
        if(myResultSet.getString("type") == "BasketballPlayer"){
            type = EnumType.BasketballPlayer;
        }else if(myResultSet.getString("type") == "GuitarPlayer"){
            type = EnumType.GuitarPlayer;
        }else{
            type = EnumType.DicePlayer;
        }

        if(myResultSet.next()){
            aPlayer = new GamePlayer(myResultSet.getLong("id"), myResultSet.getString("name"), type, myResultSet.getInt("score"));
        }
        return aPlayer;
    }

    public static int update(String value){
        return 0;
    }
}
