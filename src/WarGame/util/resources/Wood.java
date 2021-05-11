package WarGame.util.resources;

import Game.util.Resource;

/**
 * Class Wood implements Resource
 */
public class Wood implements Resource {
	/** This attribute is the number of loot */
	private final int LOOT;
		
	/**
	 * Constructor of Wood
	 */
	public Wood() {
		this.LOOT = 1;
	}
	@Override
	public int loot() {
		return this.LOOT;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Wood) {
			Wood other = (Wood) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Wood";
	}
}
