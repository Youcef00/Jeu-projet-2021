package FarmGame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Game.Cell;
import Game.Player;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import WarGame.util.biomes.Desert;

public class FarmGameTest {

	@Test
	public void testAddPlayer() {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		List<Player> players = new ArrayList<Player>() ;
		FarmGame game = new FarmGame(players, 2, 4, 5) ;
		
		assertFalse(game.getPlayers().contains(p)) ;
		
		assertTrue(game.addPlayers(p)) ;
		
		assertFalse(game.addPlayers(p)) ;
	}
	
	@Test
	public void testDeploy() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		List<Player> players = new ArrayList<Player>() ;
		FarmGame game = new FarmGame(players, 2, 4, 5) ;
		
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		
		Worker w = new Worker(cell) ;
		
		assertTrue(cell.isFree()) ;
		assertEquals(cell.getCharacter(), null) ;
		assertFalse(p.getCharacters().contains(w)) ;
		
		game.deploy(p, w, cell);
		
		assertFalse(cell.isFree()) ;
		assertEquals(cell.getCharacter(), w) ;
		assertTrue(p.getCharacters().contains(w)) ;
	}
}
