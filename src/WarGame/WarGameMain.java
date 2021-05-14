package WarGame;

import Game.*;
import Game.util.*;

public class WarGameMain {

	public static void main(String[] args) {
		
		System.out.print("Tours: ");
		int tours = Input.readInt();
		System.out.print("Width: ");
		int width  = Input.readInt();
		System.out.print("Height: ");
		int height  = Input.readInt();
		Game myGame = new WarGame(tours, width, height);
		
		System.out.print("Nombre de joueurs: ");
		int nbPlayers = Input.readInt();
		String name;
		for (int i=0; i<nbPlayers; i++) {
			System.out.print("Nom: ") ;
			name = Input.readString() ;
			myGame.addPlayers(new WarPlayer(name)) ;
		}
		
		System.out.println("Debut Game: ");
		myGame.play();
	}

}
