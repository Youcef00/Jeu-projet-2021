package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;

/**
 * the class that implements the Mountain for WarGame
 */
public class Mountain implements Biome {
	
	/* The attribute resource */
	private final Resource RESOURCE;
	
	/* The attribute score */
	private final int SCORE;
	
	/**
	 * the constructor
	 */
	public Mountain() {
		this.RESOURCE = new Rock();
		this.SCORE = 4;
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
		return "Mountain";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Mountain) {
			Mountain other = (Mountain) o;
			return (this.RESOURCE.equals(other.RESOURCE) && this.SCORE == other.SCORE);
			
		}
		else {
			return false;
		}
	}

}
