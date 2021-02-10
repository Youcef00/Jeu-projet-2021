package FarmGame;

import java.util.List;

import Game.Cell;
import Game.Character;
import Game.Game;
import Game.Player;
import Game.util.Resource;

public class FarmGame extends Game {

	
	
	public FarmGame(List<Player> players, int nbRounds) {
		super(players,nbRounds) ;
	}
	
	@Override
	public void setBoard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deploy(Player player, Character character, Cell cell) {
		cell.addCharacter(character);
		player.addCharacter(character);
	}

	@Override
	public void collect(Player player) {
		Resource resource ;
		for (Character c: player.getCharacters()) {
			resource = c.getCell().getBiome().resource(); 
			player.addNbResource(resource.toString(), resource.loot());
		}
	}

	@Override
	public boolean convert(Player player, Resource resource, int nbResource) {
		if (player.getNbResource(resource.toString()) >= nbResource) {
			player.addGold(resource.loot());
			player.addNbResource(resource.toString(), -nbResource);
			return true ;
		}
		return false ;
	}

	@Override
	public void distribute(Player player) {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void playOneRound(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}
