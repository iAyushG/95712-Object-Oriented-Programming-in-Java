/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab6;

import java.util.List;

public class Actor implements Comparable<Actor> {

	String name;
	List<Nomination> awards;
	
	public Actor(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Actor o) {
		return this.name.compareTo(o.name);
	}
}