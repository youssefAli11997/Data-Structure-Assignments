package eg.edu.alexu.csd.datastructure.hangman.cs75;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

/**
 * @author youssefAli
 *
 */
public class Test {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		Scanner in = new Scanner(System.in);

		System.out.println("WELCOME TO HANGMAN GAME");
		System.out.println("You Have 5 Chances To Rescue The Man");
		System.out.println("Come on bro, It's easy  :D");

		Hangman game = new Hangman();

		String[] fileReaded = game.readFromFile();
		game.setDictionary(fileReaded);
		game.selectRandomSecretWord();
		game.setMaxWrongGuesses(Integer.valueOf(5));

		// System.out.println(game.secretWord);

		int wrongSoFar = 0;

		boolean lose = false, win = false;

		while (!lose && !win) {
			System.out.println(game.getDashedWord());
			System.out.println("Guess What?");
			char c = in.nextLine().charAt(0);
			String res = game.guess(Character.valueOf(c));
			if (res == null) {
				lose = true;
				break;
			} else if (game.isRightGuess()) {
				if (game.isWinningEnd()) {
					win = true;
					break;
				}
			} else { // wrong
				wrongSoFar++;
				System.out.println("Wrongs: " + wrongSoFar);
				if (wrongSoFar == 5) {
					lose = true;
					break;
				}
			}
		}

		if (win)
			System.out.println(game.getSecretWord()
					+ "\nYeah! You did it, man !");
		else
			System.out.println("Oh, you have better than that !\nIt's "
					+ game.getSecretWord());

	}
}