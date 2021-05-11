package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;

/**
 * the class that implements the Ocean for WarGame
 */
public class Ocean implements Biome {
	
	/* the attribute resource */
	private final Resource RESOURCE;
	
	/* the attribute score */
	private final int SCORE;
	
	/*
	 * the constructor
	 */
	public Ocean() {
		this.RESOURCE = new None();
		this.SCORE = 0;
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
		return "Ocean";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Ocean) {
			Ocean other = (Ocean) o;
			return (this.RESOURCE.equals(other.RESOURCE) && this.SCORE == other.SCORE);
			
		}
		else {
			return false;
		}
	}

}
