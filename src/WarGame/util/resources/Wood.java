package WarGame.util.resources;

import Game.util.Resource;

public class Wood implements Resource {

	private final int LOOT;
	
	public Wood() {
		this.LOOT = 1;
	}
	
	public int loot() {
		return this.LOOT;
	}
}
