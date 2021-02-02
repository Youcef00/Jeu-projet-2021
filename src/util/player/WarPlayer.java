package util.player;

import java.util.List;
import util.characters.Army;

public class WarPlayer extends Player {

	protected int food;
	
	protected int nbWarriors;
	protected List<Army> army; // a revoir
	
	public WarPlayer(String name) {
		super(name, 0);
		this.food = 10;
		this.nbWarriors = 35;		
	}

	public WarPlayer(String name, int nbFood, int nbWarriors) {
		super(name, 0);
		this.food = nbFood;
		this.nbWarriors = nbWarriors;		
	}
	
	public int getFood() {
		return food;
	}
	
	public void addFood(int nbFood) {
		food += nbFood;
	}
	
	
	@Override
	public String toString() {
		return "WarPlayer [gold=" + gold + ", food=" + food + ", nbWarriors=" + nbWarriors + "]";
	}

	
	
}
