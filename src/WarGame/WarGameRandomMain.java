package WarGame;

import Game.Game;


public class WarGameRandomMain {

	public static void main(String[] args) {
		
		final int TOURS = 5;
		final int WIDTH  = 10;
		final int HEIGHT  = 10;
		
		System.out.println("Rounds: "+ TOURS);
		System.out.println("Width: "+ WIDTH);
		System.out.println("Height: "+ HEIGHT);
		
		Game myGame = new WarGameRandom(TOURS, WIDTH, HEIGHT);
		
		
		String name;
		for (int i=0; i<args.length; i++) {
			name = args[i];
			myGame.addPlayers(new WarPlayer(name));
		}
		
		System.out.println("Debut Game: ");
		myGame.play();

	}

}
