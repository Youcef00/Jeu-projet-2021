package Game;

import java.util.*;

public abstract class Player {
	
	protected String name;
	protected int gold;
	protected List<Character> characters;
	protected Map<String, Integer> resources;
	
	public Player(String name, int gold) {
		this.name = name;
		this.gold = gold;
		this.characters = new ArrayList<Character>();
		this.resources = new HashMap<String, Integer>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void addGold(int nbGold) {
		this.gold += nbGold;
	}
	
	public void addCharacter(Character character) {
		this.characters.add(character);
	}
	
	public void removeCharacter(Character character) {
		this.characters.remove(character);
		character.getCell().removeCharacter();
	}
	
	public List<Character> getCharacters(){
		return this.characters;
	}
	
	public void initResource(String nameResource) {
		this.resources.put(nameResource, 0);
	}
	
	public void addNbResource(String nameResource, int nbResource) {
		this.resources.put(nameResource, this.resources.get(nameResource)+nbResource);
	}
	
	public int getNbResource(String nameResource) {
		return this.resources.get(nameResource);
	}
	
	public Map<String, Integer> getResources(){
		return this.resources;
	}
	
	public boolean equals(Object o) {
		if (!( o instanceof Player)) {
			return false ;
		}
		else {
			Player other = (Player) o ;
            return (this.name == other.name) &&  (this.gold == other.gold) ; 

		}
	}
	
	public abstract int calculateScore();
}
