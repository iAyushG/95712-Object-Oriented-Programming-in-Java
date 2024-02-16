/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab8;

import java.util.Random;;

public class Guest {

	public final int MAX_MEALS = 4;
	
	public int placeOrder() {
		Random random = new Random();
		return 1 + random.nextInt(MAX_MEALS);
	}
}