package eg.edu.alexu.csd.datastructure.hangman.cs75;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

;

public class Hangman implements IHangman {

	private String[] words;
	private String secretWord;
	private String dash;
	private int maxWrongGuesses;
	private int wrongGuesses;
	private boolean rightGuess;

	public void setDictionary(String[] words) {
		this.words = words;
	}

	public String selectRandomSecretWord() {
		Random rnd = new Random();
		int randomIndex;
		do {
			try {
				randomIndex = rnd.nextInt(this.words.length);
			} catch (Exception e) {
				return null;
			}
			this.secretWord = this.words[randomIndex];

		} while (secretWord == null);
		this.dash = "";
		for (int i = 0; i < secretWord.length(); i++)
			dash += "-";
		return secretWord;
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.hangman.IHangman#guess(java.lang.Character)
	 */
	public String guess(Character c) {
		if (this.wrongGuesses == this.maxWrongGuesses)
			return null;

		if (c == null)
			return dash;

		char[] temp = this.dash.toCharArray();
		char userLetter = c.charValue();
		char currLetter;

		boolean flag = false;

		for (int i = 0; i < dash.length(); i++) {
			currLetter = this.secretWord.charAt(i);
			if (Character.toLowerCase(userLetter) == Character
					.toLowerCase(currLetter)) {
				temp[i] = currLetter;
				flag = true;
			}
		}

		if (!flag) {
			this.wrongGuesses++;
			this.rightGuess = false;
			if (this.wrongGuesses == this.maxWrongGuesses)
				return null;
			else
				return dash;
		} else {
			this.rightGuess = true;
			this.dash = String.valueOf(temp);
			return dash;
		}
	}/* end of guess function */

	public void setMaxWrongGuesses(Integer max) {
		this.maxWrongGuesses = max.intValue();
	}

	public String getDashedWord() {
		return this.dash;
	}

	public String getSecretWord() {
		return this.secretWord;
	}

	public boolean isRightGuess() {
		return this.rightGuess;
	}

	public boolean isWinningEnd() {
		for (int i = 0; i < this.dash.length(); i++)
			if (this.dash.charAt(i) == '-')
				return false;
		return true;
	}

	public String[] readFromFile() throws FileNotFoundException, IOException {
		String fileName = "src\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs75\\dictionary.txt";
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(fileName));
			String word;
			String[] ss = new String[100000];
			int it = 0;
			while ((word = bfr.readLine()) != null)
				ss[it++] = word;

			bfr.close();
			return ss;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return null;
	}

}