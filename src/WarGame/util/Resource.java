package WarGame.util;

public enum Resource {
		ROCK(0), SAND(0), WOOD(1), WHEAT(5), NONE(0);
	private final int loot;
	
	private Resource(int loot) {
		this.loot = loot;
	}
	
	public int loot() {
		return this.loot;
	}
}
