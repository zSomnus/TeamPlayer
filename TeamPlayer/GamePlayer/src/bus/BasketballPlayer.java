package bus;

import java.util.Stack;

public class BasketballPlayer extends GamePlayer implements IPlayable {

	private Stack<Ball> ballStack = new Stack<Ball>();
	private int basket; // How mavy balls are inside the busket
	private int missed;	// How many balls did I miss

	public BasketballPlayer(){
		super();
		this.ballStack = new Stack<Ball>();
		this.basket = 0;
		this.missed = 0;
	}

	public BasketballPlayer(long id, String name, EnumType category, Stack<Ball> stack, int basket, int missed){
		super(id, name, category);
		this.ballStack = stack;
		this.basket = basket;
		this.missed = missed;
	}

	// encapsulation 
	public Stack<Ball> getBallStack(){
		return this.ballStack;
	}
	public void setBallStack(Stack<Ball> stack){
		this.ballStack = stack;
	}

	public int getBasket(){
		return this.basket;
	}
	public void setBasket(int value){
		this.basket = value;
	}
	
	public int getMissed() {
		return this.missed;
	}
	public void setMissed(int value) {
		this.missed = value;
	}

	public String toString(){
		return super.toString() + " [Got: "  + this.basket + " ball(s)" + " / Missed: " + this.missed + " ball(s)]";
	}

	public int countScore(){
		return this.basket * 2;
	}
}
