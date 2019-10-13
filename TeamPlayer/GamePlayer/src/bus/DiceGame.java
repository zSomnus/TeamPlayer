package bus;

import java.util.*;

public class DiceGame {
	
	private DicePlayer player = new DicePlayer();
	private long id;
	private String name;
	private Scanner inputScanner = new Scanner(System.in);
	private DiceType type;
	private String playerInput;
	private int point;
	private int maxPoint;
	private int totalPoints;

	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public DiceType getDiceType(){
		return this.type;
	}
	public int getPoints(){
		return this.totalPoints;
	}

	public DiceGame() {
		this.id = 0;
		this.name = "";
		this.type = DiceType.Undefind;
	}
	
	public void start() {
		System.out.println("You choosed Dice Player");
		
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
	}
	
	public void run() {
		Random randomDice = new Random();
		type = DiceType.values()[randomDice.nextInt(DiceType.values().length - 1)];
		System.out.println("You got a " + type + " Dice. \n");

		switch(type){
			case D4:
				maxPoint = 4;
				System.out.println("Point: " + 4);
				break;

			case D6:
				maxPoint = 6;
				System.out.println("Point: " + 6);
				break;

			case D8:
				maxPoint = 8;
				System.out.println("Point: " + 8);
				break;

			case D12:
				maxPoint = 12;
				System.out.println("Point: " + 12);
				break;

			case D20:
				maxPoint = 20;
				System.out.println("Point: " + 20);
				break;

			default:
				maxPoint = 4;
				break;
		}

		while(true){
			System.out.println("Input [r] to roll the dice, input [back] to back to the Main Menu.");
			playerInput = inputScanner.nextLine();
			if(playerInput.equals("r")){
				point = randomDice.nextInt(maxPoint);
				System.out.println("You got: " + (point + 1));
				totalPoints = player.getTotalPoints() + point + 1;
				player.setTotalPoints(totalPoints);
				System.out.println("Current Points: " + player.getTotalPoints());
				
			}else if(playerInput.equals("back")){
				break;
			}
			else{
				System.out.println("I don't understand...");
			}
		}
	}
	
	public void end() {
		System.out.println("Finish!");
	}
}
