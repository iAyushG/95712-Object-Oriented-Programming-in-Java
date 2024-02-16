/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package finals;

public class ImpatientVehicle extends Vehicle {
	
    static final int Q_TOO_LONG_LENGTH = 5;

    public ImpatientVehicle(TrafficResource resource) {
        super(resource);
    }

    @Override
    boolean joinVehicleQ() {
        return resource.joinVehicleImpatient(this);
    }
}