package FarmGame;

import static org.junit.Assert.*;


import org.junit.Test;

import FarmGame.FarmPlayer;
import FarmGame.util.resources.Sand;
import Game.Cell;
import Game.util.Biome;
import Game.util.ParmsNotCompatibleException;
import Game.util.Resource;
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
	
	@Test
	public void testInitResource() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		
		
		assertEquals(p.getResources().size(), 0) ;
		
		p.initResource("Sand") ;
		
		assertEquals(p.getResources().size(), 1) ;
		
		p.initResource("Rock") ;
		
		assertEquals(p.getResources().size(), 2) ;
	}
	
	@Test
	public void testAddNbResource() throws ParmsNotCompatibleException {
		FarmPlayer p = new FarmPlayer("BARRY") ;
		Resource r = new Sand() ;
		
		p.initResource(r.toString());
		assertEquals(p.getNbResource(r.toString()), 0) ;
		
		p.addNbResource(r.toString(), 2) ;
		assertEquals(p.getNbResource(r.toString()), 2) ;
	}

	
}

