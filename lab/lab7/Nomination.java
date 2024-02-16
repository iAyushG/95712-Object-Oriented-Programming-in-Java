/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab7;

public class Nomination implements Comparable<Nomination> {
	
	String category;
	String title;
	String artist;
	
	public Nomination(String category, String title, String artist) {
		this.artist = artist;
		this.category = category;
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("%s: %s: %s", artist, category, title);
	}
	
	@Override
	public int compareTo(Nomination o) {
		return this.artist.compareToIgnoreCase(o.artist);
	}
}