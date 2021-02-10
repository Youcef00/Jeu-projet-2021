package WarGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import WarGame.util.resources.*;

public class Ocean implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Ocean() {
		this.RESOURCE = new None();
		this.SCORE = 0;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}
	
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
