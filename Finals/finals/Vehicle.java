/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package finals;

public class Vehicle {
	
    static volatile int vehicleCount;
    int id;
    TrafficResource resource;

    public Vehicle(TrafficResource resource) {
        this.id = ++vehicleCount;
        this.resource = resource;
    }

    boolean joinVehicleQ() {
        return resource.joinVehicle(this);
    }
}