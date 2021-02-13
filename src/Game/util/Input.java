package Game.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	private static Scanner myScan = new Scanner(System.in);
	
		public static int readInt() {
			int answer = 0;
			boolean correctAnswer = false;
			while (!correctAnswer) {
				try {
					answer = myScan.nextInt();
					correctAnswer = true;
				} catch (InputMismatchException e) {
					System.out.print("Wrong! Please insert Integer: ");
					myScan.next();
					continue;
				}
			}
			return answer;
		}
		
		public static String YNString() {
			String answer = "";
			boolean correctAnswer = false;
			while (!correctAnswer) {
				try {
					answer = myScan.next();
					if (!answer.equals("y") && !answer.equals("n")) {
						throw new InputMismatchException();
					}
					correctAnswer = true;
				} catch (InputMismatchException e) {
					System.out.print("Wrong! Please insert [y/n]: ");
					myScan.next();
					continue;
				}
			}
			return answer;
		}
		
		public static String readString() {
			String answer = "";
			boolean correctAnswer = false;
			while (!correctAnswer) {
				try {
					answer = myScan.next();
					correctAnswer = true;
				} catch (InputMismatchException e) {
					System.out.print("Wrong! Please insert String: ");
					myScan.next();
					continue;
				}
			}
			return answer;
		}
}
