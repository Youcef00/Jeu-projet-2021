package util.tiles;

import util.characters.Army;
import util.resources.Resource;

// Abstract classe c'est pas mieux ? pour rajouter des attributs ?

public interface Tile {
	public void toHarvest();
	public boolean addArmy(Army army);
	public boolean isBusy();
	public int getIndex();
	public Resource getResource();
	
}
