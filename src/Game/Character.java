package Game;

/**
 * A Character is defined by its number of gold and the Cell that he is located in,
 * you can access its parameters anytime,
 * add gold to the current balance,
 * each class that extends the class Character must:
 * - have an equal and to string method
 * - be able to calculate its cost per round in gold depending of your game rules. 
 */
public abstract class Character {

	/** the number of gold that this Character has */
	protected int nbGold;
	/** the cell that this Character is located on */
	protected Cell cell;
	
	/**
	 * creates a Character
	 * @param nbGold the initial value of the gold that this Character have
	 * @param cell the cell that this Character is located on 
	 */
	public Character(int nbGold, Cell cell) {
		this.nbGold = nbGold;
		this.cell = cell;
	}
	
	/**
	 * 
	 * @return the number of gold that this character has
	 */
	public int getNbGold() {
		return this.nbGold;
	}
	
	/**
	 * 
	 * @return the cell that this character is located in
	 */
	public Cell getCell() {
		return this.cell;
	}
	
	/**
	 * add gold to the gold already acquired
	 * @param gold the number of gold to add
	 */
	public void addGold(int gold) {
		this.nbGold += gold;
	}
	
	/**
	 * two Characters are equal if they are on the same cell and have the same number of gold
	 * @param o the object to rest the equality with
	 * @return <code>true</code> if o is a character in the same cell and the same number of gold
	 */
	public abstract boolean equals(Object o);
	
	/**
	 * @see java.langObject#toString()
	 */
	public abstract String toString();
	
	/**
	 * the cost of character is calculated depending on your game rules
	 * @return the cost of the character
	 */
	public abstract int cost();
}
