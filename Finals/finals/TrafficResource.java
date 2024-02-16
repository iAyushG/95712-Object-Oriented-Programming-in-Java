/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package finals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficResource {
	
    Queue<Vehicle> vehicleQ = new LinkedList<>();
    Lock vehicleQLock = new ReentrantLock();
    Condition vehicleCanGo = vehicleQLock.newCondition();
    int maxQLength;

    public boolean joinVehicle(Vehicle v) {
        vehicleQLock.lock();
        try {
            vehicleQ.add(v);
            if (!TrafficLight.isGreen) {
                System.out.printf("\tRED: %s %d in Q. Q length %d%n", v.getClass().getSimpleName(), v.id, vehicleQ.size());
            }
            maxQLength = Math.max(maxQLength, vehicleQ.size());
            vehicleCanGo.signal();
        } 
        finally {
            vehicleQLock.unlock();
        }
        return true;
    }

    public void releaseVehicle() {
        vehicleQLock.lock();
        try {
            while (vehicleQ.isEmpty() && Vehicle.vehicleCount < Road.maxVehicles) {
                vehicleCanGo.await();
            }
            if (TrafficLight.isGreen && !vehicleQ.isEmpty()) {
                Vehicle v = vehicleQ.poll();
                System.out.printf("Green: %s %d passed. Q length: %d%n", v.getClass().getSimpleName(), v.id, vehicleQ.size());
                Road.vehiclesPassed++; 
            }
        } 
        catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        } 
        finally {
            vehicleQLock.unlock();
        }
    }

    public boolean joinVehicleImpatient(Vehicle v) {
        vehicleQLock.lock();
        try {
            if (vehicleQ.size() >= ImpatientVehicle.Q_TOO_LONG_LENGTH) {
                Road.vehiclesExited++;
                System.out.printf("********* Red: %s %d exiting. Q length: %d%n", this.getClass().getSimpleName(), v.id, vehicleQ.size());
                return false; 
            } 
            else {
                joinVehicle(v); 
            }
        } 
        finally {
            vehicleQLock.unlock();
        }
        return true;
    }
}