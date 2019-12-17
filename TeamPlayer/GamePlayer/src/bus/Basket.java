package bus;

public class Basket {
	private Color color;
	private float area;
	private BasketShape shape;
	
	public Basket() {
		this.color = Color.Red;
		this.area = 0.0f;
		this.shape = BasketShape.Cylinder;
	}
	public Basket(Color color, float area, BasketShape shape) {
		this.color = color;
		
	}
}
