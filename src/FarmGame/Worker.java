package FarmGame;

import Game.*;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import Game.Character;
import FarmGame.util.biomes.*;

public class Worker extends Character {

	public Worker(Cell cell) throws ParmsNotCompatibleException {
		super(0, cell);
		checkBiome(cell);
	}
	
	private void checkBiome(Cell cell) throws ParmsNotCompatibleException{
		Biome ocean = new Ocean();
		if (cell.getBiome().equals(ocean)) {
			throw new ParmsNotCompatibleException("Can't deploy in ocean!");
		}
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
	
	public String toString() {
		return "Worker: " + this.nbGold + " Gold. Cell: ["+ this.cell.toString()+"]";
	}
	
	public int cost() {
		Biome mountain = new Mountain();
		Biome desert = new Desert();
		Biome forest = new Forest();
		Biome plain = new Plain();
		
		if (this.cell.getBiome().equals(mountain)) { return 5; }
		else if (this.cell.getBiome().equals(desert)) { return 3; }
		else if (this.cell.getBiome().equals(forest)) { return 1; }
		else if (this.cell.getBiome().equals(plain)) { return 1; }
		else { return 0; }
}
	
}
