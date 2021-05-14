package FarmGame;

import Game.Game;


/**
 * the class which implements the main of FarmGame Random
 */
public class FarmGameRandomMain {
	
	

	public static void main(String[] args) {
		
		final int TOURS = 5;
		final int WIDTH  = 10;
		final int HEIGHT  = 10;
		
		Game myGame = new FarmGameRandom(TOURS, WIDTH, HEIGHT);
		
		String name;
		for (int i=0; i<args.length; i++) {
			name = args[i];
			myGame.addPlayers(new FarmPlayer(name));
		}
		
		System.out.println("Rounds: "+ TOURS);
		System.out.println("Width: "+ WIDTH);
		System.out.println("Height: "+ HEIGHT);
		
		
		System.out.println("Debut Game: ");
		myGame.play();

	}
}
