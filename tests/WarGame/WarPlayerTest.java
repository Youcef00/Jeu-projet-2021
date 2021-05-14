package WarGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.Cell;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import WarGame.util.biomes.Desert;


public class WarPlayerTest {
	
	private WarPlayer p ;
	private Biome biome ;
	private Cell cell ;
	private Army a ;
	private Army a1 ;
	
	@Before
	public void before() throws ParmsNotCompatibleException {
		this.p = new WarPlayer("BARRY") ;
		this.biome = new Desert() ;
		this.cell = new Cell(3, 5, biome) ;
		this.a = new Army(2, cell) ;
		this.a1 = new Army(1, cell) ;
	}
	
	@Test
	public void testAddGoldAndCalculateScore() {
		/* Test the method Add Gold */
		assertEquals(p.getGold(), 0) ;
		
		p.addGold(15) ;
		
		assertEquals(p.getGold(), 15) ;
		
		/* Test the method Calculate Score */
		p.addCharacter(a) ;
		
		assertEquals(p.getCharacters().get(0).getNbGold(), 0) ;
		assertEquals(p.calculateScore(), 19) ;
		
		p.getCharacters().get(0).addGold(10) ;
		
		assertEquals(p.getCharacters().get(0).getNbGold(), 10) ;
		assertEquals(p.calculateScore(), 29) ;

	}
	
	
	@Test
	public void testAddFood() {
		/* initial state check */
		assertEquals(p.getFood(), 10) ;
		
		/* application of the addFood method */
		p.addFood(5) ;
		
		/* method verification */
		assertEquals(p.getFood(), 15) ;
	}
	
	@Test
	public void testRemoveWarriors() {
		/* initial state check */
		assertEquals(p.getNbWarriors(), 35) ;
		
		/* application of the removeWarriors() method */
		p.removeWarriors(10) ;
		
		/* method verification */
		assertEquals(p.getNbWarriors(), 25) ;
	}
	
	@Test
	public void testConsumeFood() {
		/* initial state check */
		assertEquals(p.getFood(), 10) ;
		
		/* application of the removeWarriors() method */
		p.consumeFood(3) ;
		
		/* method verification */
		assertEquals(p.getFood(), 7) ;
	}
	
	@Test
	public void testAddCharacter() throws ParmsNotCompatibleException {
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(a) ;
		p.addCharacter(a1) ;
		
		assertEquals(p.getCharacters().size(), 2) ;
		assertEquals(p.getCharacters().get(0), a) ;
	}
	
	@Test
	public void testRemoveCharacter() throws ParmsNotCompatibleException {
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(a) ;
		
		assertEquals(p.getCharacters().size(), 1) ;
		assertEquals(p.getCharacters().get(0), a) ;
		
		p.removeCharacter(a) ;
		
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(a) ;
		p.addCharacter(a1) ;
		
		p.removeCharacter(a) ;
		
		assertEquals(p.getCharacters().size(), 1) ;
		
		assertEquals(p.getCharacters().get(0), a1) ;
	}
	
}
