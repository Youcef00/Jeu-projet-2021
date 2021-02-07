package FarmGame.util.resources;

import Game.util.Resource;

public class Wheat implements Resource {

	
	private final int LOOT;
	
	public Wheat() {
		this.LOOT = 2;
	}
	
	public int loot() {
		return this.LOOT;
	}
}
