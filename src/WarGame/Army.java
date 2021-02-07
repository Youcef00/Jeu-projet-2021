package WarGame;

import Game.Cell;
import Game.Character;
import WarGame.util.Biome;

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
		if (cell.getBiome() == Biome.MOUNTAIN) {
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
		if (this.cell.getBiome() == new Desert(new Sand(0))) {
			return 2*this.size;
		}
		else {
			return this.size;
		}
		
	}
}
