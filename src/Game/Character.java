package Game;

public abstract class Character {

	protected int nbGold;
	
	public Character(int nbGold) {
		this.nbGold = nbGold;
	}
	
	public int getNbGold() {
		return this.nbGold;
	}
	
	public void addGold(int gold) {
		this.nbGold += gold;
	}
	
	protected abstract int cost();
}
