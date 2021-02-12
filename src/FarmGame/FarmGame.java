package FarmGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import FarmGame.util.biomes.*;
import FarmGame.util.resources.*;
import Game.Cell;
import Game.Character;
import Game.Game;
import Game.Player;
import Game.util.*;




public class FarmGame extends Game {

	
	
	public FarmGame(List<Player> players, int nbRounds) {
		super(players,nbRounds) ;
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


	public void deploy(Player player, Character character, Cell cell) {
		cell.addCharacter(character);
		player.addCharacter(character);
	}


	public void collect(Player player) {
		Resource resource ;
		for (Character c: player.getCharacters()) {
			resource = c.getCell().getBiome().resource(); 
			player.addNbResource(resource.toString(), 1);
		}
	}


	public boolean convert(Player player, Resource resource, int nbResource) {
		if (player.getNbResource(resource.toString()) >= nbResource) {
			player.addGold(resource.loot());
			player.addNbResource(resource.toString(), -nbResource);
			return true;
		}
		return false;
	}


	public void distribute(Player player) {
		int cost;
		List <Character> WorkersToRemove = new ArrayList<Character>();
		for (Character c: player.getCharacters()) {
			cost = c.cost();
			if (player.getGold() >= cost) {
				player.addGold(-cost);
				c.addGold(cost);
			}
			else {
				WorkersToRemove.add(c);
			}
		}
		for (Character c: WorkersToRemove) {
			player.removeCharacter(c);
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
		
		System.out.println("You have: "+ player.getGold() + " gold");
		
		
		Map<String, Integer> resources = player.getResources();
		Set<String> keys = resources.keySet();
		int k = 1;
		for (String key: keys) {
			System.out.println(k + ") " + key + " : " + resources.get(key));
			k++;
		}
	}
	
	private void showWorkers(Player p) {
		System.out.println("Your workers are: ");
		int t = 1;
		for (Character c: p.getCharacters()) {
			System.out.println(t + ") " + c.toString());
			t++;
		}
	}

	public void playOneRound(Player player) {
		Scanner myScan = new Scanner(System.in);
		String answer = null;
		
		showWorkers(player);
		showResources(player);
		
		// Choice !!!!!!
		System.out.print("\n1) Deploy\n2) Convert\n3) Nothing\nYour choice (int): ");
		boolean goodAnswer = false;
		while (!goodAnswer) {
			answer = myScan.next();
			if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
				goodAnswer = true;
			}
			else {
				System.out.print("Wrong choice!\nNew choice: ");
			}
		}
		
		if (answer.equals("1")) {
			System.out.println("Deploy! ");
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
			Character worker = null;
			boolean created = false;
			while (!created) {
				try {
					worker = new Worker(board[x][y]);
					created = true;
				} catch (ParmsNotCompatibleException e) {
					System.out.println(e.getMessage());
				}
			}
			// Deploy !!!!!!!!!!!!!!!!
	    	
			deploy(player, worker, board[x][y]);
			showWorkers(player);
		}
		else if (answer.equals("2")) {
			System.out.println("Convert! ");
			
			boolean haveEnough = true;
			int nbResource;
			int selectedResource;
			answer = "y";
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
		}
		else {
			// Do Nothing !!!!!!!!!!!!!!!!!
			for (Character c: player.getCharacters()) {
				player.addGold(c.getCell().getBiome().score());
			}
		}
		
		 // Collect !!!!!!!!!!!!!!!!!
		collect(player);
		System.out.println("Resources collected!");
		
		// Distribute !!!!!!!!!!
		distribute(player);
		showWorkers(player);
	
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
