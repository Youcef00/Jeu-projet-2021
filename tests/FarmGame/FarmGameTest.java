package FarmGame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import FarmGame.util.resources.*;
import Game.* ;
import Game.util.*;
import FarmGame.util.biomes.*;

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
	
	@Test
	public void testCollect() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		
		
		List<Player> players = new ArrayList<Player>() ;
		FarmGame game = new FarmGame(players, 2, 4, 5) ;
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Resource r = new Sand() ;
		Worker w = new Worker(cell) ;
		p.initResource(r.toString());
		assertTrue(game.addPlayers(p)) ;
		
		assertEquals(p.getNbResource(r.toString()), 0) ;
		
		game.deploy(p, w, cell);
		assertTrue(p.getCharacters().contains(w)) ;
		assertEquals(cell.getCharacter(), w) ;
		
		game.collect(p);
		assertEquals(p.getNbResource(r.toString()), 1) ;
	}
	
	@Test
	public void testConvert() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		
		
		List<Player> players = new ArrayList<Player>() ;
		FarmGame game = new FarmGame(players, 10, 9, 5) ;
		
		Biome biome = new Mountain() ;
		Cell cell = new Cell(2, 3, biome) ;
		Worker w = new Worker(cell) ;
		Resource r = biome.resource() ;
		
		int nbResource = 3 ;
		
		
		p.initResource(r.toString());
		
		assertTrue(game.addPlayers(p)) ;
		
		assertEquals(p.getNbResource(r.toString()), 0) ;
		assertEquals(p.getGold(), 15) ;
		
		/* Phase 1 */
		game.deploy(p, w, cell);
		assertTrue(p.getCharacters().contains(w)) ;
		assertEquals(cell.getCharacter(), w) ;
		
		game.collect(p);
		assertEquals(p.getNbResource(r.toString()), 1) ;
		assertFalse(game.convert(p, r, nbResource)) ;
		assertEquals(p.getGold(), 15) ;
		
		game.collect(p);
		assertEquals(p.getNbResource(r.toString()), 2) ;
		assertFalse(game.convert(p, r, nbResource)) ;
		assertEquals(p.getGold(), 15) ;
		
		game.collect(p);
		assertEquals(p.getNbResource(r.toString()), 3) ;
		boolean res = game.convert(p, r, nbResource) ;
		assertTrue(res) ;
		assertEquals(p.getGold(), 39) ;
	}
	
	
	
	@Test
	public void testDistribute() throws ParmsNotCompatibleException {
		
		FarmPlayer p = new FarmPlayer("BARRY") ;
		
		
		List<Player> players = new ArrayList<Player>() ;
		FarmGame game = new FarmGame(players, 8, 8, 5) ;
		
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Worker w = new Worker(cell) ;
		Resource r = biome.resource() ;
		
		assertTrue(game.addPlayers(p)) ;
		assertEquals(w.getCell(), cell) ;
		assertEquals(w.cost(), 3) ;
		assertEquals(p.getGold(), 15) ;
		
		game.distribute(p) ;
		assertEquals(p.getGold(), 15) ;
		
		
		
	}
	
}
