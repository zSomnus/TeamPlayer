package bus;

public class DicePlayer extends GamePlayer implements IPlayable{

    private int totalPoints;
    private DiceType type;

    public DicePlayer(){
        this.totalPoints = 0;
        this.type = DiceType.D6;
    }

    public DicePlayer(long id, String name, EnumType category, DiceType type, int points){
        super(id, name, category);
        this.type = type;
        this.totalPoints = points;
    }

    public int getTotalPoints(){
        return this.totalPoints;
    }
    public void setTotalPoints(int points){
        this.totalPoints = points;
    }

    public DiceType getDiceType(){
        return this.type;
    }
    public void setDiceType(DiceType type){
        this.type = type;
    }

    public String toString(){
        return super.toString() + " [Dice type: " + this.type + "]" + " [Total Point(s): " + this.totalPoints + "]";
    }

    public int countScore(){
        //int num = 90;

        switch(this.type){
            case D4:
                return Math.round(this.totalPoints * 1.5f);
    
            case D6:
                return this.totalPoints;
            
            case D8:
                return Math.round(this.totalPoints * .75f);
                
            case D12:
                return Math.round(this.totalPoints * .5f);
            
            case D20:
                return Math.round(this.totalPoints * .3f);
                
            default:
                return this.totalPoints;
            
        }
    }
}