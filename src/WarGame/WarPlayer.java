package WarGame;


import Game.Player;
import Game.Character;

public class WarPlayer extends Player {
	
	private int nbWarriors;
	private int food;
	
	public WarPlayer(String name) {
		super(name, 0);
		this.nbWarriors = 35;
		this.food = 10;
	}
	
	public int getNbWarriors(){
		return this.nbWarriors;
	}
	
	public int getFood() {
		return this.food;
	}
	
	public void addFood(int food) {
		this.food += food;
	}
	
	public void removeWarriors(int nbWarriors) {
		this.nbWarriors -= nbWarriors;
	}
	
	public void consumeFood(int nbFood) {
		this.food -= nbFood;
	}
	
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
