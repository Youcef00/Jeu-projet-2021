package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;

public class Plain implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Plain() {
		this.RESOURCE = new Wheat();
		this.SCORE = 1;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}
	
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