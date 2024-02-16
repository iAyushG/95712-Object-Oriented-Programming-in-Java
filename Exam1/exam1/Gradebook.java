package exam1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gradebook {

	String[] fileData; //stores rows of data read from data file
	String[] students;	//names of students
	float[][] scores;	//students' scores in the same order as given in data file 
	float[] averageScores; //each students' average score
	StringBuilder fileContent = new StringBuilder();

	//do not change this method
	public static void main(String[] args) {
		Gradebook gradebook = new Gradebook();
		gradebook.fileData = gradebook.loadData("Gradebook.txt");
		gradebook.students = gradebook.getStudents();
		gradebook.scores = gradebook.getScores();
		gradebook.averageScores = gradebook.getAverages();
		gradebook.printAverages();
	}

	/** loadData() uses filename to read the file and
	 * returns an array of String, with each 
	 * string representing one row in data file
	 * @param filename
	 * @return
	 */
	String[] loadData(String filename) {
		//write your code here
		try (Scanner fileScanner = new Scanner(new File(filename))) {
	        while (fileScanner.hasNextLine()) {
	            fileContent.append(fileScanner.nextLine()).append("\n");
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		fileData = new String[fileContent.length()];
		fileData = fileContent.toString().split("\n");
		return fileData;
	}

	/** getStudents() uses data in fileData array
	 * and extracts student's names from it. It returns
	 * an array of these names.
	 * @return
	 */
	String[] getStudents() {
		//write your code here
		students = new String[fileData.length];
		for (int i = 0; i < students.length; i++) {
			String[] data = fileData[i].split(":");
			students[i] = data[0];
		}
		return students;
	}

	/** getScores uses data stored in fileData array
	 * and extracts scores of each student in a 2D array of 
	 * float numbers. 
	 * It returns the 2D array. 
	 * @return
	 */
	float[][] getScores() {
		//write your code here
		scores = new float[students.length][];
		for (int i = 0; i < students.length; i++) {
			String[] scoreRows = fileData[i].split(":");
			String[] score = scoreRows[1].split(",");
			scores[i] = new float[score.length];
			for(int j = 0; j < score.length; j++) {
				scores[i][j] = Float.parseFloat(score[j]);
			}
		}
		return scores;
	}

	/** getAverages uses data stored in score[][] array
	 * and computes average score for each student.
	 * It returns an array of these averages.
	 * @return
	 */
	float[] getAverages() {
		//write your code here
		averageScores = new float[students.length];
		for (int i = 0; i < scores.length; i++) {
			float total = 0;
			for (int j = 0; j < scores[i].length; j++) {
				total += scores[i][j];
			}
			averageScores[i] = (total / scores[i].length);
		}
		return averageScores;
	}

	//do not change this method
	void printAverages() {
		System.out.printf("%-20s\t%s%n", "Student", "Average Score");
		System.out.println("----------------------------------------");
		for (int i = 0; i < fileData.length; i++) {
			System.out.printf("%-20s:\t%10.2f\n", students[i] , averageScores[i] );
		}
	}
}