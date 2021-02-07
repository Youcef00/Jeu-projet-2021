package WarGame.util.biomes;

import Game.util.*;
import WarGame.util.resources.*;

public class Desert implements Biome {

	private final Resource RESOURCE;
	private final int SCORE;
	
	public Desert() {
		this.RESOURCE = new Sand();
		this.SCORE = 4;
	}
	
	public Resource resource() {
		return this.RESOURCE;
	}
	
	public int score() {
		return SCORE;
	}

}
