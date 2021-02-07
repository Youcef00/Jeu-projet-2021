package WarGame.util.resources;

import Game.util.Resource;

public class Sand implements Resource {


	private final int LOOT;
	
	public Sand() {
		this.LOOT = 0;
	}
	
	public int loot() {
		return this.LOOT;
	}

}
