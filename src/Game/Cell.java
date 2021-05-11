package Game;

import Game.util.*;

/**
 * A Cell is defined by its x , y coordinates, its biome and the character that is on it,
 * you can access its parameters anytime,
 * remove or add a character,
 * check if the cell is already occupied by another character or not.
 */

public class Cell {
	/** x coordinates in the board */
	private int x;
	/** y coordinates in the board */
	private int y;
	/** The biome of the Cell */
	private Biome biome;
	/** The Character on the cell*/
	private Character character;
	
	/**
	 * creates a cell, no character at creation
	 * @param x the X coordinates on the board
	 * @param y the Y coordinates on the board
	 * @param biome the biome of type Biome for the Cell
	 */
	public Cell(int x, int y, Biome biome) {
		this.x = x;
		this.y = y;
		this.biome = biome;
		this.character = null;
	}
	
	/**
	 * returns the biome of this cell
	 * @return the biome of type Biome for this Cell
	 */
	public Biome getBiome() {
		return this.biome;
	}
	
	/**
	 * returns the x coordinates of this Cell
	 * @return the x coordinates of this Cell
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * returns the y coordinates of this Cell
	 * @return the y coordinates of this Cell
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * returns the character that is on this Cell
	 * @return the character of type Character that is on this Cell
	 */
	public Character getCharacter() {
		return this.character;
	}
	
	/**
	 * removes the character from this Cell
	 */
	public void removeCharacter() {
		this.character = null;
	}
	
	/**
	 * adds a character to this Cell
	 * @param character The character of type Character to put on this Cell
	 */
	public void addCharacter(Character character) {
		this.character = character;
	}
	
	/**
	 * Sets the biome for this Cell
	 * @param biome of type Biome for this Cell
	 */
	public void setBiome(Biome biome) {
		this.biome = biome;
	}
	
	/**
	 * returns <code>true</code> if this Cell is free meaning it has no character on it
	 * @return <code>true</code> if this Cell is free meaning it has no character on it
	 */
	public boolean isFree() {
		return this.character == null;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Biome: " + this.biome.toString() + " X: " + this.x + " Y: " + this.y;
	}
	
	/**
	 * two Cells are equals if they have the same x and y coordinates
	 * @param o the object to test the equality with
	 * @return <code>true</code> if o is a cell with same x and y coordinates of this object
	 */
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
