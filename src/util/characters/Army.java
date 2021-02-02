package util.characters;

import util.tiles.Tile;

public class Army {
	protected int gold;
	protected int nbWarriors;
	protected Tile tile;
	
	
	public Army(int nbWarriors, Tile tile) { // faire une exeption que nbWarriors n'est pas entre 1 et 5
		if (nbWarriors < 6) {
			this.nbWarriors = nbWarriors;
		}
		else {
			nbWarriors = 5;
		}
		this.tile = tile;
	}

	public int getGold() {
		return gold;
	}
	
	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public int getNbWarriors() {
		return nbWarriors;
	}

	public void addWarriors(int nbWarriors) {
		nbWarriors += nbWarriors;
	}
	
	public void moveArmy(Tile tile) { // exeption mauvaise cordonéés , ou tule océan
		// On regarde si la tuile n'est pas occupée
		if (! tile.isBusy()) {
			tile.addArmy(this);
			this.setTile(tile);
		}
	}
	
	
}
