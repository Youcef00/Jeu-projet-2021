package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;
public class Forest implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Forest() {
		this.RESOURCE = new Wood();
		this.SCORE = 2;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}
	
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
