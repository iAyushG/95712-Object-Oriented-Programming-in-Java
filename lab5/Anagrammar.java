/*
 * NAME: Ayush Gupta
 * ANDREW ID: ayushgu2
 */

/*
 * @author iAyushGupta
 */

package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Anagrammar {
	String[] words;		//stores all words read from words.txt
	boolean isInDictionary; //true if the clue word exists in words.txt
	boolean hasAnagrams;	//true if the clue word has anagrams
	String[] anagramArray;	//stores all anagrams of clue-word, if found
	
	/**loadWords method reads the file and loads all words 
	 * into the words[] array */
	void loadWords(String filename) {
		try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            int wordCount = 0;
     
            while (sc.hasNextLine()) {
                wordCount++;
                sc.nextLine();
            }
            sc.close();

            words = new String[wordCount];

            sc = new Scanner(file);
            int i = 0;
            while (sc.hasNextLine()) {
                words[i] = sc.nextLine();
                i++;
            }
            sc.close();
        } 
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

	
	
	/** findAnagrams method traverses the words array and looks 
	 * for anagrams of the clue. While doing so, if the clue-word itself is found in the 
	 * words array, it sets the isInDictionary to true.
	 * If it finds any anagram of the clue, it sets the hasAnagram to true. 
	 * It loads the anagram into the anagramArray. 
	 * If no anagrams found, then anagramArray remains an array with size 0. 
	 * */
	void findAnagrams(String clue) {
        isInDictionary = false;
        hasAnagrams = false;
        anagramArray = new String[0];

        for (String word : words) {
            if (clue.equals(word)) {
                isInDictionary = true;
            } 
            else if (isAnagram(clue, word)) {
                hasAnagrams = true;

                String[] newAnagramArray = new String[anagramArray.length + 1];
                System.arraycopy(anagramArray, 0, newAnagramArray, 0, anagramArray.length);

                newAnagramArray[anagramArray.length] = word;
                anagramArray = newAnagramArray;
            }
        }
    }

    private boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        java.util.Arrays.sort(chars1);
        java.util.Arrays.sort(chars2);
        return java.util.Arrays.equals(chars1, chars2);
    }
}