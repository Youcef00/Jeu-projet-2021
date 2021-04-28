package WarGame;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.Cell;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import WarGame.util.biomes.Desert;


public class WarPlayerTest {
	
	
	@Test
	public void testAddFood() {
		/* Player initialization */
		WarPlayer p = new WarPlayer("BARRY") ;
		
		/* initial state check */
		assertEquals(p.getFood(), 10) ;
		
		/* application of the addFood method */
		p.addFood(5) ;
		
		/* method verification */
		assertEquals(p.getFood(), 15) ;
	}
	
	@Test
	public void testRemoveWarriors() {
		/* Player initialization */
		WarPlayer p = new WarPlayer("BARRY") ;
		
		/* initial state check */
		assertEquals(p.getNbWarriors(), 35) ;
		
		/* application of the removeWarriors() method */
		p.removeWarriors(10) ;
		
		/* method verification */
		assertEquals(p.getNbWarriors(), 25) ;
	}
	
	@Test
	public void testConsumeFood() {
		/* Player initialization */
		WarPlayer p = new WarPlayer("BARRY") ;
		
		/* initial state check */
		assertEquals(p.getFood(), 10) ;
		
		/* application of the removeWarriors() method */
		p.consumeFood(3) ;
		
		/* method verification */
		assertEquals(p.getFood(), 7) ;
	}
	
	@Test
	public void testAddCharacter() throws ParmsNotCompatibleException {
		WarPlayer p = new WarPlayer("BARRY") ;
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Army a = new Army(2, cell) ;
		Army a1 = new Army(1, cell) ;
		
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(a) ;
		p.addCharacter(a1) ;
		
		assertEquals(p.getCharacters().size(), 2) ;
		assertEquals(p.getCharacters().get(0), a) ;
	}
	
	@Test
	public void testRemoveCharacter() throws ParmsNotCompatibleException {
		WarPlayer p = new WarPlayer("BARRY") ;
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Army a = new Army(2, cell) ;
		Army a1 = new Army(1, cell) ;
		
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
		/*assertEquals(p.getCharacters().get(0), a) ;*/
		assertEquals(p.getCharacters().get(0), a1) ;
	}
	
	

}
