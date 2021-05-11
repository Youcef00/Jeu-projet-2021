package WarGame.util.resources;

import Game.util.Resource;

/**
 * Class None implements Resource
 */
public class None implements Resource {

	/** This attribute is the number of loot */
	private final int LOOT;
	
	/**
	 * Constructor of None
	 */
	public None() {
		this.LOOT = 0;
	}
	@Override
	public int loot() {
		return this.LOOT;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof None) {
			None other = (None) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "None";
	}

}
