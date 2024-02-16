/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab9;

public class TA implements Runnable, Comparable<TA>{

	static int totalHelpTime;  //total time spent so far across all TA's
	static int taCount; //number of TAs
	static final int MAX_HELP_TIME = 120; //max total time a TA can spend across all students

	int studentsHelped; //number of students helped by a TA so far
	int helpTime;  //total time spent by a TA so far 

	int taID; //TA's unique id

	TA() {
		taID = ++taCount;
	}

	@Override
	public void run() {
		while (!JavaCourse.allDone && this.helpTime < MAX_HELP_TIME) {
			Student student = null;
			synchronized (JavaCourse.studentQ) {
				if (!JavaCourse.studentQ.isEmpty()) {
					student = JavaCourse.studentQ.poll();
				}
			}

			if (student != null) {
				int questionTime = student.askQuestion();
				try {
					Thread.sleep(questionTime);
				} 
				catch (InterruptedException ie) {
					System.out.println("TA " + taID + " was interrupted.");
				}

				synchronized (TA.class) {
					this.studentsHelped++;
					this.helpTime += questionTime;
					TA.totalHelpTime += questionTime;
				}

				System.out.println(spacer(taID) + "TA" + taID + ": Student" + student.studentID + ": " + questionTime + "min");
			}

			synchronized (TA.class) {
				if (TA.totalHelpTime >= taCount * MAX_HELP_TIME && this.helpTime >= MAX_HELP_TIME) {
					if (!JavaCourse.allDone) {
						JavaCourse.allDone = true;
						System.out.println("*** All done flag set by TA" + taID);
					}
					break;
				}
			}
		}

		// Print a message when TA is done
		if (this.helpTime >= MAX_HELP_TIME) {
			System.out.println("---- TA" + taID + " done ----");
		}
	}

	@Override
	public int compareTo(TA o) {
		return Integer.compare(o.helpTime, this.helpTime);
	}

	//do not change this method
	String spacer(int taID) {
		StringBuilder spaces = new StringBuilder();
		for (int i = 1; i < taID; i++) {
			spaces.append("\t\t");
		}
		return spaces.toString();
	}
}