package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;

/**
 * the class that implements the plain for FarmGame
 */
public class Plain implements Biome {
	
	/* the attribute resource */
	private final Resource RESOURCE;
	
	/* the attribute score */
	private final int SCORE;
	
	/**
	 * the constructor
	 */
	public Plain() {
		this.RESOURCE = new Wheat();
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
		return "Plain";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Plain) {
			Plain other = (Plain) o;
			return (this.RESOURCE.equals(other.RESOURCE) && this.SCORE == other.SCORE);
			
		}
		else {
			return false;
		}
	}

}
