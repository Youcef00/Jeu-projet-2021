package FarmGame;

import Game.*;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import Game.Character;
import FarmGame.util.biomes.*;

/**
 * the class that implements the character (worker) for FarmGame
*/
public class Worker extends Character {
	
	/**
	 * the constructor
	 * @param cell (Cell) the cell
	 * @throws ParmsNotCompatibleException
	 */
	public Worker(Cell cell) throws ParmsNotCompatibleException {
		super(0, cell);
		checkBiome(cell);
	}
	
	/**
     * Checks if the cell can accept a Workers
     * @param (Cell) the cell to be checked
     * @throws ParmsNotCompatibleException (Exception)
     */
	private void checkBiome(Cell cell) throws ParmsNotCompatibleException{
		Biome ocean = new Ocean();
		if (cell.getBiome().equals(ocean)) {
			throw new ParmsNotCompatibleException("Can't deploy in ocean!");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Worker) {
			Worker other = (Worker) o;
			return (this.cell.equals(other.cell) && this.nbGold == other.nbGold);
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Worker: " + this.nbGold + " Gold. Cell: ["+ this.cell.toString()+"]";
	}
	
	@Override
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
