/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package finals;

import java.util.Scanner;

public class Road implements Runnable {
	
    static int maxVehicles;
    static int problemPart;
    static int vehiclesPassed = 0;
    static int vehiclesExited = 0;
    long startTime;
    long endTime;
    TrafficResource resource = new TrafficResource();

    public static void main(String[] args) {
        Road road = new Road();
        road.startRoad();
        road.printReport();
        road.checkAssertions();
    }

    void startRoad() {
        Thread t1 = new Thread(new TrafficLight(resource));
        Thread t2 = new Thread(new Traffic(resource));
        Thread t3 = new Thread(this);
        Scanner input = new Scanner(System.in);
        System.out.println("Part 1 or 2?");
        problemPart = input.nextInt();
        System.out.println("How many vehicles?");
        maxVehicles = input.nextInt(); 
        startTime = System.currentTimeMillis();
        input.close();

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } 
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        endTime = System.currentTimeMillis();
    }

    void printReport() {
        System.out.println("-----------TRAFFIC REPORT---------------------------");
        System.out.println("The program ran for " + (endTime - startTime) + " ms");
        System.out.println("Max Q length at traffic light was " + resource.maxQLength);
        System.out.println("Final Q length at traffic light was " + resource.vehicleQ.size());

        if (problemPart == 2) {
            System.out.println("Vehicles passed: " + vehiclesPassed);
            System.out.println("Vehicles exited: " + vehiclesExited);
        }
    }

    @Override
    public void run() {
        while (Vehicle.vehicleCount < maxVehicles) {
            resource.releaseVehicle();
        }
    }

    void checkAssertions() {
        assert maxVehicles == vehiclesPassed + vehiclesExited + resource.vehicleQ.size();
        assert resource.maxQLength >= resource.vehicleQ.size();
        assert Vehicle.vehicleCount == maxVehicles;
    }
}