/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab9;

import java.util.Random;

public class Student {
	
    static int totalStudentsCreated = 0;
    static int totalStudentsHelped = 0;

    static final int MIN_QUESTION_TIME = 5;
    static final int MAX_QUESTION_TIME = 30;

    int studentID;

    public Student() {
        studentID = ++totalStudentsCreated;
    }

    public int askQuestion() {
        int questionTime = new Random().nextInt((MAX_QUESTION_TIME - MIN_QUESTION_TIME) + 1) + MIN_QUESTION_TIME;
        totalStudentsHelped++;
        return questionTime;
    }
}