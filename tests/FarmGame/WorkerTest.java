package FarmGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import FarmGame.util.biomes.Mountain;
import Game.Cell;
import Game.util.*;

public class WorkerTest {
	
	private Biome biome ;
	private Cell cell ;
	private Worker w ;
	
	@Before
	public void before() throws ParmsNotCompatibleException {
		this.biome = new Mountain() ;
		this.cell = new Cell(2, 3, biome) ;
		this.w = new Worker(cell) ;
	}
	

	@Test
	public void testAddGold()  {
		
		assertEquals(this.w.getNbGold(), 0) ;
		
		this.w.addGold(10) ;
		
		assertEquals(this.w.getNbGold(), 10) ;
	}
	
	@Test
	public void testCost() {
		assertEquals(this.w.cost(), 5) ;
	}

}
