package FarmGame.util.biomes;

import Game.util.*;
import FarmGame.util.resources.*;

/**
 * the class that implements the the desert for FarmGame
 */
public class Desert implements Biome {
	/* the attribute resource */
	private final Resource RESOURCE;
	
	/* the attribute score */
	private final int SCORE;
	
	/**
	 * the constructor
	 */
	public Desert() {
		this.RESOURCE = new Sand();
		this.SCORE = 2;
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
		return "Desert";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Desert) {
			Desert other = (Desert) o;
			return (this.RESOURCE.equals(other.RESOURCE) && this.SCORE == other.SCORE);
			
		}
		else {
			return false;
		}
	}

}
