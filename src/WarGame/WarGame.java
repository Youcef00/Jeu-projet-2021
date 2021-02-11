package WarGame;

import java.util.*;
import Game.*;
import Game.Character;
import Game.util.*;
import Game.util.Resource;
import WarGame.util.biomes.*;
import WarGame.util.resources.*;
import java.util.Scanner;

public class WarGame extends Game {

		public WarGame(List<Player> players, int nbRounds) {
			super(players, nbRounds);
			this.setBoard();
		}
		
		public void setBoard() {
			Biome mountain = new Mountain();
			Biome desert = new Desert();
			Biome forest = new Forest();
			Biome ocean = new Ocean();
			Biome plain = new Plain();
			
			this.board = new Cell[][] 
			{{new Cell(0,0, ocean),new Cell(0,1, ocean),new Cell(0,2, ocean),new Cell(0,3, ocean),new Cell(0,4, plain),new Cell(0,5, desert),new Cell(0,6, ocean)},
			 {new Cell(1,0, ocean),new Cell(1,1, forest),new Cell(1,2, mountain),new Cell(1,3, ocean),new Cell(1,4, plain),new Cell(1,5, plain),new Cell(1,6, ocean)},
			 {new Cell(2,0, ocean),new Cell(2,1, ocean),new Cell(2,2, ocean),new Cell(2,3, ocean),new Cell(2,4, ocean),new Cell(2,5, ocean),new Cell(2,6, ocean)},
			 {new Cell(3,0, ocean),new Cell(3,1, plain),new Cell(3,2, mountain),new Cell(3,3, plain),new Cell(3,4, desert),new Cell(3,5, ocean),new Cell(3,6, ocean)},
			 {new Cell(4,0, ocean),new Cell(4,1, forest),new Cell(4,2, plain),new Cell(4,3, plain),new Cell(4,4, desert),new Cell(4,5, ocean),new Cell(4,6, ocean)},
			 {new Cell(5,0, ocean),new Cell(5,1, ocean),new Cell(5,2, ocean),new Cell(5,3, ocean),new Cell(5,4, ocean),new Cell(5,5, ocean),new Cell(5,6, ocean)}
			};
		}
		
		//Reviens  Armé desert max 3
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
			WarPlayer p = (WarPlayer) player;
			int cost;
			for (Character c: player.getCharacters()) {
				cost = c.cost();
				if (p.getFood() >= cost) {
				p.consumeFood(cost);}
				else {
					p.removeCharacter(c);
					p.addGold(1);
				}
			}
		}
		
		public void playOneRound(Player player) {
			Scanner myScan = new Scanner(System.in);
			String answer;
			System.out.print("Deploy ? [y/n]: ");
			answer = myScan.nextLine();
			if (answer == "y") {
				System.out.print("Size of army: ");
				int size = myScan.nextInt();
				System.out.print("Cell [X]: ");
				int x = myScan.nextInt();
				System.out.print("Cell [Y]: ");
				int y = myScan.nextInt();	
				boolean isFree = ( this.board[x][y].isFree() && !this.board[x][y].getBiome().equals(new Ocean()) );
				while (!isFree) {
					System.out.print("Case non libre! ");
					System.out.print("Cell [X]: ");
					x = myScan.nextInt();
					System.out.print("Cell [Y]: ");
					y = myScan.nextInt();	
					isFree = this.board[x][y].isFree();
				}
				
				Character army = new Army(size, board[x][y]);
				
				// Deploy !!!!!!!!!!!!!!!!
				deploy(player, army, board[x][y]);
				
			}
			 // Collect !!!!!!!!!!!!!!!!!
			collect(player);
			
			
			Map<String, Integer> resources = player.getResources();
			Set<String> keys = resources.keySet();
			int k = 1;
			for (String key: keys) {
				System.out.println(k + ") " + key + " : " + resources.get(key));
				k++;
			}
			System.out.print("Convert ? [y/n]: ");
			answer = myScan.nextLine();
			boolean haveEnough = false;
			int nbResource;
			int selectedResource;
			Resource resource = null;
			while (answer != "n" || !haveEnough) {
				System.out.println("Choose resource (int): ");
				selectedResource = myScan.nextInt();
				
				List<String> listResources = new ArrayList<String>();
				// a changer !!!!!!!!!!!!
				listResources.add("Rock"); listResources.add("Sand"); listResources.add("Wheat"); listResources.add("Wood");
				try {
					listResources.get(selectedResource);
					switch (selectedResource) {
					case 1:
						resource = new Rock();
						break;
					case 2:
						resource = new Sand();
						break;
					case 3:
						resource = new Wheat();
						break;
					case 4:
						resource = new Wood();
						break;
					default:
						break;
					}
				} catch (IndexOutOfBoundsException e) { 
					System.out.println("Wrong select! ");
					continue;
				}
				
				System.out.println("Quantity: ");
				nbResource = myScan.nextInt();
				
				haveEnough = convert(player, resource, nbResource);
				
				System.out.print("Convert ? [y/n]: ");
				answer = myScan.nextLine();
				
				
			    
			}
			
			// Ditribute !!!!!!!!!!
			distribute(player);
			
			myScan.close();
		}
		
		public void play() {
			for (int i=0; i< this.nbRounds; i++) {
				System.out.println("Round "+ i+1 + " : ");
				for (Player p: this.players) {
					playOneRound(p);
				}	
			}
			List<Player> winners = winners();
			for (Player w: winners) {
				System.out.println("Score: "+w.calculateScore());
			}
			
			
		}
		
		
}
