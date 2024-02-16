/*
 * Ayush Gupta
 * ayushgu2
 */

package lab2;

import java.io.*;
import java.util.Scanner;

public class ScoreBoard {
	StringBuilder fileContent = new StringBuilder();
	int[] scoreSums;
	double[] scoreAverages;
	int grandTotal;
	double grandAverage;
	
	//DO NOT not change this method
	/**  initiates the program and runs all other methods in a sequence
	 **/
	public static void main(String[] args) {
		ScoreBoard sb = new ScoreBoard();
		sb.readFile("Scores.txt");
		sb.computeScores();
		sb.printReport();
	}
	
	//complete this method
	/** readFile() method reads the file data into fileContent. 
	 * It preserves the line-breaks.
	 * @param fileName
	 */
	public void readFile(String fileName) {
		//write your code here
		    try (Scanner fileScanner = new Scanner(new File(fileName))) {
		        while (fileScanner.hasNextLine()) {
		            fileContent.append(fileScanner.nextLine()).append("\n");
		        }
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		}
	
	
	//complete this method
	/** computeScores() takes the fileContent and calculates four things
	 * 1. For each player, the total score in scoreSums array
	 * 2. For each player, the average score in scoreAverages array
	 * 3. The grand total of all scores in grandTotal
	 * 4. The grand average of all scores in grandAverage
	 */
	public void computeScores() {
		//write your code here
	    String[] playerScores = fileContent.toString().split("\n");
	    scoreSums = new int[playerScores.length];
	    scoreAverages = new double[playerScores.length]; 
	    for (int i = 0; i < playerScores.length; i++) {
	        String[] scores = playerScores[i].split(",");
	        int scoreCount = 0;
	        for (String score : scores) {
	            int value = Integer.parseInt(score.trim());
	            scoreSums[i] += value;
	            scoreCount++;
	        }
	        scoreAverages[i] = (double) scoreSums[i] / scoreCount; 
	        grandTotal += scoreSums[i];
	    }
	    grandAverage = (double) grandTotal / playerScores.length; 
	}
	
	//complete this method
	/** printReport() prints the output as shown in the problem statement
	 *  */
	public void printReport() {
		//write your code here
	    for (int i = 0; i < scoreSums.length; i++) {
	        System.out.printf("Player %d. Total Score = %3d, Average Score = %.2f%n", (i + 1), scoreSums[i], scoreAverages[i]);
	    }
	    System.out.println("-------------------------------------------------");
	    System.out.printf("Grand total score: %d, Grand average score: %.2f%n", grandTotal, grandAverage);
	}
}
