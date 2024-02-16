/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package finals;

public class TrafficLight implements Runnable {
	
    static final int TRAFFIC_LIGHT_DELAY = 100;
    static boolean isGreen;
    private final TrafficResource resource;

    public TrafficLight(TrafficResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (Vehicle.vehicleCount < Road.maxVehicles) {
            try {
                resource.vehicleQLock.lock(); // Acquire the lock
                try {
                    isGreen = !isGreen;
                    if (isGreen) {
                        resource.vehicleCanGo.signalAll(); // Signal within the lock
                    }
                } 
                finally {
                    resource.vehicleQLock.unlock(); // Release the lock
                }
                Thread.sleep(TRAFFIC_LIGHT_DELAY);
            } 
            catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}