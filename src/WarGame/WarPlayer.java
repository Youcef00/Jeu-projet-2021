package WarGame;


import Game.Player;
import Game.Character;

public class WarPlayer extends Player {
	
	private int nbWarriors;
	private int food;
	
	/*
	 * the constructor
	 */
	public WarPlayer(String name) {
		super(name, 0);
		this.nbWarriors = 35;
		this.food = 10;
	}
	
	/**
	 * the number of warriors getter method
	 * @return (int) the number of warriors dor player
	 */
	public int getNbWarriors(){
		return this.nbWarriors;
	}
	
	/**
	 * the number of food getter method
	 * @return (int) the number of food
	 */
	public int getFood() {
		return this.food;
	}
	
	/**
	 * the method that allowing us add the food for player
	 * @param food (int) the number of food that we want to add for player
	 */
	public void addFood(int food) {
		this.food += food;
	}
	
	/**
	 * the method that allowing us to remove the food for player
	 * @param food (int) the number of food that we want to remove for player
	 */
	public void removeWarriors(int nbWarriors) {
		this.nbWarriors -= nbWarriors;
	}
	
	/**
	 * the method that allowing player to consume the food
	 * @param nbFood (int) the number of food that he want consume
	 */
	public void consumeFood(int nbFood) {
		this.food -= nbFood;
	}
	
	@Override
	public int calculateScore() {
		int score = this.getGold();
		for(Character a : this.characters) {
			//System.out.println("- " + score);
			//System.out.println("biome: " + a.getCell().getBiome().score());
			score += a.getNbGold();
			score += a.getCell().getBiome().score();	
		}
		if (this.characters.size() >= 10) {
			score += 5;
		}
		return score;
	}
}
