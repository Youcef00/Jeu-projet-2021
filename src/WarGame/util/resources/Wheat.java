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
	
	public boolean equals(Object o) {
		if (o instanceof Wheat) {
			Wheat other = (Wheat) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
}
