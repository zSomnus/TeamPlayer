package bus;

import java.util.*;

public class Team {
	private ArrayList<GamePlayer> playerList;
	private ArrayList<BasketballPlayer> basketBallPlayerList;
	private ArrayList<GuitarPlayer> guitarPlayerList;
	private ArrayList<DicePlayer> dicePlayerList;

	// Constructors
	public Team() {
		this.playerList = new ArrayList<GamePlayer>();
		this.basketBallPlayerList = new ArrayList<BasketballPlayer>();
		this.guitarPlayerList = new ArrayList<GuitarPlayer>();
		this.dicePlayerList = new ArrayList<DicePlayer>();
	}

	public Team(ArrayList<GamePlayer> playerList,ArrayList<BasketballPlayer> basketballPlayers, ArrayList<GuitarPlayer> guitarPlayers, ArrayList<DicePlayer> dicePlayers) {
		this.playerList = playerList;
		this.basketBallPlayerList = basketballPlayers;
		this.guitarPlayerList = guitarPlayers;
		this.dicePlayerList = dicePlayers;
	}

	/** Encapsulation */
	// PlayerList
	public ArrayList<GamePlayer> getPlayerList() {
		return this.playerList;
	}
	public void setPlayerList(ArrayList<GamePlayer> players){
		this.playerList = players;
	}

	// Basketball player list
	public ArrayList<BasketballPlayer> getBasketballPlayerList(){
		return this.basketBallPlayerList;
	}
	public void setBasketballPlayerList(ArrayList<BasketballPlayer> playerList) {
		this.basketBallPlayerList = playerList;
	}

	// Guitar player list
	public ArrayList<GuitarPlayer> getGuitarPlayerList(){
		return this.guitarPlayerList;
	}
	public void setGuitarPlayerList(ArrayList<GuitarPlayer> playerList) {
		this.guitarPlayerList = playerList;
	}

	// Dice player list
	public ArrayList<DicePlayer> getDicePlayerList(){
		return this.dicePlayerList;
	}
	public void setDicePlayerList(ArrayList<DicePlayer> playerList){
		this.dicePlayerList = playerList;
	}

	public void add(GamePlayer player) {
		this.playerList.add(player);
		System.out.println("Player added!");
	}
	public void remove(GamePlayer player) {
		this.playerList.remove(player);
		System.out.println("Player removed!");
	}

	public void addBasketballPlayer(BasketballPlayer player){
		this.basketBallPlayerList.add(player);
	}
	public void removeBasketballPlayer(BasketballPlayer player){
		this.basketBallPlayerList.remove(player);
	}

	public void addGuitarPlayer(GuitarPlayer player){
		this.guitarPlayerList.add(player);
	}
	public void removeGuitarPlaye(GuitarPlayer player){
		this.guitarPlayerList.remove(player);
	}

	public void addDicePlayer(DicePlayer player){
		this.dicePlayerList.add(player);
	}
	public void removeDicePlayer(DicePlayer player){
		this.dicePlayerList.remove(player);
	}
	
	public int getCapacity() {
		return this.playerList.size();
	}
}
