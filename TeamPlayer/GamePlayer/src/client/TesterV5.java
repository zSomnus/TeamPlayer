package client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import bus.BasketballGame;
import bus.BasketballPlayer;
import bus.DiceGame;
import bus.DicePlayer;
import bus.EnumType;
import bus.GamePlayer;
import bus.GuitarGame;
import bus.GuitarPlayer;
import bus.IPlayable;
import bus.Team;
import data.ConnectionDB;

public class TesterV5 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// Check if table Player already exists
		DatabaseMetaData dbm = ConnectionDB.getInstance().getMetaData();
		// System.out.println(dbm.getTables(null, "SYSTEM", "PLAYER", null).next());
		if(dbm.getTables(null, "SYSTEM", "PLAYER", null).next()) {
			System.out.println("Table exist");
			GamePlayer.dropTable(ConnectionDB.getInstance());     
		}
		
		GamePlayer.createTable(ConnectionDB.getInstance());
        Team team = new Team();
        
        ArrayList<IPlayable> iPlayableList = new ArrayList<IPlayable>();
        
        Scanner inputScanner = new Scanner(System.in);
        String playerInput = "";
        
        while(!playerInput.equals("exit"))
        {
            // Introduction of games
            System.out.println("==========================");
            System.out.println("||Your options:         ||");
            System.out.println("||-------------         ||");
            System.out.println("|| 1. Basketball Player ||");
            System.out.println("|| 2. Guitar Player     ||");
            System.out.println("|| 3. Dice Player       ||");
            System.out.println("|| 4. Show All Players  ||");
            System.out.println("==========================");
            System.out.println("**Please choose your player type by enter the number 1, 2, 3 or 4: ");
            System.out.println("*You can also input [exit] to quit this application");
            
            playerInput = inputScanner.nextLine();
            
            try{
                int playerInputToInt = Integer.parseInt(playerInput);
                
                // Switch between different players
                switch(playerInputToInt){
                    
                    // Case that you choose Basketball Player
                    case 1:
                        BasketballGame basketballGame = new BasketballGame();
                        basketballGame.start();
                        basketballGame.run();
                        BasketballPlayer basketballPlayer = new BasketballPlayer(basketballGame.getId(), basketballGame.getName(), EnumType.BasketballPlayer, basketballGame.getBallStack(), basketballGame.getScore(), basketballGame.getMissed());
                        iPlayableList.add(basketballPlayer);
                        team.add((GamePlayer)basketballPlayer);
                        //team.addBasketballPlayer(basketballPlayer);
                                                
                        GamePlayer gamePlayerBasketball = new GamePlayer(basketballGame.getId(), basketballGame.getName(), EnumType.BasketballPlayer, basketballPlayer.countScore());
                        GamePlayer.add(gamePlayerBasketball);
                        
                        basketballGame.end();
                        break;
                    
                    // Case that you choose Guitar Player
                    case 2:
                        // GuitarPlayer(long id, String name, EnumType category, Color color, GuitarBrand brand, String[][] catalog)
                        GuitarGame guitarGame = new GuitarGame();
                        guitarGame.start();
                        guitarGame.run();
                        GuitarPlayer guitarPlayer = new GuitarPlayer(guitarGame.getId(), guitarGame.getName(), EnumType.GuitarPlayer, guitarGame.getColor(), guitarGame.getBrand(), guitarGame.getMI(), guitarGame.getMII());
                        iPlayableList.add(guitarPlayer);
                        team.add((GamePlayer)guitarPlayer);
                        
                        GamePlayer gamePlayerGuitar = new GamePlayer(guitarGame.getId(), guitarGame.getName(), EnumType.GuitarPlayer, guitarPlayer.countScore());
                        GamePlayer.add(gamePlayerGuitar);
                        
                        guitarGame.end();
                        break;
                    
                    // Case that you choose Dice Player
                    case 3:
                        DiceGame diceGame = new DiceGame();
                        diceGame.start();
                        diceGame.run();
                        DicePlayer dicePlayer = new DicePlayer(diceGame.getId(), diceGame.getName(), EnumType.DicePlayer, diceGame.getDice(), diceGame.getPoints());
                        iPlayableList.add(dicePlayer);
                        team.add((GamePlayer)dicePlayer);
                        
                        GamePlayer gamePlayerDice = new GamePlayer(diceGame.getId(), diceGame.getName(), EnumType.DicePlayer, dicePlayer.countScore());
                        GamePlayer.add(gamePlayerDice);
                        
                        diceGame.end();
                        break;
                    
                    case 4:
                        System.out.println("\n\n\nTeam (Size: " + team.getPlayerList().size() + ") --------------------");
                        
                        for(GamePlayer element : team.getPlayerList()){
                            if(element instanceof BasketballPlayer) {
                                System.out.println("+ " + element + " Score: " + ((BasketballPlayer)element).countScore());
                            }
                            else if(element instanceof GuitarPlayer) {
                                System.out.println("+ " + element + " Score: " + ((GuitarPlayer)element).countScore());
                            }
                            else if(element instanceof DicePlayer) {
                                System.out.println("+ " + element + " Score: " + ((DicePlayer)element).countScore());
                            }
                        }
                        // Displayer from serialized file
                        ArrayList<GamePlayer> listFromFile = team.getPlayerList();
                        
                        // Write to Serialized file()
                        FileOutputStream fos = new FileOutputStream("Player.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(listFromFile);
                        
                        FileInputStream fis = new FileInputStream("Player.ser");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        listFromFile = (ArrayList<GamePlayer>) ois.readObject();
                        
                        System.out.println("\n.....Data from file.....");
                        for(GamePlayer record : listFromFile) {
                        	if(record instanceof BasketballPlayer) {
                                System.out.println("+ " + record + " Score: " + ((BasketballPlayer)record).countScore());
                            }
                            else if(record instanceof GuitarPlayer) {
                                System.out.println("+ " + record + " Score: " + ((GuitarPlayer)record).countScore());
                            }
                            else if(record instanceof DicePlayer) {
                                System.out.println("+ " + record + " Score: " + ((DicePlayer)record).countScore());
                            }
                        }
                        
                        // Displayer from hash map
                        System.out.println("\n\n............ Display all students............\n");
        
                        HashMap<Long, GamePlayer> hashMapPlayers = GamePlayer.getList();
        
                        for(GamePlayer aPlayer : hashMapPlayers.values()) 
                        {
                            //System.out.println(  "\nJob ID: " + aStudent.getId() + "\n" + "Job Name: " + aStudent.getName());
                            System.out.print(aPlayer);
                            System.out.println(" [Score: " + aPlayer.getScore() + "]");
                        }

                        System.out.println("------------------------------------\n");
                        
                        oos.close();
                }
            }
            catch(NumberFormatException e){
                if(playerInput.equals("exit")){
                    System.out.println("---------------------");
                    System.out.println("|Thanks for playing!|");
                    System.out.println("---------------------");
                }
                else{
                    System.out.println("Your input is invalid, please try again");
                }
            }
        }

        inputScanner.close();
    }

}
