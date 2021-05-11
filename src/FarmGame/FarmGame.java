package FarmGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import FarmGame.util.biomes.*;
import FarmGame.util.resources.*;
import Game.Cell;
import Game.Character;
import Game.Game;
import Game.Player;
import Game.util.*;






public class FarmGame extends Game {

	
	
	public FarmGame(List<Player> players, int nbRounds, int width, int height) {
		super(players,nbRounds, width, height) ;
		
	}
	
	@Override
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
		
		int i =0;
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
	

	@Override
	public void deploy(Player player, Character character, Cell cell) {
		cell.addCharacter(character);
		player.addCharacter(character);
	}

	@Override
	public void collect(Player player) {
		Resource resource ;
		for (Character c: player.getCharacters()) {
			resource = c.getCell().getBiome().resource(); 
			player.addNbResource(resource.toString(), 1);
		}
	}

	@Override
	public boolean convert(Player player, Resource resource, int nbResource) {
		if (player.getNbResource(resource.toString()) >= nbResource) {
			player.addGold(resource.loot()*nbResource);
			player.addNbResource(resource.toString(), -nbResource);
			return true;
		}
		return false;
	}

	@Override
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
					biome = "W";
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
		
		System.out.println("You have: "+ player.getGold() + " gold");
		
		
		Map<String, Integer> resources = player.getResources();
		Set<String> keys = resources.keySet();
		int k = 1;
		for (String key: keys) {
			System.out.println(k + ") " + key + " : " + resources.get(key));
			k++;
		}
	}
	
	protected void showWorkers(Player p) {
		System.out.println("Your workers are: ");
		int t = 1;
		for (Character c: p.getCharacters()) {
			System.out.println(t + ") " + c.toString());
			t++;
		}
	}
	
	@Override
	public void playOneRound(Player player) {
		String answer = null;
		boolean coord = false ;
		showBoard();
		showWorkers(player);
		showResources(player);
		
		
		// Choice !!!!!!
		System.out.print("\n1) Deploy\n2) Convert\n3) Nothing\nYour choice (int): ");
		boolean goodAnswer = false;
		while (!goodAnswer) {
			answer = ""+Input.readInt();
			if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
				goodAnswer = true;
			}
			else {
				System.out.print("Wrong choice!\nNew choice: ");
			}
		}
		
		if (answer.equals("1")) {
			System.out.println("Deploy! ");
			int x = 0 ;
			int y = 0 ;
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
			boolean isFree;
			try { isFree = (this.board[x][y].isFree() && !this.board[x][y].getBiome().equals(new Ocean()) );} catch (ArrayIndexOutOfBoundsException e) {isFree = false;}
			while (!isFree) {
				System.out.println("Cannot deploy on Ocean or ocuppied cell ");
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
				
				try { isFree = (this.board[x][y].isFree() && !this.board[x][y].getBiome().equals(new Ocean()) );} catch (ArrayIndexOutOfBoundsException e) {continue;}
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
			
			
			int nbResource;
			int selectedResource;
			
			boolean haveMultipleResources = false;
			
			
			int nbResourceTmp= 0;
			for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
				
				nbResourceTmp += player.getResources().get(r.getKey());
			}
			
			
			answer = "y";
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
				}
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

	@Override
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
		for (Player p: this.players) {
			System.out.println("Score de "+p.getName()+": "+p.calculateScore());
		}
	}

}
