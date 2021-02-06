package Game;

public abstract class Player {
	
	protected String name;
	protected int gold;
	
	public Player(String name, int gold) {
		this.name = name;
		this.gold = gold;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void addGold(int nbGold) {
		this.gold += nbGold;
	}
	
	public abstract int calculateScore();
}
