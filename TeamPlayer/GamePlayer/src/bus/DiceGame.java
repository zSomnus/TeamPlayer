package bus;

import java.util.*;

public class DiceGame {

	private long id;
	private String name;
	private Scanner inputScanner = new Scanner(System.in);
	private DiceType type;
	private String playerInput;
	private int point;
	private int maxPoint;

	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}

	public DiceGame() {
		
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
		type = DiceType.values()[randomDice.nextInt(DiceType.values().length)];

		switch(type){
			case D4:
				maxPoint = 4;

			case D6:
				maxPoint = 6;

			case D8:
				maxPoint = 8;

			case D12:
				maxPoint = 12;

			case D20:
				maxPoint = 20;

			default:
				maxPoint = 4;
		}
		System.out.println("You got a " + type + " Dice. \n");

		while(true){
			System.out.println("Input [r] to roll the dice, input [back] to back to the Main Menu.");
			playerInput = inputScanner.nextLine();
			if(playerInput.equals("r")){
				point = randomDice.nextInt(maxPoint);
				System.out.println("You got: " + (point + 1));
				
			}else if(playerInput.equals("back")){
				break;
			}
			else{
				System.out.println("I don't understand...");
			}
		}
	}
	
	public void end() {
		Team team = new Team();
		team.add(new DicePlayer(this.id, this.name, EnumType.DicePlayer, type));
	}
}
