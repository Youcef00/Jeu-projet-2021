package FarmGame.util.biomes;

import Game.util.*;
import FarmGame.util.resources.*;

public class Desert implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Desert() {
		this.RESOURCE = new Sand();
		this.SCORE = 0;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}

}
