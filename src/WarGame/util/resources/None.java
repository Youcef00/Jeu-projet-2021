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
	
	public boolean equals(Object o) {
		if (o instanceof None) {
			None other = (None) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "None";
	}

}
