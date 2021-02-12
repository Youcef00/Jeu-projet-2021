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
			player.addCharacter(character);
			Army a = (Army) character;
			WarPlayer wp = (WarPlayer) player;
			wp.removeWarriors(a.getSize());
			cell.addCharacter(character);
			
			// North
			try { effectCell(player, this.players, cell, this.board[cell.getX()-1][cell.getY()]); } catch (ArrayIndexOutOfBoundsException e) {}
			
			// South
			try { effectCell(player, this.players, cell, this.board[cell.getX()+1][cell.getY()]); } catch (ArrayIndexOutOfBoundsException e) {}
			
			// East
			try { effectCell(player, this.players, cell, this.board[cell.getX()][cell.getY()+1]); } catch (ArrayIndexOutOfBoundsException e) {}
			
			// West
			try { effectCell(player, this.players, cell, this.board[cell.getX()][cell.getY()-1]); } catch (ArrayIndexOutOfBoundsException e) {}
			
		}
		
		private void effectCell(Player me, List<Player> players, Cell myCell, Cell otherCell) {
			Army myArmy = (Army) myCell.getCharacter();
			Army otherArmy = (Army) otherCell.getCharacter();
			if (otherArmy != null) {
				
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
		}
		
		public void collect(Player player) {
			Resource resource;
			for (Character c: player.getCharacters()) {
				resource = c.getCell().getBiome().resource(); 
				player.addNbResource(resource.toString(), 1);
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
			List <Character> ArmiesToRemove = new ArrayList<Character>();
			for (Character c: player.getCharacters()) {
				cost = c.cost();
				if (p.getFood() >= cost) {
				p.consumeFood(cost);}
				else {
					ArmiesToRemove.add(c);
					p.addGold(1);
				}
			}
			for (Character c: ArmiesToRemove) {
				p.removeCharacter(c);
			}
			
		}
		
		private boolean checkFull() {
			Biome ocean = new Ocean();
			Cell cell;
			for (int i= 0; i< this.board.length; i++) {
				for (int j=0; j< this.board[i].length; j++) {
					cell = this.board[i][j];
					if (!cell.getBiome().equals(ocean) && cell.isFree()) {
						return false;
					}
				}
			}
			return true;
		}
		private void showResources(Player player) {
			WarPlayer wp = (WarPlayer) player;
			System.out.println("You have: "+ wp.getFood() + " food");
			
			
			Map<String, Integer> resources = player.getResources();
			Set<String> keys = resources.keySet();
			int k = 1;
			for (String key: keys) {
				System.out.println(k + ") " + key + " : " + resources.get(key));
				k++;
			}
		}
		
		private void showArmies(Player p) {
			System.out.println("Your troops are: ");
			int t = 1;
			for (Character c: p.getCharacters()) {
				System.out.println(t + ") " + c.toString());
				t++;
			}
		}
		
		public void playOneRound(Player player) {
			Scanner myScan = new Scanner(System.in);
			String answer;
			WarPlayer wp = (WarPlayer) player;
			showArmies(player);
			System.out.println("You have: "+ wp.getNbWarriors() + " warriors");
			//Deploy !!!!!!!!!!!!!!!
			System.out.print("Deploy ? [y/n]: ");
			answer = myScan.next();
			if (answer.equals("y")) {
				System.out.print("Size of army: ");
				int size = myScan.nextInt();
				System.out.print("Cell [X]: ");
				int x = myScan.nextInt();
				System.out.print("Cell [Y]: ");
				int y = myScan.nextInt();	
				boolean isFree = ( this.board[x][y].isFree() && !this.board[x][y].getBiome().equals(new Ocean()) );
				while (!isFree) {
					System.out.print("Cell occupied! ");
					System.out.print("Cell [X]: ");
					x = myScan.nextInt();
					System.out.print("Cell [Y]: ");
					y = myScan.nextInt();	
					isFree = this.board[x][y].isFree();
				}
				
				// Army creation
				Character army = null;
				boolean created = false;
				while (!created) {
					try {
						army = new Army(size, board[x][y]);
						created = true;
					} catch (ParmsNotCompatibleException e) {
						System.out.println(e.getMessage());
						System.out.print("Size of army: ");
						size = myScan.nextInt();
					}
				}
				
				
				// Deploy !!!!!!!!!!!!!!!!
			    	
				deploy(player, army, board[x][y]);
				showArmies(player);
			}
			 // Collect !!!!!!!!!!!!!!!!!
			collect(player);
			System.out.println("Resources collected!");
			
			showResources(player);
			
			// Convert !!!!!!!!!!!!!!!!!!
			System.out.print("Convert ? [y/n]: ");
			answer = myScan.next();
			//System.out.print("answer: "+answer);
			
			boolean haveEnough = true;
			int nbResource;
			int selectedResource;
			Resource resource = null;
			while (!answer.equals("n") || !haveEnough) {
				System.out.print("Choose resource (int): ");
				selectedResource = myScan.nextInt() - 1;
				
				List<String> listResources = new ArrayList<String>();
				// a changer !!!!!!!!!!!!
				listResources.add("Rock"); listResources.add("Sand"); listResources.add("Wood"); listResources.add("Wheat");
				try {
					listResources.get(selectedResource);
					switch (selectedResource) {
					case 0:
						resource = new Rock();
						break;
					case 1:
						resource = new Sand();
						break;
					case 2:
						resource = new Wood();
						break;
					case 3:
						resource = new Wheat();
						break;
					default:
						break;
					}
				} catch (IndexOutOfBoundsException e) { 
					System.out.println("Wrong selection! ");
					continue;
				}
				
				System.out.print("Quantity: ");
				nbResource = myScan.nextInt();
				
				haveEnough = convert(player, resource, nbResource);
				
				showResources(player);
				System.out.print("Convert ? [y/n]: ");
				answer = myScan.next();
				
				
			    
			}
			
			// Distribute !!!!!!!!!!
			distribute(player);
			System.out.println("Armies fed!\nYou have: " + wp.getFood() + " food left");
			
			
		}
		
		public void play() {
			
			Resource Rock = new Rock();
			Resource Sand = new Sand();
			Resource Wheat = new Wheat();
			Resource Wood = new Wood();
			for (Player p: this.players) {
				 p.initResource(Rock.toString());
				 p.initResource(Sand.toString());
				 p.initResource(Wheat.toString());
				 p.initResource(Wood.toString());
			}
			
			int i = 0;
			while (i< this.nbRounds && !checkFull()) {
				int j = i+1;
				System.out.print("\n##############################\n#           Round "+j+"          #\n##############################\n\n");
				for (Player p: this.players) {
					System.out.println("########### " + p.getName() + " turn ###########");
					playOneRound(p);
				}
				
				i++;
			}
			List<Player> winners = winners();
			for (Player w: winners) {
				System.out.println("The winner is: " + w.getName());
				System.out.println("Score: "+ w.calculateScore());
			}
			
			
		}
		
		
}
