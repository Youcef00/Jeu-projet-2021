package WarGame.util.resources;

import Game.util.Resource;

public class Wheat implements Resource {

	
	private final int LOOT;
	
	public Wheat() {
		this.LOOT = 0;
	}
	
	public int loot() {
		return this.LOOT;
	}
}
