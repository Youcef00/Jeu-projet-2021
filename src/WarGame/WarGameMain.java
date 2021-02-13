package WarGame;

import java.util.*;
import Game.*;
import Game.util.*;

public class WarGameMain {

	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();
		System.out.print("Nombre de joueurs: ");
		int nbPlayers = Input.readInt();
		String name;
		for (int i=0; i<nbPlayers; i++) {
			System.out.print("Nom: ");
			name = Input.readString();
			players.add(new WarPlayer(name));
		}
		
		
		System.out.print("Tours: ");
		int tours = Input.readInt();
		System.out.print("Width: ");
		int width  = Input.readInt();
		System.out.print("Height: ");
		int height  = Input.readInt();
		Game myGame = new WarGame(players, tours, width, height);
		System.out.println("Debut Game: ");
		myGame.play();
	}

}
