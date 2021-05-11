package WarGame.util.resources;

import Game.util.Resource;

/**
 * Class Wheat implements Resource
 */
public class Wheat implements Resource {

	/** This attribute is the number of loot */
	private final int LOOT;
		
	/**
	 * Constructor of Wheat
	 */
	public Wheat() {
		this.LOOT = 5;
	}
	@Override
	public int loot() {
		return this.LOOT;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Wheat) {
			Wheat other = (Wheat) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Wheat";
	}
}
