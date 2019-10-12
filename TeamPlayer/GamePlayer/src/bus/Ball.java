package bus;

public class Ball{
    private Color color;
    private float size;

    public Ball(){
        this.color = Color.Red;
        this.size = 0.f;
    }
    
    public Ball(Color color, float size){
        this.color = color;
        this.size = size;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public float getSize(){
        return this.size;
    }
    public void setSize(float size){
        this.size = size;
    }

    public String toString(){
        return "(" + this.color + ", " + this.size + ")";
    }
}