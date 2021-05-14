package Game;

import java.util.*;
import Game.util.Resource;

/**
 * A Game is defined by its players, the board and the number of rounds
 * you can access its parameters anytime,
 * each class that extends the class Game must:
 * - implement all of it's abstract methods: setBoard, deploy, convert, distribute, playOneround, play
 * - setBoard defines the board's generation rules
 * - deploy defines the mechanics if your character deploiment on the board
 * - convert defines the mechanics of the Character's resources conversion
 * - distribute defines the rules of cost distribution of the player's characters
 * - playOneRound have all what should happen in one round with your order's choice of the previous methods (deploy, collect, distribute)
 * - play calls playOneRound for nbRoubds times and declares the winner(s) at the end.
 */
public abstract class Game {
		
		/** the players of the game */
		protected List<Player> players;
		/** the board on which the game is set at */
		protected Cell[][] board;
		/** the number of rounds of the game */
		protected int nbRounds;
		
		/**
		 * creates a game
		 * @param nbRounds the number of rounds for the game
		 * @param width the width of the board
		 * @param height the height of the board
		 */
		public Game(int nbRounds, int width, int height) {
			this.players = new ArrayList<Player>() ;
			this.nbRounds = nbRounds;
			setBoard(width, height);
		}
		
		/**
		 * 
		 * @return the number of rounds
		 */
		public int getNbRounds() {
			return this.nbRounds;
		}
		
		/**
		 * adds a player to the game
		 * @param p the player that you want to add
		 * @return <code>true</code> if the player has been added successfuly or <code>false</code> otherwise
		 */
		public boolean addPlayers(Player p) {
			boolean res = false ;
			if (! this.players.contains(p)) {
				this.players.add(p) ;
				res = true ;
			}
			return res ;
			
		}
		
		/**
		 * 
		 * @return the list of players of the game
		 */
		public List<Player> getPlayers() {
			return this.players ;
		}
		
		/**
		 * Calculates the winners of the game depending on the highest score
		 * @return the list of the winner player(s)
		 */
		public List<Player> winners() {
			int bestScore = 0;
			int tmpScore;
			List<Player> winners = new ArrayList<Player>();
			for(Player p: this.players) {
				tmpScore = p.calculateScore();
				if (tmpScore >= bestScore) {
					bestScore = tmpScore;
				}
			}
			for(Player p: this.players) {
				if (p.calculateScore() == bestScore) {
					winners.add(p);
				}
			}
			return winners;
		}

		/**
		 * Checks if the X or Y coordinates on the board depending on the pos parameter	
		 * @param x the value of the coordinate to check
		 * @param pos if it's <code>0</code> checks the x coordinates if it has another value it checks the y coordinates
		 * @return
		 */
		protected boolean checkCoord(int x, int pos) {
			Cell tmp ;
			try {
				if (pos == 0) {
					tmp = this.board[x][0];	
					return true ;
					}
				else {
					tmp = this.board[0][x];
					return true ;
				}
				
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Coordinates out of bound!");
				return false ;
			}
		}
		
		/**
		 * sets the values of the cell's board depending on how you program it and the rules of your game
		 * @param width the width of the board
		 * @param height the height of the board
		 */
		public abstract void setBoard(int width, int height);
		
		/**
		 * sets the mechanics and the rules of character deploiment
		 * @param player the player that executes the deploiment
		 * @param character the character to deploy on the board
		 * @param cell the cell that the character is deployed in
		 */
		public abstract void deploy(Player player, Character character, Cell cell);
		
		/**
		 * sets the mechanics and the rules of the collect of the resources of the player
		 * @param player the player that collects its resources
		 */
		public abstract void collect(Player player);
		
		/**
		 * sets the conversion mechanics and rules of the player's resources
		 * @param player the player that converts its resources
		 * @param resource the resources to convert
		 * @param nbResource the quantity of the resource to convert
		 * @return <code>true</code> if the conversion was successful <code>false</code> otherwise 
		 */
		public abstract boolean convert(Player player, Resource resource, int nbResource);
		
		/**
		 * sets the gold distribution mechanics and rules to the players characters
		 * @param player the player that distribute the gold
		 */
		public abstract void distribute(Player player);
		
		/**
		 * sets the rules and the order of actions in one round
		 * @param player the player that plays one round
		 */
		public abstract void playOneRound(Player player);
		
		/**
		 * plays the game round by round for all players and declares the winner(s) at the end
		 */
		public abstract void play();
		
}


