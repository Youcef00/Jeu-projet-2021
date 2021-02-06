package WarGame;

import WarGame.util.Biome;
import Game.Character;


public class Cell {
	private int x;
	private int y;
	private Biome biome;
	private Character character;
	
	public Cell(int x, int y, Biome biome) {
		this.x = x;
		this.y = y;
		this.biome = biome;
		this.character = null;
	}
	
	public Biome getBiome() {
		return this.biome;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	// ATTENTION !!!!!!!!!!
	public Character getCharacter() {
		return this.character;
	}
	
	public void removeCharacter() {
		this.character = null;
	}
	
	public void addCharacter(Character character) {
		this.character = character;
	}
	
	public boolean isFree() {
		return this.character == null;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Cell) {
			Cell other = (Cell) o;
			return (this.x == other.x && this.y == other.y);
			
		}
		else {
			return false;
		}
	}
}
