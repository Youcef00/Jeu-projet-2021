package FarmGame;

import java.util.ArrayList;
import java.util.List;


import Game.Game;
import Game.Player;
import Game.util.*;

public class FarmGameMain {
	public static void main(String[] args) {
		
		List<Player> players = new ArrayList<Player>();
		System.out.print("Nombre de joueurs: ");
		int nbPlayers = Input.readInt();
		String name;
		for (int i=0; i<nbPlayers; i++) {
			System.out.print("Nom: ");
			name = Input.readString();
			players.add(new FarmPlayer(name));
		}
		
		
		System.out.print("Tours: ");
		int tours = Input.readInt();
		System.out.print("Width: ");
		int width  = Input.readInt();
		System.out.print("Height: ");
		int height  = Input.readInt();
		Game myGame = new FarmGame(players, tours, width, height);
		System.out.println("Debut Game: ");
		myGame.play();
	}
}
