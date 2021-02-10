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
	
	public boolean equals(Object o) {
		if (o instanceof Wheat) {
			Wheat other = (Wheat) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Wheat";
	}
}
