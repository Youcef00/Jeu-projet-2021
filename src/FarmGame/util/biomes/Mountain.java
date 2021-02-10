package FarmGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import FarmGame.util.resources.*;

public class Mountain implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Mountain() {
		this.RESOURCE = new Rock();
		this.SCORE = 0;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}
	
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
