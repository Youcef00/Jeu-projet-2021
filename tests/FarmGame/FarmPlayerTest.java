package FarmGame;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.Cell;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import WarGame.Army;
import WarGame.util.biomes.Desert;

public class FarmPlayerTest {

	@Test
	public void testAddGold() {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		
		assertEquals(p.getGold(), 15) ;
		
		p.addGold(20) ;
		
		assertEquals(p.getGold(), 35) ;
	}
	
	@Test
	public void testAddCharacter() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Worker w = new Worker(cell) ;
		
		assertEquals(p.getCharacters().size(), 0) ;
		
		p.addCharacter(w) ;
		p.addCharacter(w) ;
		
		assertEquals(p.getCharacters().size(), 2) ;
		assertEquals(p.getCharacters().get(0), w) ;
	}
	
	@Test
	public void testRemoveCharacter() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Worker w = new Worker(cell) ;
		
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
	
	

}