package FarmGame;

import static org.junit.Assert.*;

import org.junit.* ;

import FarmGame.FarmPlayer;
import Game.Cell;
import Game.util.*;
import WarGame.util.biomes.Desert;

public class FarmPlayerTest {
	
	private FarmPlayer p ;
	private Biome biome ;
	private Cell cell ;
	private Worker w ;
	private Resource r ;
	
	@Before
	public void before() throws ParmsNotCompatibleException {
		this.p = new FarmPlayer("BARRY") ;
		this.biome = new Desert() ;
		this.cell = new Cell(2, 3, biome) ;
		this.w = new Worker(cell) ;
		this.r = this.biome.resource() ;
	}

	@Test
	public void testAddGoldAndCalculateScore() {
		/* Test the method add gold */
		assertEquals(p.getGold(), 15) ;
		
		p.addGold(20) ;
		
		assertEquals(p.getGold(), 35) ;
		
		/* Test the method that calculate score */
		p.addCharacter(w) ;
		
		assertEquals(p.calculateScore(), 35) ;
		assertEquals(p.getCharacters().get(0).getNbGold(), 0) ;
		
		p.getCharacters().get(0).addGold(25);
		
		assertEquals(p.getCharacters().get(0).getNbGold(), 25) ;
		assertEquals(p.calculateScore(), 60) ;
		
	}
	
	@Test
	public void testAddCharacter() {
		
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(w) ;
		p.addCharacter(w) ;
		
		assertEquals(p.getCharacters().size(), 2) ;
		assertEquals(p.getCharacters().get(0), w) ;
	}
	
	@Test
	public void testRemoveCharacter() {
		
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(w) ;
		
		assertEquals(p.getCharacters().size(), 1) ;
		assertEquals(p.getCharacters().get(0), w) ;
		
		p.removeCharacter(w) ;
		
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(w) ;
		p.addCharacter(w) ;
		
		p.removeCharacter(w) ;
		
		assertEquals(p.getCharacters().size(), 1) ;
		assertEquals(p.getCharacters().get(0), w) ;
	}
	
	@Test
	public void testInitResource() {
		assertEquals(p.getResources().size(), 0) ;
		
		p.initResource("Sand") ;
		
		assertEquals(p.getResources().size(), 1) ;
		
		p.initResource("Rock") ;
		
		assertEquals(p.getResources().size(), 2) ;
	}
	
	@Test
	public void testAddNbResource() {
		
		p.initResource(r.toString());
		assertEquals(p.getNbResource(r.toString()), 0) ;
		
		p.addNbResource(r.toString(), 2) ;
		assertEquals(p.getNbResource(r.toString()), 2) ;
	}

	
}

