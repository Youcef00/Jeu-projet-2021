package Game;

import java.util.*;
import Game.util.Resource;

public abstract class Game {

		protected List<Player> players;
		protected Cell[][] board;
		protected int nbRounds;
		
		public Game(List<Player> players, int nbRounds, int width, int height) {
			this.players = players;
			this.nbRounds = nbRounds;
			setBoard(width, height);
		}
		
		public int getNbRounds() {
			return this.nbRounds;
		}
		
		public boolean addPlayers(Player p) {
			boolean res = false ;
			if (! this.players.contains(p)) {
				this.players.add(p) ;
				res = true ;
			}
			return res ;
			
		}
		
		public List<Player> getPlayers() {
			return this.players ;
		}
		
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
		
		public abstract void setBoard(int width, int height);
		public abstract void deploy(Player player, Character character, Cell cell);
		public abstract void collect(Player player);
		public abstract boolean convert(Player player, Resource resource, int nbResource);
		public abstract void distribute(Player player);
		public abstract void playOneRound(Player player);
		public abstract void play();
		
}


