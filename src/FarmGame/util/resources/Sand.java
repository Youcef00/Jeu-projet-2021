package FarmGame.util.resources;

import Game.util.Resource;

/**
 * Class Sand implements Resource
 */
public class Sand implements Resource {

	/** This attribute is the number of loot */
	private final int LOOT;
	
	/**
	 * Constructor of Sand
	 */
	public Sand() {
		this.LOOT = 5;
	}
	
	@Override
	public int loot() {
		return this.LOOT;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Sand) {
			Sand other = (Sand) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Sand";
	}

}
