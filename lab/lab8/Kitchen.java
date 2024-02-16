/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab8;

import java.util.Queue;
import java.util.Random;

public class Kitchen implements Runnable{
	final int MEAL_RATE = 6;  		//$ per meal
	final int MAX_COOK_TIME = 7;  	//max time to cook one meal
	final int MIN_COOK_TIME = 1;  	//min time to cook one meal
	final int OPENING_STOCK = 175;	
	final int MIN_STOCK = 4;
	
	int currentStock; 	
	boolean  isUnderStock;
	int guestsServed, income;
	Queue<Guest> guestQ;

	Kitchen (Queue<Guest> guestQ) {
		this.guestQ = guestQ;
	}

	
	/** run() loops while Diner isOpen and kitchen is not under stock. 
	 * In this loop, it polls guestQ, and if there is a guest,
	 * then invokes its placeOrder().
	 * Based on the number of meals returned by placeOrder(),
	 * the kitchen updates currentStock and income. 
	 * If currentStock falls at or below MIN_STOCK, then isUnderStock
	 * is set to true.
	 * Each meal costs MEAL_RATE.
	 * The kitchen sleeps anywhere from MIN_COOK_TIME to MAX_COOK_TIME
	 * to simulate cooking time. 
	 * It also increments guestsServed as needed. 
	 */
	@Override
	public void run() {
		//write your code here
		currentStock = OPENING_STOCK; // Initialize current stock
	    guestsServed = 0;
	    income = 0;
	    isUnderStock = false;
	    Random random = new Random();

	    while (Diner.isOpen && !isUnderStock) {
	        Guest guest = guestQ.poll();
	        if (guest != null) {
	            int mealsOrdered = guest.placeOrder();
	            int mealsToCook = Math.min(mealsOrdered, currentStock); 
	            
	            currentStock -= mealsToCook; 
	            income += mealsToCook * MEAL_RATE; 
	            guestsServed++; 

	            for (int i = 0; i < mealsToCook; i++) {
	                try {
	                    Thread.sleep(MIN_COOK_TIME + random.nextInt(MAX_COOK_TIME - MIN_COOK_TIME + 1));
	                } 
	                catch (InterruptedException e) {
	                    Thread.currentThread().interrupt();
	                    return; 
	                }
	            }

	            if (currentStock <= MIN_STOCK) {
	                isUnderStock = true; 
	            }
	        }

	        
	        try {
	            Thread.sleep(10); 
	        } 
	        catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            return; 
	        }
	    }
	}
}