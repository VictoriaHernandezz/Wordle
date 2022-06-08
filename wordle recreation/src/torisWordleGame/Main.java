package torisWordleGame;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Main {
	
public static void main(String[] args) {
		
		WordList.fillList();
	    ImageIcon rico = new ImageIcon(Main.class.getResource("rico.png"));
	    ImageIcon witheredWojak = new ImageIcon(Main.class.getResource("wojakWordle.png"));
	    ImageIcon susgay = new ImageIcon(Main.class.getResource("susgayWordle.png"));
	    ImageIcon capyReading = new ImageIcon(Main.class.getResource("capyReading.png"));
	    ImageIcon capyMonacle = new ImageIcon(Main.class.getResource("capyMonacle.png"));
	    ImageIcon capyParty = new ImageIcon(Main.class.getResource("capyParty.png"));
	    ImageIcon lopez = new ImageIcon(Main.class.getResource("lopez.png"));
	    ImageIcon capyMonkeys = new ImageIcon(Main.class.getResource("capyMonkeys.png"));



		boolean menu = true;
		String title = "Tori's Wordle Game";
		boolean playAgain = true;

		while(menu) {
			String[] options = {"Play", "Instructions", "Credits", "Exit"};
			int choice = JOptionPane.showOptionDialog(null, "Welcome to Tori's Wordle Game!" + "\n" + "Ready to begin?", title + ": Menu", 0, JOptionPane.INFORMATION_MESSAGE, lopez, options, null);
			
			//play the game
			if(choice == 0) {
				while(playAgain) {
					String[] numLetters = {"3", "4", "5", "6"};
					int gameDiff = JOptionPane.showOptionDialog(null, "How many letters do you want\nthe secret word to have?", title + ": Play", 0, JOptionPane.INFORMATION_MESSAGE, capyMonacle, numLetters, null);
					int numChances = 0;
					ArrayList<String> guesses = new ArrayList<String>();
					ArrayList<String> hints = new ArrayList<String>();
					
					//3 letter word
					if(gameDiff == 0) {
						HiddenWord.word = WordList.secret3LWord();
			    	}
					//4 letter word
			    	else if(gameDiff == 1) {
						HiddenWord.word = WordList.secret4LWord();
			    	}
					//5 letter word
			    	else if(gameDiff == 2) {
				    	HiddenWord.word = WordList.secret5LWord();
			    	}
					//6 letter word
			    	else if(gameDiff == 3) {
				    	HiddenWord.word = WordList.secret6LWord();
			    	}
					
					
					//each of the player's guesses
					String wordLen = numLetters[gameDiff];
					while(numChances <= 6) {
						String guess = (String) JOptionPane.showInputDialog(null, createHintList(hints, guesses, numChances, wordLen), title + ": Play", JOptionPane.QUESTION_MESSAGE, rico, null, null);
						while(guess.length() != HiddenWord.word.length()) {
							guess = (String) JOptionPane.showInputDialog(null, createHintList(hints, guesses, numChances, wordLen) + "\n\n" + "Sorry that is not a valid response, try again!" + "\n" + "Make sure your response is comprised of " + wordLen + " letters.", title + ": Play", JOptionPane.QUESTION_MESSAGE, rico, null, null);
						}
						guesses.add(guess);
						hints.add(HiddenWord.getHint(guess));
						numChances++;
						if(guess.equals(HiddenWord.word)) {
							JOptionPane.showMessageDialog(null, createHintList(hints, guesses, numChances, wordLen), title + ": Play", 0, capyParty);
							numChances = 7;
						}
						else if(numChances == 6) {
							JOptionPane.showMessageDialog(null, createHintList(hints, guesses, numChances, wordLen), title + ": Play", 0, witheredWojak);
							numChances = 7;
						}
						
						
					}
					
					String[] againOpt = {"Play Again", "Exit"};
					int continuePlay = JOptionPane.showOptionDialog(null, "Thanks for playing Tori's Wordle Game!" + "\n" + "Would you like to play again?", title + ": Play", 0, JOptionPane.INFORMATION_MESSAGE, susgay, againOpt, null);
					if(continuePlay == 1) {
						playAgain = false;
						menu = false;
					}

					
				}

			}
			
			//instructions
			else if(choice == 1) {
				JOptionPane.showMessageDialog(null, "The player will try to guess a randomly selected word using no more than 6 chances." + "\n" 
									+ "-If a letter in your guess is in the same position as in the secret word, that letter will be displayed." + "\n"
									+ "-If a letter in your guess is in the secret word but a different position, the hint will display \"+\"." + "\n"
									+ "-If a letter in your guess is not in the secret word at all, the hint will display \"*\"." + "\n"
									+ "Example: Suppose the secret word is \"harps\"." + "\n"
									+ equallySpaced("Guess 1: aaaaa","Hint Displayed: +a+++", 50) + "\n"
									+ equallySpaced("Guess 2: hello","Hint Displayed: h****", 50) + "\n"
									+ equallySpaced("Guess 3: heart","Hint Displayed: h*++*", 50) + "\n"
									+ equallySpaced("Guess 4: harms","Hint Displayed: har*s", 50) + "\n"
									+ equallySpaced("Guess 5: harps","Hint Displayed: harps", 50), title + ": Instructions", 0, capyReading);
			}
			
			//credits
			else if(choice == 2) {
				JOptionPane.showMessageDialog(null, "Special thanks to:" + "\n" 
													+ "Lizy Hernandez, Aron Silberwasser, Eddy Navas, Mateo Martinez, Krystal Fajardo," + "\n"
													+ "Nicholas Lindner, and Matthew Rojas for being some of my first testers of this program," + "\n"
													+ "as well as he who shall not be named.", title + ": Credits", 0, capyMonkeys); 
			}
			
			//exit and x button
			else if(choice == 3 || choice == -1) {
				menu = false;
			}
			
			
		}

	}
	
	
	static String equallySpaced(String leftString, String rightString, int size) {
		String spacing ="";
		if(leftString.length()+rightString.length()<size) {
			int spaces = size-(leftString.length()+rightString.length());
			for(int i=0;i<spaces;i++) {
				spacing+=" ";
			}
		}
		return leftString+spacing+rightString;
	}
	
	//creates a string of the player's guesses and hints and number of chances left
	static String createHintList(ArrayList<String> hints, ArrayList<String> guesses, int numChances, String wordLen) {
		String hintsList = "";
		for(int i = 0; i < hints.size(); i++) {
			hintsList += equallySpaced("Guess " + (i+1) + ": " + guesses.get(i), "Hint " + (i+1) + ": " + hints.get(i), 35) + "\n";
			if(guesses.get(i).equals("penis")) {
				hintsList += "\n"
						+ "⠀⠀⠀⠀⠀⢰⡿⠋⠁⠀⠀⠈⠉⠙⠻⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⢀⣿⠇⠀⢀⣴⣶⡾⠿⠿⠿⢿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⣀⣀⣸⡿⠀⠀⢸⣿⣇⠀⠀⠀⠀⠀⠀⠙⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⣾⡟⠛⣿⡇⠀⠀⢸⣿⣿⣷⣤⣤⣤⣤⣶⣶⣿⠇⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀\n"
						+ "⢀⣿⠀⢀⣿⡇⠀⠀⠀⠻⢿⣿⣿⣿⣿⣿⠿⣿⡏⠀⠀⠀⠀⢴⣶⣶⣿⣿⣿⣆\n"
						+ "⢸⣿⠀⢸⣿⡇⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⣿⡇⣀⣠⣴⣾⣮⣝⠿⠿⠿⣻⡟\n"
						+ "⢸⣿⠀⠘⣿⡇⠀⠀⠀⠀⠀⠀⠀⣠⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠉⠀\n"
						+ "⠸⣿⠀⠀⣿⡇⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉⠀⠀⠀⠀\n"
						+ "⠀⠻⣷⣶⣿⣇⠀⠀⠀⢠⣼⣿⣿⣿⣿⣿⣿⣿⣛⣛⣻⠉⠁⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⢸⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⢸⣿⣀⣀⣀⣼⡿⢿⣿⣿⣿⣿⣿⡿⣿⣿⡿        \n";
			}
			if(guesses.get(i).equals(HiddenWord.word)) {
				//accounts for grammar if numChances = 1 or is more than 1
				if(numChances == 1) { hintsList += "\n" + "Congratulations! After " + numChances + " try you\nhave found the secret word: " + HiddenWord.word; }
				else { hintsList += "\n" + "Congratulations! After " + numChances + " tries you\nhave found the secret word: " + HiddenWord.word; }
				return hintsList;
			}
		}
		if(numChances >= 6) {
			hintsList += "\n" + "Sorry, you ran out of chances!" + "\n" + "The secret word is: " + HiddenWord.word;
			return hintsList;
		}
		
		//accounts for grammar if 6-numChances = 1 or is more than 1
		if(6-numChances == 1) { hintsList += "\n" + "You have " + (6-numChances) + " chance left." + "\n" + "Enter your guess for a " + wordLen + " letter word."; }
		else { hintsList += "\n" + "You have " + (6-numChances) + " chances left." + "\n" + "Enter your guess for a " + wordLen + " letter word."; }
		return hintsList;
		
	}

}
