package torisWordleGame;

import java.util.ArrayList;
/*
 * This class contains the list of words from which hidden words can be randomly chosen from.
 */
public class WordList {
	
	public static ArrayList<String> words3L = new ArrayList<String>();
	public static ArrayList<String> words4L = new ArrayList<String>();
	public static ArrayList<String> words5L = new ArrayList<String>();
	public static ArrayList<String> words6L = new ArrayList<String>();

	/*
	 * This method adds each word to an arraylist, so that the word can be randomly chosen from the arraylist.
	 */
	static void fillList(){
		
		words3L.add("for");
		words3L.add("may");
		words3L.add("you");
		words3L.add("get");
		words3L.add("why");
		words3L.add("who");
		words3L.add("day");
		words3L.add("her");
		words3L.add("him");
		words3L.add("map");
		words3L.add("did");
		words3L.add("car");
		words3L.add("can");
		words3L.add("art");
		
		words4L.add("your");
		words4L.add("home");
		words4L.add("rico");
		words4L.add("link");
		words4L.add("item");
		words4L.add("game");
		words4L.add("band");
		words4L.add("read");
		words4L.add("bold");
		words4L.add("four");
		words4L.add("five");
		
		words5L.add("would");
		words5L.add("apple");
		words5L.add("adult");
		words5L.add("based");
		words5L.add("where");
		words5L.add("clock");
		words5L.add("glare");
		words5L.add("crane");
		words5L.add("color");
		words5L.add("vivid");
		
		words6L.add("center");
		words6L.add("bottom");
		words6L.add("actual");
		words6L.add("accept");
		words6L.add("grande");
		words6L.add("coffee");
		words6L.add("people");
		words6L.add("sizzle");
		words6L.add("macaws");
		words6L.add("packet");






		
		/*BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("words_alpha.txt"));
			String line = br.readLine();
			int size = 0;
			while (line != null && size<10000) {
				String word =br.readLine();
				if(word != null && word.length() == 3) {
					words3L.add(word);
				}
				else if(word != null && word.length() == 4) {
					words4L.add(word);
				}
				else if(word != null && word.length() == 5) {
					words5L.add(word);
				}
				else if(word != null && word.length() == 6) {
					words6L.add(word);
				}
				size++;
			}
			
			br = new BufferedReader(new FileReader("words_alpha_short.txt"));
			 line = br.readLine();
			 size = 0;
			while (line != null && size<10000) {
				String word =br.readLine();
				if(word != null && word.length() == 3) {
					words3L.add(word);
				}
				else if(word != null && word.length() == 4) {
					words4L.add(word);
				}
				else if(word != null && word.length() == 5) {
					words5L.add(word);
				}
				size++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/

	}

	/*
	 * If the user selects a 3 letter secret word, a hidden word is randomly chosen from the list of 3 letter words.
	 */
	public static String secret3LWord() {
		int i = (int) (Math.random() * words3L.size());
		return words3L.get(i);
	}
	
	/*
	 * If the user selects a 4 letter secret word, a hidden word is randomly chosen from the list of 4 letter words.
	 */
	public static String secret4LWord() {
		int i = (int) (Math.random() * words4L.size());
		return words4L.get(i);
	}
	
	/*
	 * If the user selects a 5 letter secret word, a hidden word is randomly chosen from the list of 5 letter words.
	 */
	public static String secret5LWord() {
		int i = (int) (Math.random() * words5L.size());
		return words5L.get(i);
	}
	
	/*
	 * If the user selects a 6 letter secret word, a hidden word is randomly chosen from the list of 6 letter words.
	 */
	public static String secret6LWord() {
		int i = (int) (Math.random() * words6L.size());
		return words6L.get(i);
	}

}
