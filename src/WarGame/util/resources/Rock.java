package WarGame.util.resources;

import Game.util.Resource;

public class Rock implements Resource {

	private final int LOOT;
	
	public Rock() {
		this.LOOT = 0;
	}
	
	public int loot() {
		return this.LOOT;
	}

}
