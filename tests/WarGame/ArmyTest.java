package WarGame;

import static org.junit.Assert.*;

import org.junit.* ;

import Game.Cell ;
import Game.util.*;
import WarGame.util.biomes.* ;


public class ArmyTest {
	
	private Biome biome ;
	private Cell cell ;
	private Army a ;
	
	@Before
	public void before() throws ParmsNotCompatibleException {
		this.biome = new Desert() ;
		this.cell = new Cell(2, 3, biome) ;
		this.a = new Army(1, this.cell) ;
	}

	@Test
	public void testAddGold() {
		assertEquals(this.a.getNbGold(), 0) ;
		
		this.a.addGold(15) ;
		this.a.addGold(-5) ;
		
		assertEquals(this.a.getNbGold(), 10) ;
	}
	
	@Test
	public void testAddWariors() {
		assertEquals(this.a.getSize(), 1) ;
		
		this.a.addWarriors(1) ;
		
		assertEquals(this.a.getSize(), 2) ;
	}
	
	@Test
	public void testAddWariorsException() throws ParmsNotCompatibleException{
		assertEquals(this.a.getSize(), 1) ;
		
		this.a.addWarriors(3) ;
	}
	
	@Test
	public void testCost() {
		assertEquals(this.a.cost(), 2) ;
	}

}
