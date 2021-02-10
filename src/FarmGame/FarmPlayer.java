package FarmGame;

import Game.Player;
import Game.Character;

public class FarmPlayer extends Player {

	// Attribute that represents the number of workers
	protected int nbWorkers ;
	
	/**
	 * The constructor
	 * @param name (int) the name of player
	*/
	public FarmPlayer(String name) {
		super(name,0) ;
		this.nbWorkers = 0 ;
	}
	
	/**
	 * The method that add the workers for player
	 * @param n (int) the number of workers that add
	*/
	public void addWorkers(int n) {
		this.nbWorkers += 1 ;
	}
	
	/**
	 * The method that return the number workers of player
	 * @return the number of workers
	*/
	public int getNbWorkers() {
		return this.nbWorkers ;
	}
	
	/**
	 * The method that calculate the score of player
	 * @return (int) the score of the player
	 */
	public int calculateScore() {
		int score = this.gold;
		for(Character a : this.characters) {
			score += a.getNbGold();
			score += a.getCell().getBiome().score();	
		}
		return score ;
	}

}
