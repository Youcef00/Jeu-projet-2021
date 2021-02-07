package FarmGame.util.biomes;

import Game.util.Biome;
import Game.util.Resource;
import FarmGame.util.resources.*;

public class Forest implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Forest() {
		this.RESOURCE = new Wood();
		this.SCORE = 0;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}

}
