package bus;
import java.util.ArrayList;

public class Team {
	private ArrayList<GamePlayer> playerList;
	
	public Team() {
		this.playerList = new ArrayList<GamePlayer>();
	}
	public Team(ArrayList<GamePlayer> playerList){
		this.playerList = playerList;
	}
	
	public ArrayList<GamePlayer> getPlayerList(){
		return this.playerList;
	}
	public void setBasketballPlayerList(ArrayList<GamePlayer> playerList){
		this.playerList = playerList;
	}
	
	public void add(GamePlayer player) {
		this.playerList.add(player);
	}
	public void remove(GamePlayer player) {
		this.playerList.remove(player);
	}
	
	public int getCapacity() {
		return this.playerList.size();
	}
}
