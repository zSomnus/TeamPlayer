package bus;

import java.io.Serializable;

public class Dice implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
    private EnumShape shape;
    private DiceType type;

    public Dice() {
        color = Color.White;
        shape = EnumShape.Cube;
    }

    public Dice(final Color color, final EnumShape shape) {
        this.color = color;
        this.shape = shape;
    }

    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public EnumShape getShape(){
        return this.shape;
    }
    public void setShape(EnumShape shape){
        this.shape = shape;
    }

    public DiceType getType() {
        return this.type;
    }
    public void setType(DiceType type){
        this.type = type;
    }

    public String toString(){
        return "[Dice:" + this.color + " " + this.shape + " " + this.type + "]";
    }
}