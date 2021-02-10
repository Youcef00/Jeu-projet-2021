package FarmGame.util.resources;

import Game.util.Resource;

public class Rock implements Resource {

	private final int LOOT;
	
	public Rock() {
		this.LOOT = 8;
	}
	
	public int loot() {
		return this.LOOT;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Rock) {
			Rock other = (Rock) o;
			return (this.LOOT == other.LOOT);
			
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Rock";
	}

}
