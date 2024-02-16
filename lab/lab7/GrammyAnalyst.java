/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/** GrammyAnalyst takes Grammys.txt to provide two reports and one search functionality
 */
public class GrammyAnalyst {
	/**initialize these member variables with appropriate data structures **/
	List<Nomination> nominations;  
	Map<String, List<Nomination>> grammyMap;  
	List<Artist> artists;
	
	public static void main(String[] args) {
		GrammyAnalyst ga = new GrammyAnalyst();
		ga.loadNominations();
		ga.loadGrammyMap();
		System.out.println("*********** Grammy Report ****************");
		ga.printGrammyReport();
		System.out.println("*********** Search Artist ****************");
		System.out.println("Enter artist name");
		Scanner input = new Scanner(System.in);
		String artist = input.nextLine();
		ga.searchGrammys(artist);
		ga.loadArtists();
		System.out.println("*********** Artists Report ****************");
		ga.printArtistsReport();
		input.close();
	}
	
	/**loadNominations() reads data from Grammys.txt and 
	 * populates the nominations list, where each element is a Nomination object
	 */
	void loadNominations() {
		//write your code here
	    nominations = new ArrayList<Nomination>();

	    try {
	        File file = new File("Grammys.txt");
	        Scanner scanner = new Scanner(file);

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(";");

	            if (parts.length >= 3) {
	                String category = parts[0].trim();
	                String title = parts[1].trim();
	                String artist = parts[2].trim();

	                Nomination nomination = new Nomination(category, title, artist);
	                nominations.add(nomination);
	            }
	        }

	        scanner.close();
	    } 
	    catch (FileNotFoundException e) {
	        System.out.println("Error: The file 'Grammys.txt' was not found.");
	    }
	}
	
	/**loadGrammyMap uses artist name in lower case as the key, and a list of 
	 * all nominations for that artist as its value. Hint: use 'nominations' list 
	 * created in previous method to populate this map.
	 */
	void loadGrammyMap() {
		//write your code here
	    grammyMap = new HashMap<>();

	    for (Nomination nomination : nominations) {
	        String artistKey = nomination.artist.toLowerCase();

	        if (!grammyMap.containsKey(artistKey)) {
	            grammyMap.put(artistKey, new ArrayList<Nomination>());
	        }

	        grammyMap.get(artistKey).add(nomination);
	    }
	} 
	
	/**loadArtists loads the artists array List. Each Artist object in it should have
	 * artist's name in proper case, i.e., as read from data file, and 
	 * a list of nominations for that artist. Hint: use 'grammyMap' created in 
	 * previous method to populate this list
	 */
	void loadArtists() {
		//write your code here
	    artists = new ArrayList<>();

	    for (Map.Entry<String, List<Nomination>> data : grammyMap.entrySet()) {
	        String artistProperCase = data.getValue().get(0).artist;
	        List<Nomination> nominations = data.getValue();
	        
	        Artist artist = new Artist(artistProperCase, nominations);

	        artists.add(artist);
	    }

	    artists.sort(null);
	}
	
	/**printGrammyReport prints report as shown in the handout */
	void printGrammyReport() {
		//write your code here
	    Collections.sort(nominations);
	    int i = 1;

	    for (Nomination nomination : nominations) {
	    	System.out.printf("%3d. ", i);
	        System.out.println(nomination);
	        i++;
	    }
	}
	
	/**printArtistReport prints report as shown in the handout */
	void printArtistsReport() {
		//write your code here
		Collections.sort(artists);
		int i = 1;

		    for (Artist artist : artists) {
		    	System.out.printf("%3d. ", i);
		        System.out.println(artist);
		        i++;
		    }
	}
	
	/**searchGrammys takes a string as input and makes a case-insensitive
	 * search on grammyMap. If found, it prints data about all nominations
	 * as shown in the handout.
	 */
	void searchGrammys(String artist) {
		//write your code here
		String searchKey = artist.toLowerCase();
	    boolean found = false;

	    for (String key : grammyMap.keySet()) {
	        if (key.contains(searchKey)) {
	            found = true;
	            
	            List<Nomination> artistNominations = grammyMap.get(key);
	            for (Nomination nomination : artistNominations) {
	                System.out.println(nomination);
	            }
	        }
	    }
	    
	    if (!found) {
	    	System.out.println("Sorry! " + artist + " not found!");
	    }
	}
	
/*This also works but this gives 6 search results when "beyonce" is searched.*/
//	void searchGrammys(String artist) {	
//		String searchKey = artist.toLowerCase();
//
//		if (grammyMap.containsKey(searchKey)) {
//			List<Nomination> artistNominations = grammyMap.get(searchKey);
//
//			for (Nomination nomination : artistNominations) {
//				System.out.println(nomination);
//			}
//		} 
//		else {
//			System.out.println("Sorry! " + artist + " not found!");
//		}
//	}
}