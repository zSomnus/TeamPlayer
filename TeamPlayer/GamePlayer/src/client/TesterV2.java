package client;

import bus.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.Locale.Category;

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
            
            // Dice player parameter
            int point = 0;

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
                System.out.println("You choosed Dice Player");
                Random randomDice = new Random();
    
                while(!playerInput.equals("back")){
                    System.out.println("Input [r] to roll the dice, input [back] to back to the Main Menu.");
                    playerInput = inputScanner.nextLine();
                    if(playerInput.equals("r")){
                        point = randomDice.nextInt(6);
                        System.out.println("You got: " + (point + 1));
                        
                    }else if(playerInput.equals("back")){
                        break;
                    }
                    else{
                        System.out.println("I don't understand...");
                    }
                }
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
    }
}