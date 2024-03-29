package client;

import bus.*;
import java.util.*;

public class TesterV2{
    public static void main(String[] args) {
        
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
                    basketballGame.end();
                    iPlayableList.add(new BasketballPlayer(basketballGame.getId(), basketballGame.getName(), EnumType.BasketballPlayer, basketballGame.getBallStack(), basketballGame.getScore(), basketballGame.getMissed()));
                    break;
    
                // Case that you choose Guitar Player
                case 2:
                // GuitarPlayer(long id, String name, EnumType category, Color color, GuitarBrand brand, String[][] catalog)
                	GuitarGame guitarGame = new GuitarGame();
                	guitarGame.start();
                	guitarGame.run();
                	guitarGame.end();
                	iPlayableList.add(new GuitarPlayer(guitarGame.getId(), guitarGame.getName(), EnumType.GuitarPlayer, guitarGame.getColor(), guitarGame.getBrand(), guitarGame.getMI(), guitarGame.getMII()));
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
        inputScanner.close();
    }
}