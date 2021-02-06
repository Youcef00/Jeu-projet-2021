package WarGame;

import java.util.*;
import Game.Player;
import WarGame.util.*;

public class WarPlayer extends Player {
	
	private int nbWarriors;
	private int food;
	private List<Army> armies;
	
	public WarPlayer(String name) {
		super(name, 0);
		this.nbWarriors = 35;
		this.food = 10;
		this.armies = new ArrayList<Army>();
	}
	
	public int getNbWarriors(){
		return this.nbWarriors;
	}
	
	public int getFood() {
		return this.food;
	}
	
	public void removeWarriors(int nbWarriors) {
		this.nbWarriors -= nbWarriors;
	}
	
	public void consumeFood(int nbFood) {
		this.food -= nbFood;
	}
	
	public List<Army> getArmies() {
		return this.armies;
	}
	
	public void removeArmy(Army army) {
		this.armies.remove(army);
	}
	
	public void addArmy(Army army) {
		this.armies.add(army);
	}
	
	public int calculateScore() {
		int score = this.gold;
		Biome biome;
		for(Army a : armies) {
			score += a.getNbGold();
			biome = a.getCell().getBiome();
			if (biome == Biome.PLAIN) {
				score += 1;
			}
			else if (biome == Biome.FOREST) {
				score += 2;
			}
			else if (biome == Biome.MOUNTAIN) {
				score += 4;
			}
			else if (biome == Biome.DESERT) {
				score += 4;
			}
		}
		if (armies.size() >= 10) {
			score += 5;
		}
		return score;
	}
}
