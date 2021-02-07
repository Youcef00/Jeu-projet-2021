package FarmGame.util.resources;

import Game.util.Resource;

public class Wood implements Resource {

	private final int LOOT;
	
	public Wood() {
		this.LOOT = 2;
	}
	
	public int loot() {
		return this.LOOT;
	}
}
