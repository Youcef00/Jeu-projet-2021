package WarGame.util.resources;

import Game.util.Resource;

public class None implements Resource {

	private final int LOOT;
	
	public None() {
		this.LOOT = 0;
	}
	
	public int loot() {
		return this.LOOT;
	}

}
