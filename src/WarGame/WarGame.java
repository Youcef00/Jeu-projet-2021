package WarGame;

import java.util.*;
import Game.*;
import Game.Character;
import Game.util.Resource;

public class WarGame extends Game {

		public WarGame(List<Player> players, int nbRounds) {
			super(players, nbRounds);
		}
		
		public void setBoard() {
			
		}
		
		public void deploy(Player player, Character character, Cell cell) {
			cell.addCharacter(character);
			// North
			try { effectCell(player, this.players, cell, board[cell.getX()-1][cell.getY()]); } catch (ArrayIndexOutOfBoundsException e) {}
			
			// South
			try { effectCell(player, this.players, cell, board[cell.getX()+1][cell.getY()]); } catch (ArrayIndexOutOfBoundsException e) {}
			
			// East
			try { effectCell(player, this.players, cell, board[cell.getX()][cell.getY()+1]); } catch (ArrayIndexOutOfBoundsException e) {}
			
			// West
			try { effectCell(player, this.players, cell, board[cell.getX()][cell.getY()-1]); } catch (ArrayIndexOutOfBoundsException e) {}
			
		}
		
		private void effectCell(Player me, List<Player> players, Cell myCell, Cell otherCell) {
			Army myArmy = (Army) myCell.getCharacter();
			Army otherArmy = (Army) otherCell.getCharacter();
			
			// if enemy army is smaller than deployed army enemie's size is reduced to half
			if ((!me.getCharacters().contains(otherArmy)) && otherArmy.getSize() < myArmy.getSize()) {
				float newSize = (float) (otherArmy.getSize() - otherArmy.getSize() / 2.0);
				if (newSize < 1) {
					for (Player p: players) {
						if (p.getCharacters().contains(otherArmy)) {
							p.removeCharacter(otherArmy);
						}
					}
				} else {
					otherArmy.setSize((int) newSize);
				}
				
				myArmy.addGold(2);	
			}
			
			// if friendly army is smaller than deployed army, friendly++ and deployed gold ++
			else if (me.getCharacters().contains(otherArmy) && otherArmy.getSize() < myArmy.getSize()) {
				otherArmy.addWarriors(1);
				myArmy.addGold(1);
			}
			
		}
		
		public void collect(Player player) {
			Resource resource;
			for (Character c: player.getCharacters()) {
				resource = c.getCell().getBiome().resource(); 
				player.addNbResource(resource.toString(), resource.loot());
			}
		}
		
		public boolean convert(Player player, Resource resource, int nbResource) {
			if (player.getNbResource(resource.toString()) >= nbResource) {
				int loot = resource.loot()*nbResource;
				player.addNbResource(resource.toString(), -nbResource);
				WarPlayer p = (WarPlayer) player;
				p.addFood(loot);
				return true;
			}
			else {
				return false;
			}
		}
		
		public void distribute(Player player) {
			
		}
		
		public void playOneRound(Player player) {
			
		}
		
		public void play() {
			
		}
		
		
}
