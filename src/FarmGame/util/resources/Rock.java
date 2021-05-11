package FarmGame.util.resources;

import Game.util.Resource;

/**
 * Class Rock implements Resource
 */
public class Rock implements Resource {

	/** This attribute is the number of loot */
	private final int LOOT;
	
	/**
	 * Constructor of Rock
	 */
	public Rock() {
		this.LOOT = 8;
	}
	
	@Override
	public int loot() {
		return this.LOOT;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Rock) {
			Rock other = (Rock) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Rock";
	}

}
