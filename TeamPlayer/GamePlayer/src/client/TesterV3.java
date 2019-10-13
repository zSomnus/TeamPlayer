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
                        guitarGame.end();
                        break;
                    
                    // Case that you choose Dice Player
                    case 3:
                        DiceGame diceGame = new DiceGame();
                        diceGame.start();
                        diceGame.run();
                        DicePlayer dicePlayer = new DicePlayer(diceGame.getId(), diceGame.getName(), EnumType.DicePlayer, diceGame.getDiceType(), diceGame.getPoints());
                        iPlayableList.add(dicePlayer);
                        team.add(dicePlayer);
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
                        System.out.println("------------------------------------\n");
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
        
        // System.out.println("\n\n\nTeam--------------------");
        // System.out.println("Gameplayer team size: " + team.getPlayerList().size());
        
        // for(GamePlayer element : team.getPlayerList()){
        //     if(element instanceof BasketballPlayer) {
        //         System.out.println(element + " Score: " + ((BasketballPlayer)element).countScore());
        //     }
        //     else if(element instanceof GuitarPlayer) {
        //         System.out.println(element + " Score: " + ((GuitarPlayer)element).countScore());
        //     }
        //     else if(element instanceof DicePlayer) {
        //         System.out.println(element + " Score: " + ((DicePlayer)element).countScore());
        //     }
        // }
        // System.out.println("------------------------------------");

        // for(BasketballPlayer element : team.getBasketballPlayerList()){
        //     System.out.println(element + " Score: " + element.countScore());
        // }
        // for(GuitarPlayer element : team.getGuitarPlayerList()){
        //     System.out.println(element + " Score: " + element.countScore());
        // }
        // for(DicePlayer element : team.getDicePlayerList()){
        //     System.out.println(element + " Score: " + element.countScore());
        // }

        inputScanner.close();
    }
}