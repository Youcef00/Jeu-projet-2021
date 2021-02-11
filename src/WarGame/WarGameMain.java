package WarGame;

import java.util.*;
import Game.*;
import WarGame.*;
public class WarGameMain {

	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();
		players.add(new WarPlayer("Youcef"));
		Game myGame = new WarGame(players, 3);
		System.out.println("Debut Game: ");
		myGame.play();
	}

}
