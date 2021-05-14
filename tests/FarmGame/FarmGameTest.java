package FarmGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.* ;
import Game.util.*;
import FarmGame.util.biomes.*;

public class FarmGameTest {
	
	private FarmPlayer p ;
	private FarmGame game ;
	private Biome biome ;
	private Cell cell ;
	private Worker w ;
	private Resource r ;
	
	@Before
	public void before() throws ParmsNotCompatibleException {
		this.p = new FarmPlayer("BARRY") ;
		this.game = new FarmGame(2, 4, 5) ;
		this.biome = new Desert() ;
		this.cell = new Cell(2, 3, biome) ;
		this.w = new Worker(cell) ;
		this.r = biome.resource() ;
	}

	@Test
	public void testAddPlayer() {
		assertFalse(game.getPlayers().contains(p)) ;
		
		assertTrue(game.addPlayers(p)) ;
		
		assertFalse(game.addPlayers(p)) ;
	}
	
	@Test
	public void testDeploy() {
		assertTrue(cell.isFree()) ;
		assertEquals(cell.getCharacter(), null) ;
		assertFalse(p.getCharacters().contains(w)) ;
		
		game.deploy(p, w, cell);
		
		assertFalse(cell.isFree()) ;
		assertEquals(cell.getCharacter(), w) ;
		assertTrue(p.getCharacters().contains(w)) ;
	}
	
	@Test
	public void testCollect() {
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
	public void testConvert() {
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
		assertEquals(p.getGold(), 30) ;
	}
	
	@Test
	public void testDistribute() {
		
		p.addCharacter(w);
		
		assertEquals(w.cost(), 3) ;
		assertEquals(p.getGold(), 15) ;
		assertEquals(w.getNbGold(), 0) ;
		
		game.distribute(p);
		
		assertEquals(w.cost(), 3) ;
		assertEquals(p.getGold(), 12) ;
		assertEquals(w.getNbGold(), 3) ;
		
		
	}
	
}
