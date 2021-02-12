package Game;

public abstract class Character {

	protected int nbGold;
	protected Cell cell;
	
	public Character(int nbGold, Cell cell) {
		this.nbGold = nbGold;
		this.cell = cell;
	}
	
	public int getNbGold() {
		return this.nbGold;
	}
	
	public Cell getCell() {
		return this.cell;
	}
	
	public void addGold(int gold) {
		this.nbGold += gold;
	}
	
	public abstract boolean equals(Object o);
	
	public abstract String toString();
	
	public abstract int cost();
}
