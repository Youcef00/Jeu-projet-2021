package Game;

import java.util.*;

public abstract class Game {

		protected List<Player> players;
		protected Cell[][] board;
		protected int nbRounds;
		
		public Game(List<Player> players, int nbRounds) {
			this.players = players;
			this.nbRounds = nbRounds;
		}
		
		public int getNbRounds() {
			return this.nbRounds;
		}
		
		public List<Player> winners() {
			int bestScore = 0;
			List<Player> winners = new ArrayList<Player>();
			for(Player p: this.players) {
				if (p.calculateScore() >= bestScore) {
					bestScore = p.calculateScore();
				}
			}
			for(Player p: this.players) {
				if (p.calculateScore() == bestScore) {
					winners.add(p);
				}
			}
			return winners;
		}
		
		public abstract void setBoard();
		public abstract void deploy(Player player, Cell cell);
		public abstract void collect(Player player);
		public abstract void distribute(Player player);
		public abstract void playOneRound(Player player);
		public abstract void play();
		
}


