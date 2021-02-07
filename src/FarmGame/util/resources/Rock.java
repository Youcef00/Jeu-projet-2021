package FarmGame.util.resources;

import Game.util.Resource;

public class Rock implements Resource {

	private final int LOOT;
	
	public Rock() {
		this.LOOT = 8;
	}
	
	public int loot() {
		return this.LOOT;
	}

}
