package FarmGame;

import Game.*;
import Game.util.Biome;
import Game.Character;
import FarmGame.util.biomes.*;

public class Worker extends Character {

	public Worker(Cell cell) {
		super(0, cell);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Worker) {
			Worker other = (Worker) o;
			return (this.cell.equals(other.cell) && this.nbGold == other.nbGold);
		}
		else {
			return false;
		}
	}
	
	public int cost() {
		Biome mountain = new Mountain();
		Biome desert = new Desert();
		Biome forest = new Forest();
		Biome plain = new Plain();
		
		if (this.cell.getBiome() == mountain) { return 5; }
		else if (this.cell.getBiome() == desert) { return 3; }
		else if (this.cell.getBiome() == forest) { return 1; }
		else if (this.cell.getBiome() == plain) { return 1; }
		else { return 0; }
}
	
}
