package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;

/**
 * the class that implements forest
 */
public class Forest implements Biome {

	/* The attribute resource */
	private final Resource RESOURCE;
	
	/* The attribute score */
	private final int SCORE;
	
	/*
	 * the constructor
	 */
	public Forest() {
		this.RESOURCE = new Wood();
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
