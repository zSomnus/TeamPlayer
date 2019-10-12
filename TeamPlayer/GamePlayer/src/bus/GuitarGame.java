package bus;

import java.util.Scanner;
import java.util.Random;

public class GuitarGame extends GuitarPlayer {
	private int m1;
	private int m2;
	private long id;
	private String name;
	private Scanner inputScanner = new Scanner(System.in);
	private String playerInput;
	private Color color;
	private GuitarBrand brand;
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
	public int getMI() {
		return this.m1;
	}
	
	public int getMII() {
		return this.m2;
	}
	
	public GuitarBrand getBrand() {
		return this.brand;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	
	public GuitarGame() {
		
	}
	
	public void start() {
		System.out.println("You choosed Guitar Player");
		
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
		GuitarPlayer player = new GuitarPlayer();
		Random randomColor = new Random();
		Random randomBrand = new Random();
		
		player.setColor(Color.values()[randomColor.nextInt(Color.values().length)]);
		player.setBrand(GuitarBrand.values()[randomBrand.nextInt(GuitarBrand.values().length)]);
		
		color = Color.values()[randomColor.nextInt(Color.values().length)];
		brand = GuitarBrand.values()[randomBrand.nextInt(GuitarBrand.values().length)];
		
		while(true) {
			System.out.println("Choose a music by input the index of the music");
			System.out.println(" 1. Secret Base \n 2. Miracle Mountain");
			System.out.println("or input [back] to back to the Main Menu");
			playerInput = inputScanner.nextLine();
			
			if(playerInput.equals("1")){
				m1++;
				System.out.println("Play \"Secret Base\"");
			}else if(playerInput.equals("2")){
				m2++;
				System.out.println("Play \"Miracle Mountain\"");
			}else if(playerInput.equals("back")){
				break;
			}
			else{
				System.out.println("I don't understand");
			}
		}
	}
	
	public void end() {
		Team team = new Team();
		team.addGuitarPlayer(new GuitarPlayer(this.id, this.name, EnumType.GuitarPlayer, this.color, this.brand, this.m1, this.m2));
	}
}
