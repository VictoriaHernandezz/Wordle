package torisWordleGame;


public class HiddenWord {
	
	public static String word;
	
	

	public static String getHint(String guess) {
		String hint = "";
		
		//takes in guesses greater than the word length as a valid input
		String hintEx = "";
		if(guess.length() > word.length()) {
			for(int j = word.length(); j < guess.length(); j++) {
				if(word.indexOf(guess.substring(j,j+1)) != -1) {
					hintEx += "+";
				}
				else {
					hintEx += "*";
				}
			}
			guess = guess.substring(0, word.length());
		}
		
		//normal case
		for(int i = 0; i < guess.length(); i++) {
			if(guess.substring(i,i+1).equals(word.substring(i,i+1))) {
				hint += guess.substring(i,i+1);
			}
			else if(word.indexOf(guess.substring(i,i+1)) != -1) {
				hint += "+";
			}
			else {
				hint += "*";
			}
		}
		
		//takes in guesses less than the word length as a valid input
		while(hint.length() < word.length()) {
			hint += "*";
		}
		
		hint += hintEx;
		return hint;
	}
	

}
