package client;

import java.util.*;
import bus.*;

public class TesterV3{
    public static void main(String[] args) {
        
        Team team = new Team();
        
        ArrayList<IPlayable> iPlayableList = new ArrayList<IPlayable>();
        
        Scanner inputScanner = new Scanner(System.in);
        String playerInput = "";
        
        while(!playerInput.equals("exit"))
        {
            // Introduction of games
            System.out.println("Your options: ");
            System.out.println((" 1. Basketball Player \n 2. Guitar Player \n 3. Dice Player \n 4. Show All Players"));
            System.out.println("Please choose your player type by enter the number 1, 2, 3 or 4: ");
            System.out.println("You can also input [exit] to quit this application");
            
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
                    team.addBasketballPlayer(basketballPlayer);
                    basketballGame.end();
                    break;
                    
                    // Case that you choose Guitar Player
                    case 2:
                    // GuitarPlayer(long id, String name, EnumType category, Color color, GuitarBrand brand, String[][] catalog)
                	GuitarGame guitarGame = new GuitarGame();
                	guitarGame.start();
                	guitarGame.run();
                	iPlayableList.add(new GuitarPlayer(guitarGame.getId(), guitarGame.getName(), EnumType.GuitarPlayer, guitarGame.getColor(), guitarGame.getBrand(), guitarGame.getMI(), guitarGame.getMII()));
                	guitarGame.end();
                	break;
                    
                    // Case that you choose Dice Player
                    case 3:
                    DiceGame diceGame = new DiceGame();
                    diceGame.start();
                    diceGame.run();
                    diceGame.end();
                    break;
                    
                    case 4:
                	System.out.println("Players: \n");
                    for(IPlayable element : iPlayableList) {
                        System.out.println(element + " Score: " + element.countScore());
                    	/*
                        if(element instanceof BasketballPlayer) {
                            System.out.println(element + " Score: " + element.countScore());
                        }
                        else if(element instanceof GuitarPlayer) {
                            System.out.println(element + " Score: " + element.countScore());
                        }
                        else if(element instanceof DicePlayer) {
                            System.out.println(element + " Score: " + element.countScore());
                        }
                        */
                    }
                    System.out.println("\nType [back] to back to the Main Menu.");
                }
            }
            catch(NumberFormatException e){
                if(playerInput.equals("exit")){
                    System.out.println("Thanks for playing!");
                }
                else{
                    System.out.println("Your input is invalid, please try again");
                }
            }
        }
        
        System.out.println("\n\n\nTeam--------------------");
        System.out.println("Size: " + team.getCapacity());
        System.out.println("Gameplayer team size: " + team.getPlayerList().size());
        System.out.println("Basketball team size: " + team.getBasketballPlayerList().size());
        
        for(GamePlayer element : team.getPlayerList()){
            System.out.println(element);
        }
        for(BasketballPlayer element : team.getBasketballPlayerList()){
            System.out.println(element);
        }
        for(GuitarPlayer element : team.getGuitarPlayerList()){
            System.out.println(element);
        }
        for(DicePlayer element : team.getDicePlayerList()){
            System.out.println(element);
        }

        inputScanner.close();
    }
}