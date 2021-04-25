package FarmGame;

import Game.Player;
import Game.Character;

public class FarmPlayer extends Player {

	
	/**
	 * The constructor
	 * @param name (string) the name of player
	*/
	public FarmPlayer(String name) {
		super(name, 15) ;
	}
	
	/**
	 * The method that calculate the score of player
	 * @return (int) the score of the player
	 */
	public int calculateScore() {
		int score = this.gold;
		for(Character w : this.characters) {
			score += w.getNbGold();	
		}
		return score ;
	}

}
