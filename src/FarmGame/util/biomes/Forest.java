package FarmGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import FarmGame.util.resources.*;


/**
 * the class that implements forest
 */
public class Forest implements Biome {
	
	/* the attribute resource */
	private final Resource RESOURCE;
	
	/* the attribute score */
	private final int SCORE;
	
	/**
	 * the constructor
	 */
	public Forest() {
		this.RESOURCE = new Wood();
		this.SCORE = 1;
	}
	
	@Override
	public Resource resource() {
		return this.RESOURCE;
	}
	
	@Override
	public int score() {
		return this.SCORE;
	}
	
	@Override
	public String toString() {
		return "Forest";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Forest) {
			Forest other = (Forest) o;
			return (this.RESOURCE.equals(other.RESOURCE) && this.SCORE == other.SCORE);
			
		}
		else {
			return false;
		}
	}

}
