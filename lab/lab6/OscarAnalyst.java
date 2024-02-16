/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class OscarAnalyst {
	
	List<Nomination> nominations;
	List<Actor> actors;
	
	Scanner input = new Scanner(System.in);
	
	//do not change this method
	public static void main(String[] args) {
		OscarAnalyst oscarAnalyst = new OscarAnalyst();
		oscarAnalyst.loadNominations("Oscar.txt");
		oscarAnalyst.loadActors();
		oscarAnalyst.analyze();
	}
	
	//complete this method to handle input/output
	void analyze() {
		int choice = 0;
		
		System.out.println("*** Welcome to Oscar Analyzer ***");
		System.out.println("1. Print Actor Nomination Counts");
		System.out.println("2. Search Movie Nominations");
		System.out.println("3. Exit");
		
		System.out.println("Enter your choice: ");
		choice = input.nextInt();
		input.nextLine(); //clear buffer
		
		switch (choice) {
        case 1:
            printActorsReport();
            break;
        case 2:
            System.out.println("Enter a search string for movie names: ");
            String searchString = input.nextLine();
            searchMovies(searchString);
            break;
        case 3:
            System.out.println("Exiting...");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            break;
        }
	}
	
	/**loadNominations() reads data from file, creates Nomination instances 
	 * for each row of data, and then populates the nominations ArrayList
	 * @param filename
	 */
	void loadNominations(String filename) {
		//write your code here
		if (nominations == null) {
	        nominations = new ArrayList<>();
	    }
		
		try {
	        File file = new File(filename);
	        Scanner scanner = new Scanner(file);

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(",");
	            
	            String year = parts[0].trim();
	            String type = parts[1].trim();
	            String actorName = parts[2].trim();
	            String movieName = parts[3].trim();
	            String roleName = parts[4].trim();

	            Nomination nomination = new Nomination(year, type, actorName, movieName, roleName);
	            nominations.add(nomination);
	        }
	        scanner.close();
	    } 
		catch (FileNotFoundException e) {
	        System.out.println("An error occurred while trying to read the file: " + filename);
	        e.printStackTrace();
	    }
	}
	
	/**loadActors()  iterates over nominations list, creates Actor instances for 
	 * the actor in a particular Nomination instance, and then populates that Actor's
	 * nominations with the Nomination instances. So for every actor that was nominated, there is 
	 * one Actor instance in actors list. This instance has the list of nominations for that actor 
	 */
	void loadActors() {
		//write your code here
		if (actors == null) {
	        actors = new ArrayList<>();
	    }

	    for (Nomination nomination : nominations) {
	        String actorName = nomination.actor;
	        Actor actor = null;

	        for (Actor a : actors) {
	            if (a.name.equalsIgnoreCase(actorName)) {
	                actor = a;
	                break;
	            }
	        }

	        if (actor == null) {
	            actor = new Actor(actorName);
	            actors.add(actor);
	        }

	        if (actor.awards == null) {
	            actor.awards = new ArrayList<>();
	        }

	        actor.awards.add(nomination);
	    }
	}
	
	/**printActorsReport() prints list of Actors sorted in the decreasing order
	 * of number of awards. For actors that got the same number of awards, 
	 * they are sorted by name
	 */
	void printActorsReport() {
		//write your code here
		if (actors == null) {
			actors = new ArrayList<>();
		}
		
	    Collections.sort(actors, new ActorComparator());

	    int count = 1;
	    for (Actor actor : actors) {
	        System.out.printf("%3d. %-35s: %2d %n", count, actor.name, actor.awards.size());
	        count++;
	    }
	}
	
	/**searchMovies() returns a list of Oscar instances whose
	 * movie names contain the searchString. 
	 * The search is case-insensitive
	 * @param searchString
	 * @return
	 */
	List<Nomination> searchMovies(String searchString) {
		//write your code here
		if (nominations == null) {
			nominations = new ArrayList<>();
		}
		
	    List<Nomination> searchResults = new ArrayList<>();

	    String searchLower = searchString.toLowerCase();

	    for (Nomination nomination : nominations) {
	        if (nomination.movie.toLowerCase().contains(searchLower)) {
	            searchResults.add(nomination);
	        }
	    }

	    Collections.sort(searchResults);
	    System.out.println(searchResults.size() + " movies found");

	    int count = 1;
	    for (Nomination nomination : searchResults) {
	        System.out.printf("%d. %s: %s nominated for %s role by %s%n", count, nomination.year, nomination.movie, nomination.type, nomination.actor);
	        count++;
	    }

	    return searchResults;
	}
	
	class ActorComparator implements Comparator<Actor> {
        @Override
        public int compare(Actor a1, Actor a2) {
            int awardComparison = Integer.compare(a2.awards.size(), a1.awards.size());
            if (awardComparison != 0) {
                return awardComparison;
            }

            return a1.name.compareToIgnoreCase(a2.name);
        }
    }
}