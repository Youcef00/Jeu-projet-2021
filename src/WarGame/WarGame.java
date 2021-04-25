package WarGame;

import java.util.*;
import Game.*;
import Game.Character;
import Game.util.*;
import WarGame.util.biomes.*;
import WarGame.util.resources.*;

public class WarGame extends Game {

		public WarGame(List<Player> players, int nbRounds, int width, int height) {
			super(players, nbRounds, width, height);
		}
		
		public void setBoard(int width, int height) {
			Random random = new Random();
			
			Biome mountain = new Mountain();
			Biome desert = new Desert();
			Biome forest = new Forest();
			Biome ocean = new Ocean();
			Biome plain = new Plain();
			
			Biome[] biomes = new Biome[] {mountain, desert, forest, plain};
			
			// init the board
			Cell[][] board = new Cell[height][width];
			for (int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					board[i][j] = new Cell(i, j, ocean);
				}
			}
			
			int i = 0;
			int randomInteger;
			int nonOcean = (width*height)/3;
			Biome biome = null;
			Biome biomeNext = null;

			while (nonOcean > 0) {
				// Set random desert
				randomInteger = random.nextInt(width);
				try { biome = board[i][randomInteger].getBiome(); biomeNext = board[i][randomInteger+1].getBiome(); } catch (ArrayIndexOutOfBoundsException e) { biomeNext = board[i][randomInteger-1].getBiome();}
				if (biome.equals(ocean) && biomeNext.equals(ocean)) {
					board[i][randomInteger].setBiome(biomes[random.nextInt(biomes.length)]);
					try { board[i][randomInteger+1].setBiome(biomes[random.nextInt(biomes.length)]); } catch (ArrayIndexOutOfBoundsException e) { board[i][randomInteger - 1].setBiome(biomes[random.nextInt(biomes.length)]); }
					nonOcean -= 2;					
				}
				
				
				i++;
				i %= height;
			}
			this.board = board;
		}
		
		
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
		
		protected boolean checkFull() {
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
		
		protected void showBoard() {
			System.out.print("     ");
			for (int i=0; i<this.board[0].length; i++) {
				if (i< 10) {System.out.print(i+ "   ");}
				else {System.out.print(i+ "  ");}
			}
		
			System.out.print("\n");
			String biome;
			for (int i=0; i<this.board.length; i++) {
				if (i<10) {
					System.out.print(i+ "  |");
				}
				else {
					System.out.print(i+ " |");
				}
				
				for (int j=0; j<this.board[i].length; j++) {
					if (this.board[i][j].isFree()) {
						biome = String.valueOf(this.board[i][j].getBiome().toString().charAt(0)) ;
					} 
					else {
						biome = "A";
					}
					
					if (!biome.equals("O")) {
						System.out.print("["+ biome + "]|");
					}
					else {
						System.out.print(" "+ biome + " |");
					}
					
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
		
		protected void showResources(Player player) {
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
		
		protected void showArmies(Player p) {
			System.out.println("Your troops are: ");
			int t = 1;
			for (Character c: p.getCharacters()) {
				System.out.println(t + ") " + c.toString());
				t++;
			}
		}
		
		
		
		public void playOneRound(Player player) {
			
			String answer;
			boolean coord = false;
			WarPlayer wp = (WarPlayer) player;
			showBoard();
			showArmies(player);
			System.out.println("You have: "+ wp.getNbWarriors() + " warriors");
			//Deploy !!!!!!!!!!!!!!!
			System.out.print("Deploy ? [y/n]: ");
			answer = Input.YNString();
			
			if (answer.equals("y")) {
				int x=0;
				int y=0;
				
				while(!coord) {
					System.out.print("Cell [X]: ");
					x = Input.readInt();
					coord = checkCoord(x, 0);
				}
				coord = false;
				
				while(!coord) {
					System.out.print("Cell [Y]: ");
					y = Input.readInt();
					coord = checkCoord(y, 1);
				}
				coord = false;
				
				System.out.print("Size of army: ") ;
				int size = Input.readInt();
				boolean isFree; 
				try { isFree = ( this.board[x][y].isFree() && !this.board[x][y].getBiome().equals(new Ocean()) ); }catch (ArrayIndexOutOfBoundsException e) { isFree = false;}
				while (!isFree) {
					System.out.println("Cannot deploy on Ocean or ocuupied cell! ");
					while(!coord) {
						System.out.print("Cell [X]: ");
						x = Input.readInt();
						coord = checkCoord(x, 0);
					}
					coord = false;
					
					while(!coord) {
						System.out.print("Cell [Y]: ");
						y = Input.readInt();
						coord = checkCoord(y, 1);
					}
					coord = false;
					
					try { isFree = ( this.board[x][y].isFree() && !this.board[x][y].getBiome().equals(new Ocean()) ); }catch (ArrayIndexOutOfBoundsException e) { continue;}
					
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
						size = Input.readInt();
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
			
			boolean haveMultipleResources = false;
			
			int nbResourceTmp = 0;
			for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
				
				nbResourceTmp += player.getResources().get(r.getKey());
			}
			
				
				System.out.print("Convert ? [y/n]: ");
				answer = Input.YNString();
				
				int nbResource;
				int selectedResource;
				
				Resource resource = null;
				while (answer.equals("y")) {
					if (nbResourceTmp > 1) {
						haveMultipleResources = true;
					
					System.out.print("Choose resource (int): ");
					selectedResource = Input.readInt() - 1;
					
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
					nbResource = Input.readInt();
					
					if(! convert(player, resource, nbResource)) {
						System.out.println("Pas Assez de resources!");
					}
					
					showResources(player);
					System.out.print("Convert ? [y/n]: ");
					answer = Input.YNString();
					
					
					} 
					else {
						answer = "n";
						
						String stringResource;
						resource = null;
						for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
							if(player.getResources().get(r.getKey()) > 0) {
								stringResource = r.getKey();
								switch (stringResource) {
								case "Rock":
									resource = new Rock();
									break;
								case "Sand":
									resource = new Sand();
									break;
								case "Wood":
									resource = new Wood();
									break;
								case "Wheat":
									resource = new Wheat();
									break;
								default:
									break;
								}
								convert(player, resource, 1);
							}
						}
					} // fin du else
				} // fin du while
				
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
				
				//recap
				System.out.println("\n##############################\n#           Summary          #\n##############################");
				for (Player p: this.players) {
					System.out.println("\n########## "+  p.getName()  +" ##########\n");
					showArmies(p);
					showResources(p);
				}
				
				i++;
			}
			List<Player> winners = winners();
			i = 1;
			System.out.println("The winners are: ");
			for (Player w: winners) {
				System.out.println(i+ ") " + w.getName());
				//System.out.println("Score: "+ w.calculateScore());
			}
			
			
			for (Player p: this.players) {
				System.out.println("Score de "+p.getName()+": "+p.calculateScore());
			}
			
			
		}
		
		
}
