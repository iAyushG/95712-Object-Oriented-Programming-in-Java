/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab6;

public class Nomination implements Comparable<Nomination> {
	
    String year;
    String type;
    String actor;
    String movie;
    String role;

    public Nomination(String year, String type, String actor, String movie, String role) {
        this.year = year;
        this.type = type;
        this.actor = actor;
        this.movie = movie;
        this.role = role;
    }

    @Override
    public int compareTo(Nomination o) {
        return this.year.compareTo(o.year);
    }
}