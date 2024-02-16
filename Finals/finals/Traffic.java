/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package finals;

import java.util.Random;

public class Traffic implements Runnable {
	
    static final int MIN_VEHICLE_DELAY = 5;
    static final int MAX_VEHICLE_DELAY = 10;
    private final TrafficResource resource;

    public Traffic(TrafficResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
    	Random rand = new Random();
        while (Vehicle.vehicleCount < Road.maxVehicles) {
            try {
                Vehicle v;
                if (Road.problemPart == 2 && rand.nextInt(4) == 0) { 
                    v = new ImpatientVehicle(resource);
                } 
                else {
                    v = new Vehicle(resource);
                }
                v.joinVehicleQ();
                Thread.sleep(rand.nextInt(MAX_VEHICLE_DELAY - MIN_VEHICLE_DELAY + 1) + MIN_VEHICLE_DELAY);
            } 
            catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}