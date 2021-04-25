package WarGame;

import static org.junit.Assert.*;

import org.junit.Test;


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
	
	

}
