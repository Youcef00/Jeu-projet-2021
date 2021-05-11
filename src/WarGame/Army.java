package WarGame;

import Game.*;
import Game.Character;
import Game.util.*;
import WarGame.util.biomes.*;

/**
 * Class Army extends Character
 */
public class Army extends Character {
	
	/** Size of Army */
	private int size;
	/** maximum size an army */
	private final int MAX_WARRIORS;
	
	/**
	 * Constructor
	 * @param size size of army
	 * @param cell cell when army is
	 * @throws ParmsNotCompatibleException
	 */
	public Army(int size, Cell cell) throws ParmsNotCompatibleException{
		super(0, cell);
		this.MAX_WARRIORS = 5;
		checkBiome(cell, size);
	}
	
	/**
	 * Checks if the cell can accept an army with `size` warriors and apply effect of Biome
	 * @param cell the cell to be checked
	 * @param size the size of army
	 * @throws ParmsNotCompatibleException (Exception)
	 */
	private void checkBiome(Cell cell, int size) throws ParmsNotCompatibleException{
		Biome mountain = new Mountain();
		Biome desert = new Desert();
		Biome ocean = new Ocean();
		if (size <= 0) {
			throw new ParmsNotCompatibleException("Size 0 or lower is not accepted!");
		}
		else if (cell.getBiome().equals(ocean)) {
			throw new ParmsNotCompatibleException("Can't put army in Ocean biome!");
		}
		else if (size > this.MAX_WARRIORS) {
			throw new ParmsNotCompatibleException("Max Warriors Exceeded no more than "+this.MAX_WARRIORS+" warriors");
		}
		else if ((cell.getBiome().equals(mountain) || cell.getBiome().equals(desert)) && size > 3){
			throw new ParmsNotCompatibleException("The biome " + cell.getBiome().toString() + " does not support this size! (max is 3)");
		}
		else if (cell.getBiome().equals(mountain) && size <= 3) {
			this.size += size + 2;
			if (this.size > this.MAX_WARRIORS) {
				this.size = this.MAX_WARRIORS;
			}
		}
		else {
			this.size = size;
		}
	}
	
	/**
	 * Add warriors in army
	 * @param warriors number of warriors to be added
	 */
	public void addWarriors(int warriors) {
		this.size += warriors;
		if (this.size > this.MAX_WARRIORS) {
			this.size = this.MAX_WARRIORS;
		}
	}
	/**
	 * Return size of this army
	 * @return size of army
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Set a new size of army, if this.size < this.MAX_WARRIORS
	 * @param newSize new size of army
	 */
	public void setSize(int newSize) {
		this.size = newSize;
		if (this.size > this.MAX_WARRIORS) {
			this.size = this.MAX_WARRIORS;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Army) {
			Army other = (Army) o;
			return (this.size == other.size && this.cell.equals(other.cell) && this.nbGold == other.nbGold);
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Army Size: " + this.size + " Gold: " + this.nbGold + " Cell: [" + this.cell.toString() + "]";  
	}
	
	@Override
	public int cost() {
		Biome desert = new Desert();
		if (this.cell.getBiome().equals(desert)) {
			return 2*this.size;
		}
		else {
			return this.size;
		}
		
	}
}
