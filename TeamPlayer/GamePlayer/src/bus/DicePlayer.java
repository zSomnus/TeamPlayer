package bus;

public class DicePlayer extends GamePlayer implements IPlayable{
    private int score;
    private DiceType type;

    public DicePlayer(){
        this.score = 0;
        this.type = DiceType.D6;
    }

    public DicePlayer(long id, String name, EnumType category, DiceType type){
        super(id, name, category);
        this.type = type;
    }

    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        this.score = score;
    }

    public DiceType getDiceType(){
        return this.type;
    }
    public void setDiceType(DiceType type){
        this.type = type;
    }

    public String toString(){
        return "[" + super.toString() + "]" + " Dice type: " + this.type + " Score: " + this.score;
    }

    public int countScore(){
        return this.score;
    }
}