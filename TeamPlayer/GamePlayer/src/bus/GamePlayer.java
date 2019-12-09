package bus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import data.PlayerDB;

public class GamePlayer {	
	private long id;
	private String name;
	private EnumType category;
	private int score;

	public GamePlayer() {
		this.id = 1234567890;
		this.name = "Ella";
		this.category = EnumType.BasketballPlayer;
		this.score = 0;
	}

	public GamePlayer(long id, String name, EnumType category){
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public GamePlayer(long id, String name, EnumType category, int score){
		this.id = id;
		this.name = name;
		this.category = category;
		this.score = score;
	}

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public EnumType getCategory(){
		return this.category;
	}
	public void setCategory(EnumType category){
		this.category = category;
	}
	
	public int getScore(){
		return this.score;
	}
	public void setScore(int score){
		this.score = score;
	}
	
	@Override
	public String toString(){
		return "[ID: " + this.id + "]" + " [Name: " + this.name + "]" + " [Category: " + this.category + "]";
	}

	public static HashMap<Long, GamePlayer> getList() throws SQLException{
		return PlayerDB.getList();
	}

	public static long add(GamePlayer aPlayer) throws SQLException{
		return PlayerDB.insert(aPlayer);
	}

	public static long remove(int key) throws SQLException{
		return PlayerDB.delete(key);
	}
	public static int remove(GamePlayer aPlayer) throws SQLException{
		return PlayerDB.delete(aPlayer);
	}
	
	public static GamePlayer search(int key) throws SQLException{
		return PlayerDB.search(key);
	}
	public static GamePlayer search(String key) throws SQLException{
		return PlayerDB.search(key);
	}
	
	public static int modify(String value){
		return PlayerDB.update(value);
	}

	public static Exception createTable(Connection myConnection) throws SQLException{
		return PlayerDB.createTable(myConnection);
	}
	
	public static Exception dropTable(Connection myConnection) throws SQLException{
		return PlayerDB.dropTable(myConnection);
	}

}
