/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 * 
 * Author: iAyushGupta
 */

package hw3;

import java.util.List;

/**
 * Abstract class CaseReader acts as a base for file reading classes.
 * It is used by CaseReaderFactory for initializing and reading data files.
 * The readCases() method is meant to be implemented by subclasses like CSVCaseReader and TSVCaseReader.
 */
public abstract class CaseReader {

    String filename; // Variable to store the name of the file to be read

    /**
     * Constructor for CaseReader.
     * Initializes the filename to be used by the reader.
     */
    CaseReader(String filename) {
        this.filename = filename;
    }

    /**
     * Abstract method to be implemented by subclasses.
     * It defines how cases will be read from a file.
     * @return A list of Case objects read from the file.
     */
    abstract List<Case> readCases();
}