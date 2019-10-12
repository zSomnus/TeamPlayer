package bus;

public abstract class GamePlayer {	
	private long id;
	private String name;
	private EnumType category;

	public GamePlayer() {
		this.id = 1234567890;
		this.name = "Ella";
		this.category = EnumType.BasketballPlayer;
	}

	public GamePlayer(long id, String name, EnumType category){
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public EnumType getCategory(){
		return this.category;
	}
	public void setCategory(EnumType category){
		this.category = category;
	}

	public String toString(){
		return "[ID: " + this.id + "]" + " [Name: " + this.name + "]" + " [Category: " + this.category + "]";
	}
}