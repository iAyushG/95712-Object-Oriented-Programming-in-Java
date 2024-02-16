/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab7;

import java.util.List;

public class Artist implements Comparable<Artist> {

	String name;
	List<Nomination> nominations;
	
	public Artist(String name, List<Nomination> nominations) {
		this.name = name;
		this.nominations = nominations;
	}
	
	@Override
    public String toString() {
        return String.format("%s: %d", name, nominations.size());
    }

    @Override
    public int compareTo(Artist other) {
    	int nominationCompare = Integer.compare(other.nominations.size(), this.nominations.size());
        // If the number of nominations is equal, then compare alphabetically by name
        return (nominationCompare != 0) ? nominationCompare : this.name.compareToIgnoreCase(other.name);
    }
}