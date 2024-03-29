package client;

import java.util.*;
import bus.*;

public class TesterV1{
    public static void main(String[] args) {
        
        ArrayList<IPlayable> iPlayableList = new ArrayList<IPlayable>();

        // Basketball player
        Stack<Ball> ballStack = new Stack<Ball>();
        Scanner inputScanner = new Scanner(System.in);
        EnumType playerType;
        String playerInput = "";
        long id;
        String name;

        
        while(!playerInput.equals("exit"))
        {
            // Introduction of games
            System.out.println("Your options: ");
            System.out.println((" 1. Basketball Player \n 2. Guitar Player \n 3. Dice Player \n 4. Show All Players"));
            System.out.println("Please choose your player type by enter the number 1, 2, 3 or 4: ");
            System.out.println("You can also input [exit] to quit this application");
            
            // 
            int score = 0;
            int missed = 0;
            
            float[] ballSizes = {29.5f, 28.5f, 27.5f, 25.5f};
            
            // Guitar player
    
            // Dice player
            int point = 0;

            playerInput = inputScanner.nextLine();
            
            try{
                int playerInputToInt = Integer.parseInt(playerInput);
                // Switch between different players
                switch(playerInputToInt){
        
                    // Case that you choose Basketball Player
                    case 1:
                    BasketballPlayer basketballPlayer = new BasketballPlayer();
                    System.out.println("You choosed Basketball Player");
                    playerType = EnumType.BasketballPlayer;

                    // Inputs of Player information
                    while(true){
                        System.out.println("Please input your ID (numbers only): ");
                        try {
                            id = Long.parseLong(inputScanner.nextLine());
                            break;
                        } catch (NumberFormatException e){
                            System.out.println("Your input is invalid, please try again.");
                        }
                    }
                    System.out.println("Please input your name: ");
                    name = inputScanner.nextLine();
                    
                    while(!playerInput.equals("back")){
                    	
                    	for(int i = 0; i < 10; i++) {
                    		Random randomColor = new Random();
                            Random randomSize = new Random();
                            pushBall(ballStack, Color.values()[randomColor.nextInt(Color.values().length)], ballSizes[randomSize.nextInt(ballSizes.length)]);
                    	}
                    	
                        System.out.println("Input [t] to throw a ball, [p] to pick up a ball or [back] to exit the application");
                        //Scanner playerInputScanner = new Scanner(System.in);
                        playerInput = inputScanner.nextLine();
                        if(playerInput.equals("t")){
                            try {
                                System.out.println("pop ball");
                                popBall(ballStack);
                                Random random = new Random();
                                int probability = random.nextInt(10);
        
                                if(probability > 2){
                                    score++;
                                    basketballPlayer.setBasket(score);
                                    System.out.println("Score: " + basketballPlayer.countScore());
                                }
                                else{
                                    System.out.println("You missed...");
                                }
        
                            } catch (EmptyStackException e) {
                                System.out.println("empty stack, please pick a ball first by input [p]");
                            }
                            
                        }else if(playerInput.equals("p") && ballStack.size() < 10){
                            Random randomColor = new Random();
                            Random randomSize = new Random();
                            pushBall(ballStack, Color.values()[randomColor.nextInt(Color.values().length)], ballSizes[randomSize.nextInt(ballSizes.length)]);
                            System.out.println("push ball");
                        }else if(ballStack.size() >= 10){
                            System.out.println("You can only have no more than 10 balls, throw by input [t] or exit application by input [back]");
                        }
                        else if(playerInput.equals("back")){
                            break;
                        }
                        else{
                            System.out.println("I don't understand...");
                            System.out.println("Input [t] to throw a ball, [p] to pick up a ball or [back] to exit the application");
                            System.out.println(playerInput);
                        }
                    }
                    iPlayableList.add(new BasketballPlayer(id, name, playerType, ballStack, score, missed));
                    break;
        
                    // Case that you choose Guitar Player
                    case 2:
                    System.out.println("You choosed Guitar Player");
                    playerType = EnumType.GuitarPlayer;
                    while(!playerInput.equals("back")){
                        System.out.println("Choose a music by input the index of the music");
                        System.out.println(" 1. Secret Base \n 2. Miracle Mountain");
                        System.out.println("or input [back] to exit the application");
                        playerInput = inputScanner.nextLine();
        
                        if(playerInput.equals("1")){
                            System.out.println("Play \"Secret Base\"");
                        }else if(playerInput.equals("2")){
                            System.out.println("Play \"Miracle Mountain\"");
                        }else if(playerInput.equals("back")){
                            break;
                        }
                        else{
                            System.out.println("I don't understand");
                            System.out.println("Choose a music by input the index of the music");
                            System.out.println(" 1. Secret Base \n 2. Miracle Mountain");
                            System.out.println("or input [back] to exit the application");
                        }
                    }
        
                    break;
        
                    // Case that you choose Dice Player
                    case 3:
                    System.out.println("You choosed Dice Player");
                    playerType = EnumType.DicePlayer;
                    Random randomDice = new Random();
        
                    while(!playerInput.equals("back")){
                        System.out.println("Input [r] to roll the dice, input [back] to exit the application");
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
                    for(IPlayable element : iPlayableList) {
                        if(element instanceof BasketballPlayer) {
                            System.out.println(element + "\tScore: " + element.countScore());
                        }
                        else if(element instanceof GuitarPlayer) {
                            System.out.println(element + "\nPayment: " + element.countScore());
                        }
                        else if(element instanceof DicePlayer) {
                            System.out.println(element + "\nPayment: " + element.countScore());
                        }
                    }
                    
                    /*
                    System.out.println("\n Printing the member list using the polymorphism");
                    for(IPlayable element : iPlayableList) {
                        System.out.println(element + "\tScore: " + " " + element.countScore());
                    }
                    break;

                    // By default, player will use Basketball Player
                    default:
                    System.out.println("I don't understand...");
                    */
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
                                                                                       
    // Basketball player Stack
    static void pushBall(Stack<Ball> stack, Color color, float size) {
        stack.push(new Ball(color, size));
        System.out.println("push( new Ball( " +  color + ", " + size + ")) ");
        System.out.println("stack: " + stack);
    }
    static void popBall(Stack<Ball> stack){
        System.out.print("pop -> ");
        Ball ball = (Ball) stack.pop();
        System.out.println(ball);
        System.out.println("stack: " + stack);
    }

    static int findHighestScore(int highest, int current){
        int highestScore;
        if(current > highest){
            highestScore = current;
        }
        else{
            highestScore = highest;
        }
        return highestScore;
    }
}