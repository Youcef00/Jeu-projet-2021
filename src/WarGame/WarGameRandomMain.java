package WarGame;

import java.util.ArrayList;
import java.util.List;

import Game.Game;
import Game.Player;


public class WarGameRandomMain {

	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();
		
		
		String name;
		for (int i=0; i<args.length; i++) {
			name = args[i];
			players.add(new WarPlayer(name));
		}
		
		
		
		final int TOURS = 5;
		final int WIDTH  = 10;
		final int HEIGHT  = 10;
		
		System.out.println("Rounds: "+ TOURS);
		System.out.println("Width: "+ WIDTH);
		System.out.println("Height: "+ HEIGHT);
		
		Game myGame = new WarGameRandom(players, TOURS, WIDTH, HEIGHT);
		System.out.println("Debut Game: ");
		myGame.play();

	}

}