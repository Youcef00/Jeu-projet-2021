package WarGame;

import Game.*;
import Game.Character;
import Game.util.*;
import WarGame.util.biomes.*;

public class Army extends Character {
	
	private int size;
	private final int MAX_WARRIORS;
	
	public Army(int size, Cell cell) {
		super(0, cell);
		this.MAX_WARRIORS = 5;
		checkBiome(cell, size);
	}
	
	private void checkBiome(Cell cell, int size) {
		Biome mountain = new Mountain();
		if (cell.getBiome() == mountain) {
			this.size += size + 2;
			this.size %= this.MAX_WARRIORS;
		}
		else {
			this.size = size;
		}
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
		if (this.cell.getBiome().equals(desert)) {
			return 2*this.size;
		}
		else {
			return this.size;
		}
		
	}
}
