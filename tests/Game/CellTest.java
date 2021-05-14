package Game;


import static org.junit.Assert.*;

import org.junit.*;

import FarmGame.Worker;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import WarGame.util.biomes.Desert;
import WarGame.util.biomes.Mountain;

public class CellTest {
	
	private Biome biome ;
	private Cell cell ;
	private Worker w ;
	private Biome b ;
	
	@Before
	public void before() throws ParmsNotCompatibleException {
		this.biome = new Desert() ;
		this.cell = new Cell(2, 3, biome) ;
		this.w = new Worker(cell) ;
		this.b = new Mountain() ;
	}

	@Test
	public void testIsFreeAndAddCharacter() {
		assertTrue(cell.isFree()) ;
		assertEquals(cell.getCharacter(), null) ;
		
		cell.addCharacter(w) ;
		
		assertFalse(cell.isFree()) ;
		assertEquals(cell.getCharacter(), w) ;
	}
	
	@Test
	public void testRemoveCharacter() {
		assertTrue(cell.isFree()) ;
		
		cell.addCharacter(w) ;
		
		assertFalse(cell.isFree()) ;
		
		cell.removeCharacter();
		
		assertTrue(cell.isFree()) ;
	}
	
	@Test
	public void testsetBiome() {
		assertEquals(cell.getBiome(), biome) ;
		
		cell.setBiome(b) ;
		
		assertEquals(cell.getBiome(), b) ;
	}

}
