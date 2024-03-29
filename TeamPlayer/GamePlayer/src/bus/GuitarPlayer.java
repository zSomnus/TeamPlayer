package bus;

public class GuitarPlayer extends GamePlayer implements IPlayable {
	private int m1;
	private int m2;
	private Color color;
	private GuitarBrand brand;
	
	public GuitarPlayer() {
		super();
		this.color = Color.Black;
		this.brand = GuitarBrand.Gibson;
	}

	public GuitarPlayer(long id, String name, EnumType category, Color color, GuitarBrand brand, int m1, int m2){
		super(id, name, category);
		this.color = color;
		this.brand = brand;
		this.m1 = m1;
		this.m2 = m2;
	}
	
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public GuitarBrand getBrand() {
		return this.brand;
	}
	public void setBrand(GuitarBrand brand) {
		this.brand = brand;
	}
	
	public void setMI(int m1) {
		this.m1 = m1;
	}
	public void setMII(int m2) {
		this.m2 = m2;
	}
	
	public String toString() {
		return super.toString() + " [" + this.color + " " + this.brand + "] " + "[First music: " + this.m1 + " times / Second music: " + m2 + " times]";
	}

	public int countScore(){
		
		return (this.m1 * 2) + (this.m2 * 3);
	}
		
}