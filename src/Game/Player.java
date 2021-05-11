package Game;

import java.util.*;

/**
 * mother class of players which will allow us to code all the players for each game
*/

public abstract class Player {
	
	/* the name attribute */
	protected String name ;
	
	/* the gold attribute */
	protected int gold ;
	
	/* the list of Character attribute */
	protected List<Character> characters ;
	
	/* the list of resource attribute */
	protected Map<String, Integer> resources ;
	
	/**
	 * the constructor of the player class which takes a name and a number as a parameter
	 * @param name (string) the name of player
	 * @param gold (int) the number of gold 
	*/
	public Player(String name, int gold) {
		this.name = name;
		this.gold = gold;
		this.characters = new ArrayList<Character>();
		this.resources = new HashMap<String, Integer>();
	}
	
	/**
	 * the name getter method which returns the player's name to us
	 * @return (string) the name of player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * the name getter method which returns the player's name to us
	 * @return (int) the number of gold for player
	 */
	public int getGold() {
		return this.gold;
	}
	
	/**
	 * the add gold method which allows us to add gold for the player
	 * @param nbGold (int) the number of gold we want to add for a player
	 */
	public void addGold(int nbGold) {
		this.gold += nbGold;
	}
	
	/**
	 * the method that allows us to add a Character for a player
	 * @param character (Character) the Character we want to add
	 */
	public void addCharacter(Character character) {
		this.characters.add(character);
	}
	
	/**
	 * the method allowing us to remove a character for a player
	 * @param character (Character) the Character we want to remove
	 */
	public void removeCharacter(Character character) {
		this.characters.remove(character);
		character.getCell().removeCharacter();
	}
	
	/**
	 * the Characters getter method which returns the player's Characters to us
	 * @return (List<Character>) the collection of Characters for player
	 */
	public List<Character> getCharacters(){
		return this.characters;
	}
	
	/**
	 * The method initResource that initializing a Resource for a player
	 * @param nameResource (string) the name of resource that initializing
	 */
	public void initResource(String nameResource) {
		this.resources.put(nameResource, 0);
	}
	
	/**
	 * the method that allows us to add a Resource for a player
	 * @param nameResource (string) the name of resource that we want to add
	 * @param nbResource (int) the number of resource that we want to add
	 */
	public void addNbResource(String nameResource, int nbResource) {
		this.resources.put(nameResource, this.resources.get(nameResource)+nbResource);
	}
	
	/**
	 * the number of Resource getter method which returns the player's number of resource to us
	 * @param nameResource (string) the name of the resource whose name we want to know
	 * @return (int) the number of resource
	 */
	public int getNbResource(String nameResource) {
		return this.resources.get(nameResource);
	}
	
	/**
	 * the Resources getter method which returns the player's Resource to us
	 * @return (Map<String, Integer>) the map of resource that us player
	 */
	public Map<String, Integer> getResources() {
		return this.resources;
	}
	
	/**
	 * the equals method which compares two players
	 * @return (boolean) true if both players are equal and false otherwise
	 */
	public boolean equals(Object o) {
		if (!( o instanceof Player)) {
			return false ;
		}
		else {
			Player other = (Player) o ;
            return (this.name == other.name) &&  (this.gold == other.gold) ; 

		}
	}
	
	/**
	 * the method that calculates the score for each player (inheriting from the parent class)
	 * @return (int) the final score returned after the game
	 */
	public abstract int calculateScore();
}
