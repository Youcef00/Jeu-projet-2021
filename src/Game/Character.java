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
	
	public boolean equals(Object o) {
		if (o instanceof Character) {
			Character other = (Character) o;
			return (this.cell.equals(other.cell) && this.nbGold == other.nbGold) ;
		}
		else {
			return false;
		}
	}
	
	public abstract int cost();
}
