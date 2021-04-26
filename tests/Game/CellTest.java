package Game;


import static org.junit.Assert.*;


import org.junit.Test;

import FarmGame.Worker;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import WarGame.util.biomes.Desert;
import WarGame.util.biomes.Mountain;
import WarGame.util.biomes.Ocean;

public class CellTest {

	@Test
	public void testIsFreeAndAddCharacter() throws ParmsNotCompatibleException {
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		Worker w = new Worker(cell) ;
		
		assertTrue(cell.isFree()) ;
		assertEquals(cell.getCharacter(), null) ;
		
		cell.addCharacter(w) ;
		
		assertFalse(cell.isFree()) ;
		assertEquals(cell.getCharacter(), w) ;
	}
	
	@Test
	public void testRemoveCharacter() throws ParmsNotCompatibleException {
		Biome biome = new Ocean() ;
		Cell cell = new Cell(2, 3, biome) ;
		Worker w = new Worker(cell) ;
		
		assertTrue(cell.isFree()) ;
		
		cell.addCharacter(w) ;
		
		assertFalse(cell.isFree()) ;
		
		cell.removeCharacter();
		
		assertTrue(cell.isFree()) ;
	}
	
	@Test
	public void testsetBiome() throws ParmsNotCompatibleException{
		Biome biome = new Desert() ;
		Cell cell = new Cell(2, 3, biome) ;
		
		assertEquals(cell.getBiome(), biome) ;
		
		Biome b = new Mountain() ;
		
		cell.setBiome(b) ;
		
		assertEquals(cell.getBiome(), b) ;
	}

}
