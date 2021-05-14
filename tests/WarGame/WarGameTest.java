package WarGame;

import static org.junit.Assert.*;

import org.junit.*;

import Game.*;
import Game.util.*;
import WarGame.util.biomes.*;

public class WarGameTest {
	
	private WarPlayer p ;
	private WarGame game ;
	private Biome biome ;
	private Cell cell ;
	private Army a;
	private Resource resource ;

	@Before
	public void before() throws ParmsNotCompatibleException {
		this.game = new WarGame(5, 10, 10) ;
		this.p = new WarPlayer("BARRY") ;
		this.biome = new Mountain() ;
		this.cell = new Cell(8, 5, this.biome) ;
		this.a = new Army(3, this.cell) ;
		this.resource = this.biome.resource() ;
	}
	
	@Test
	public void testAddPlayer() {
		
		assertFalse(game.getPlayers().contains(p)) ;
		
		assertTrue(game.addPlayers(p)) ;
		
		assertTrue(game.getPlayers().contains(p)) ;
	}
	
	@Test
	public void testDeploy() {
		
		assertTrue(game.addPlayers(p)) ;
		
		assertEquals(game.getPlayers().get(0).getCharacters().size(), 0) ;
		assertEquals(this.p.getNbWarriors(), 35) ;
		assertEquals(this.cell.getCharacter(), null) ;
		
		game.deploy(p, a, cell);
		
		assertEquals(game.getPlayers().get(0).getCharacters().size(), 1) ;
		assertEquals(this.p.getNbWarriors(), 35) ;
		assertEquals(this.cell.getCharacter(), a) ;
	}
	
	@Test
	public void testCollect() {
		this.p.addCharacter(this.a) ;
		this.game.addPlayers(this.p) ;
		
		this.game.getPlayers().get(0).initResource(this.resource.toString()) ;
		
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 0) ;
		
		this.game.collect(this.game.getPlayers().get(0));
		
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 1) ;
		
		this.game.collect(this.game.getPlayers().get(0));
		
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 2) ;
	}
	
	@Test
	public void testConvert() {
		int nbResource = 3 ;
		
		this.p.addCharacter(this.a) ;
		this.game.addPlayers(this.p) ;
		this.game.getPlayers().get(0).initResource(this.resource.toString()) ;
		
		
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 0) ;
		assertFalse(this.game.convert(this.p, this.resource, nbResource)) ;
		assertEquals(this.p.getFood(), 10) ;
		
		this.game.collect(this.game.getPlayers().get(0));
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 1) ;
		assertFalse(this.game.convert(this.p, this.resource, nbResource)) ;
		
		this.game.collect(this.game.getPlayers().get(0));
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 2) ;
		assertFalse(this.game.convert(this.p, this.resource, nbResource)) ;
		
		this.game.collect(this.game.getPlayers().get(0));
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 3) ;
		assertTrue(this.game.convert(this.p, this.resource, nbResource)) ;
		
		assertEquals(this.game.getPlayers().get(0).getNbResource(this.resource.toString()), 0) ;
	}
	
	@Test
	public void testDistribute() {
		
		this.p.addCharacter(this.a) ;
		
		assertEquals(this.a.cost(), 5) ;
		assertEquals(this.p.getGold(), 0) ;
		assertEquals(this.p.getCharacters().get(0).getNbGold(), 0) ;
		
		game.distribute(p) ;
	}

}
