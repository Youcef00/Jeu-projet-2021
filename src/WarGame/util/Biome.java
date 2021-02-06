package WarGame.util;

public enum Biome {
	MOUNTAIN(Resource.ROCK), PLAIN(Resource.WHEAT), DESERT(Resource.SAND), FOREST(Resource.WOOD), OCEAN(Resource.NONE);
	
	private Resource resource;
	
	private Biome(Resource resource) {
		this.resource = resource;
	}
	
	public Resource resource() {
		return this.resource;
	}
}
