package FarmGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import FarmGame.util.resources.*;

public class Plain implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Plain() {
		this.RESOURCE = new Wheat();
		this.SCORE = 0;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return this.SCORE;
	}
	
	public String toString() {
		return "Plain";
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
