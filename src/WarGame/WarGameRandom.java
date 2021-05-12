package WarGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Game.Cell;
import Game.Character;
import Game.Player;
import Game.util.*;
import WarGame.util.biomes.*;
import WarGame.util.resources.*;

/**
 * the class that implements the WarGame randomly
 */
public class WarGameRandom extends WarGame {
	
	/**
	 * The constructor
	 * @param players (List<Player>) the list of players
	 * @param nbRounds (int) the number of round
	 * @param width (int) the width of board
	 * @param height (int) the height of board
	 */
	public WarGameRandom(List<Player> players, int nbRounds, int width, int height) {
		super(players, nbRounds, width, height);
	}
	
	/**
	 * the private method which randomly returns the number of armies used in the game
	 * @param min (int) the minimum of size
	 * @param max (int) the maximum of size
	 * @return (int) the random number
	 */
	private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	
	/**
	 * the private method that randomly returns the yes or no answer used in the game
	 * @return (String) the answer (y for yes, and n for no)
	 */
	private static String getRandomYN() {
		 	List<String> YN = new ArrayList<String>();  YN.add("y"); YN.add("n");
	        Random rand = new Random();
	        return YN.get(rand.nextInt(YN.size()));
	}
	
	/**
	 * the private method which randomly returns a cell
	 * @return (Cell) the cell
	 */
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
	
	/**
	 * the private method which calculate the total number of resources for the player passed in parameter
	 * @param player (Player) the player
	 * @return (int) the total of number resource
	*/
	private static int totalNbResources(Player player) {
			int nbResourceTmp = 0;
			for(Map.Entry<String, Integer> r : player.getResources().entrySet()) {
				
				nbResourceTmp += player.getResources().get(r.getKey());
			}
			return nbResourceTmp;
		}
	
	/**
	 * the method allowing us to play one round at WarGameRandom
	*/
	public void playOneRound(Player player) {
			String answer ;
			boolean coord = false ;
			List<String> answers = new ArrayList<>();  answers.add("y");  answers.add("n");
			WarPlayer wp = (WarPlayer) player;
			showBoard();
			showArmies(player);
			System.out.println("You have: " + wp.getNbWarriors() + " warriors");
			//Deploy !!!!!!!!!!!!!!!
			System.out.print("Deploy ? [y/n]: ");
			answer = getRandomYN();
			System.out.println(answer);
			
			if (answer.equals("y")) {
				
				Cell chosenCell = getRandomCell();
				System.out.println("Cell [X]: " + chosenCell.getX());
				System.out.println("Cell [Y]: " + chosenCell.getY());
				
						// Army creation
						int size;
						System.out.print("Size of army: ");
						if (chosenCell.getBiome().equals(new Mountain()) || chosenCell.getBiome().equals(new Desert()) ) {
							size = getRandomNumberInRange(1, 3);
							System.out.println(size);
						}
						else {
							size = getRandomNumberInRange(1, 5);
							System.out.println(size);
						}
					 
						
						Character army = null;
						try {
							army = new Army(size, chosenCell);
						} catch (ParmsNotCompatibleException e) { }
				
				// Deploy !!!!!!!!!!!!!!!!
				deploy(player, army, chosenCell);
				showArmies(player);
			}
			 // Collect !!!!!!!!!!!!!!!!!
			collect(player);
			System.out.println("Resources collected!");
			
			showResources(player);
			
			// Convert !!!!!!!!!!!!!!!!!!
			
			
			
			int nbResourceTmp = totalNbResources(player);
			
				
				System.out.print("Convert ? [y/n]: ");
				answer = getRandomYN();
				System.out.println(answer);
				
				int nbResource;
				int selectedResource;
				
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
				} // fin du while
				
			// Distribute !!!!!!!!!!
			distribute(player);
			System.out.println("Armies fed!\nYou have: " + wp.getFood() + " food left");
		 }
 
	
	 
}
