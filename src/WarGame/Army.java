package WarGame;

import Game.*;
import Game.Character;
import Game.util.*;
import WarGame.util.biomes.*;

public class Army extends Character {
	
	private int size;
	private final int MAX_WARRIORS;
	private Cell cell;
	
	public Army(int size, Cell cell) {
		super(0);
		this.MAX_WARRIORS = 5;
		checkBiome(cell, size);
	}
	
	private void checkBiome(Cell cell, int size) {
		this.cell = cell;
		Biome mountain = new Mountain();
		if (cell.getBiome() == mountain) {
			this.size += size + 2;
			this.size %= this.MAX_WARRIORS;
		}
		else {
			this.size = size;
		}
	}
	
	public Cell getCell() {
		return this.cell;
	}
	
	public void addWarriors(int warriors) {
		this.size += warriors;
		this.size %= this.MAX_WARRIORS;
	}
/**	public void changeCell(Cell cell) {
		this.cell = cell;
		checkBiome(cell, this.size);
	}*/
	
	public boolean equals(Object o) {
		if (o instanceof Army) {
			Army other = (Army) o;
			return (this.size == other.size && this.cell.equals(other.cell) && this.nbGold == other.nbGold);
		}
		else {
			return false;
		}
	}
	
	public int cost() {
		Biome desert = new Desert();
		if (this.cell.getBiome() == desert) {
			return 2*this.size;
		}
		else {
			return this.size;
		}
		
	}
}
