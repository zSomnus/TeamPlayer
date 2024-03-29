package bus;

import java.util.*;

public class BasketballGame {
	private Team team = new Team();
	private ArrayList<BasketballPlayer> basketballTeam;
	
	public BasketballGame() {
		this.basketballTeam = new ArrayList<BasketballPlayer>();
	}
	
	public void add(BasketballPlayer player) {
		this.team.add(player);
	}
	
	public void remove(BasketballPlayer player) {
		this.team.remove(player);
	}
	
	public ArrayList<BasketballPlayer> getTeam(){
		return this.basketballTeam;
	}
	public void setTeam(ArrayList<BasketballPlayer> team) {
		this.basketballTeam = team;
	}
	
	private int score = 0;
	private int missed = 0;
	private int maxBalls = 10;
	private Stack<Ball> ballStack = new Stack<Ball>();
	private Scanner inputScanner = new Scanner(System.in);
	private EnumType playerType;
	
	String playerInput = "";
	long id;
	String name;
	
	float[] ballSizes = {29.5f, 28.5f, 27.5f, 25.5f};
	
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	public EnumType getCategory() {
		return this.playerType;
	}
	
	public Stack<Ball> getBallStack(){
		return this.ballStack;
	}
	public int getMissed() {
		return this.missed;
	}
	
	public void start() {
		System.out.println("** You choosed Basketball Player **");
		playerType = EnumType.BasketballPlayer;
		
		 
		 while(true){
			 System.out.println("Please input your ID (numbers only): ");
			 try {
				 id = Long.parseLong(inputScanner.nextLine());
				 break;
				} catch (NumberFormatException e){
					System.out.println("Your input is invalid, please try again.");
					System.out.println("----------------------------------------");
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("Please input your name: ");
		name = inputScanner.nextLine();
		System.out.println("------------------------");
	}
	
	public void run() {
		BasketballPlayer basketballPlayer = new BasketballPlayer();
		for(int i = 0; i < maxBalls; i++) {
			Random randomColor = new Random();
			Random randomSize = new Random();
			pushBall(ballStack, Color.values()[randomColor.nextInt(Color.values().length)], ballSizes[randomSize.nextInt(ballSizes.length)]);
		}

		for(int i = 0; i < maxBalls; i++){
			System.out.println("-------------------------");
			System.out.println("| Balls in your basket: |");
			System.out.println("-------------------------");
        	System.out.println(ballStack);
        	System.out.println();
			System.out.println("Input [t] to throw a ball or [back] back to the Main Menu");
            //Scanner playerInputScanner = new Scanner(System.in);
            playerInput = inputScanner.nextLine();
			System.out.println("--------------------------------------------------------------------------------");
            if(playerInput.equals("t")){
                try {
					System.out.println("\n------------");
					System.out.print("| pop ball |");
					popBall(ballStack);
					System.out.println("------------");
                    Random random = new Random();
                    int probability = random.nextInt(10);

                    if(probability > 4){
                        score++;
						basketballPlayer.setBasket(score);
						System.out.println("[ Score: " + basketballPlayer.countScore() + " ]");
                    }
                    else{
						System.out.println("\n-----------------");
						System.out.println("| You missed... |");
						System.out.println("-----------------\n");
                        missed++;
                        basketballPlayer.setMissed(missed);
                    }

                } 
                catch (EmptyStackException e) {
					System.out.println("\n-----------------------------------------------------------");
					System.out.println("| empty basket, please input [back] back to the main menu |");
					System.out.println("-----------------------------------------------------------\n");
                }
            }
            else if(playerInput.equals("back")){
                break;
            }
            else{
				System.out.println("\n-------------------------");
				System.out.println("| I don't understand... |");
				System.out.println("-------------------------\n");
                System.out.println("Input [t] to throw a ball or [back] to exit the application");
                i--;
            }
		}
	}
	public void end() {
		System.out.println("\n=============");
		System.out.println("|| Finish! ||");
		System.out.println("=============\n");
	}
	
	 // Basketball player Stack
    static void pushBall(Stack<Ball> stack, Color color, float size) {
        stack.push(new Ball(color, size));
        //System.out.println("push( new Ball( " +  color + ", " + size + ")) ");
        //System.out.println("stack: " + stack);
    }
    static void popBall(Stack<Ball> stack){
        Ball ball = (Ball) stack.pop();
        System.out.println(" >>>> " + ball);
        //System.out.println("stack: " + stack);
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
