package WarGame;
import java.util.Scanner;
import java.util.*;
import Game.*;
import WarGame.*;
public class WarGameMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Player> players = new ArrayList<Player>();
		System.out.print("Nombre de joueurs: ");
		int nbPlayers = scan.nextInt();
		String name;
		for (int i=0; i<nbPlayers; i++) {
			System.out.print("Nom: ");
			name = scan.next();
			players.add(new WarPlayer(name));
		}
		
		
		System.out.print("Tours: ");
		int tours = scan.nextInt();
		Game myGame = new WarGame(players, tours);
		System.out.println("Debut Game: ");
		myGame.play();
	}

}
