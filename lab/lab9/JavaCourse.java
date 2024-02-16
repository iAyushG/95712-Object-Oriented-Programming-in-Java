/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class JavaCourse implements Runnable{
	static final int STUDENT_DELAY = 5; //gap between students' arrival to the queue
	static Queue<Student> studentQ = new LinkedList<>(); // queue of Student objects
	static volatile boolean allDone;	//indicator for JavaCourse to keep adding new Students to studentQ

	List<TA> taList = new ArrayList<>();  //list of TA objects used for sorting and printing
	List<Thread> taThreads = new ArrayList<>(); //Contains the thread objects created for each TA
	
	int totalTAs;  //used to take user input
	int maxQLength;	//stores the max Q length so far
	long startTime, endTime; //start and end time of this class's run() method before printReport is invoked

	
	//do not change this method
	public static void main(String[] args) {
		JavaCourse javaCourse = new JavaCourse();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of TAs");
		javaCourse.totalTAs = input.nextInt();
		for (int i = 1; i <= javaCourse.totalTAs; i++) {
			System.out.print("TA" + i + "\t\t");
		}
		System.out.println("\n------------------------------------------------------------------------------");
		input.close();
		for (int i = 0; i < javaCourse.totalTAs; i++ ) {
			TA ta = new TA();
			Thread t = new Thread(ta);
			javaCourse.taList.add(ta);  
			javaCourse.taThreads.add(t);
			t.start();
		}	
		javaCourse.run();
	}


	@Override
	public void run() {
		try {
			startTime = System.currentTimeMillis();

			while (!allDone) {
				synchronized (studentQ) {
					if (studentQ.size() > maxQLength) {
						maxQLength = studentQ.size(); 
					}

					Student student = new Student(); 
					studentQ.add(student); 
				}

				try {
					Thread.sleep(STUDENT_DELAY);
				} 
				catch (InterruptedException ie) {
					System.out.println("JavaCourse thread was interrupted.");
				}
			}

			for (Thread taThread : taThreads) {
				taThread.join();
			}

			endTime = System.currentTimeMillis(); 
			printReport(); 
		} 
		catch (InterruptedException ie) {
			System.out.println("JavaCourse run was interrupted.");
		}
	}


	//do not change this method
	void printReport() {
		int totalHelpTime = 0;
		System.out.println("-------------------------TAs---------------------------------------");
		Collections.sort(taList);
		for (TA ta: taList) {
			System.out.printf("%s%2d %s %3d %s %3d %s%n", "TA", ta.taID, "helped", ta.studentsHelped, "students for", ta.helpTime, "min" );
			totalHelpTime += ta.helpTime;
		}
		System.out.println("------------------------Time---------------------------------------");
		System.out.printf("%-25s%5d %s%n", "Total help time: ", totalHelpTime, "min");
		System.out.printf("%-25s%5d %s%n", "Max help time", totalTAs * TA.MAX_HELP_TIME, "min");
		System.out.printf("%-25s%5d %s%n", "Total elapsed time: ", (endTime - startTime), "min");
		System.out.println("-----------------------Students------------------------------------");
		System.out.printf("%-25s%5d%n", "Total students created:", Student.totalStudentsCreated);
		System.out.printf("%-25s%5d%n", "Total students helped: ", Student.totalStudentsHelped);
		System.out.printf("%-25s%5d%n", "Max Q length: ", maxQLength);
		System.out.printf("%-25s%5d%n", "Students left in the Q: ", studentQ.size());
		System.out.println("-------------------------------------------------------------------");

		//following statements are to test console output numbers
		assertEquals(Student.totalStudentsCreated, studentQ.size() + Student.totalStudentsHelped);
		assertTrue( totalHelpTime >= totalTAs * TA.MAX_HELP_TIME);
		assertTrue(allDone);
	}
}