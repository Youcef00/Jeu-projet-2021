package FarmGame.util.resources;

import Game.util.Resource;

public class Sand implements Resource {


	private final int LOOT;
	
	public Sand() {
		this.LOOT = 5;
	}
	
	public int loot() {
		return this.LOOT;
	}

}
