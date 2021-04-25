package FarmGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Game.*;
import Game.Character;
import Game.util.*;

import FarmGame.util.biomes.*;
import FarmGame.util.resources.*;



public class FarmGameRandom extends FarmGame{

	public FarmGameRandom(List<Player> players, int nbRounds, int width, int height) {
		super(players,nbRounds, width, height) ;
	}
	
private static int getRandomNumberInRange(int min, int max) {

        

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	 
	private static String getRandomYN()
	    {
		 	List<String> YN = new ArrayList<String>();  YN.add("y"); YN.add("n");
	        Random rand = new Random();
	        return YN.get(rand.nextInt(YN.size()));
	    }
	
	 	
	 private Cell getRandomCell() {
		 List<Cell> avaibleCells = new ArrayList<Cell>();
		 Cell currentCell;
		 for(int i=0; i< this.board.length; i++) {
			 for (int j=0; j< this.board[0].length; j++) {
				 currentCell = this.board[i][j];
				 if (currentCell.isFree() && !currentCell.getBiome().equals(new Ocean())) {
					 avaibleCells.add(currentCell);
				 }
			 }
		 }
		 Random rand = new Random();
	     return avaibleCells.get(rand.nextInt(avaibleCells.size()));
		
		 
	 }
	 
	 private static int totalNbResources(Player player) {
			int nbResourceTmp = 0;
			for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
				
				nbResourceTmp += player.getResources().get(r.getKey());
			}
			return nbResourceTmp;
		}
	 
		public void playOneRound(Player player) {
			String answer = null;
			
			showBoard();
			showWorkers(player);
			showResources(player);
			
			
			// Choice !!!!!!
			System.out.print("\n1) Deploy\n2) Convert\n3) Nothing\nYour choice (int): ");

			answer = ""+getRandomNumberInRange(1, 3);
			System.out.println(answer);
			
			if (answer.equals("1")) {
				System.out.println("Deploy! ");
				
				Cell chosenCell = getRandomCell();
				System.out.println("Cell [X]: "+ chosenCell.getX());
				System.out.println("Cell [Y]: "+ chosenCell.getY());
				
				// Army creation
				Character worker = null;
				try {
					worker = new Worker(chosenCell);
				} catch (ParmsNotCompatibleException e) {}
				
				// Deploy !!!!!!!!!!!!!!!!
		    	
				deploy(player, worker, chosenCell);
				showWorkers(player);
			}
			else if (answer.equals("2")) {
				System.out.println("Convert! ");
				
				
				int nbResource;
				int selectedResource;
				
				
				
				
				int nbResourceTmp= 0;
				for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
					
					nbResourceTmp += player.getResources().get(r.getKey());
				}
				
				
				answer = "y";
				Resource resource = null;
				while (answer.equals("y")) {
					if (nbResourceTmp > 1) {
						
					
					System.out.print("Choose resource (int): ");
					
					List<Integer> resourcesToSelect = new ArrayList<Integer>();
					int k = 0;
					for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
						if(player.getResources().get(r.getKey()) > 0) {
							resourcesToSelect.add(k);
						}
						k++;
						
					}
					
					selectedResource = resourcesToSelect.get(getRandomNumberInRange(0, resourcesToSelect.size()-1));
					System.out.println(selectedResource+1);
					
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
					nbResource = getRandomNumberInRange(1, player.getNbResource(resource.toString()));
					System.out.println(nbResource);
					
						if(! convert(player, resource, nbResource)) {
							System.out.println("Pas Assez de resources!");
						}
						
						showResources(player);
						

						if (nbResourceTmp == 0) {
							answer = "n";
						}
						else {
							System.out.print("Convert ? [y/n]: ");
							answer = getRandomYN();
							System.out.println(answer);
						}
						
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
					nbResourceTmp = totalNbResources(player);
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
	 
}
