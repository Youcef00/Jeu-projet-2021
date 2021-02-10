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
	
	public boolean equals(Object o) {
		if (o instanceof Wood) {
			Wood other = (Wood) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Wood";
	}
}
