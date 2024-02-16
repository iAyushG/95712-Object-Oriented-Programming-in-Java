/*
 * NAME: AYUSH GUPTA
 * Andrew ID: ayushgu2
 * @author ayush
 */

package lab4;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EnglishQuiz extends Quiz {
    
    String[] wordStrings;
    int questionIndex;
    static int count;
	static int score;

    Random random = new Random();

    EnglishQuiz(String filename) {
        int numberOfLines = 0;

        try (Scanner fileScannerCount = new Scanner(new File(filename))) {
            while (fileScannerCount.hasNextLine()) {
                numberOfLines++;
                fileScannerCount.nextLine();
            }
        } 
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            e.printStackTrace();
            return;
        }

        wordStrings = new String[numberOfLines];

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            for (int i = 0; i < numberOfLines; i++) {
                wordStrings[i] = fileScanner.nextLine();
            }
        } 
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            e.printStackTrace();
        }
    }

    @Override
    void createQuestion() {
        questionIndex = random.nextInt(wordStrings.length);
        String[] parts = wordStrings[questionIndex].split(":");
        questionString = parts[1];
    }

    @Override
    void createAnswer() {
        // Use the previously generated index
        String[] parts = wordStrings[questionIndex].split(":");
        answerString = parts[0].trim();
    }

    @Override
    boolean checkAnswer(String answer) {
        count++;
        Quiz.count++;

        boolean isCorrect;

        answer = answer.toLowerCase();

        if (answer.equalsIgnoreCase(answerString)) {
            isCorrect = true;
            score++;
            Quiz.score++;
        } 
        else {
            isCorrect = false;
        }

        return isCorrect;
    }
}