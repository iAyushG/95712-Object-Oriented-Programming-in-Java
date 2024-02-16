package exam1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookFinder {
	
	String fileName;
	String searchString;
	StringBuilder fileContent = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookFinder bf = new BookFinder();
		String[] result;
		bf.getUserInput();
		bf.loadRecords();
		result = bf.searchRecords(bf.fileContent);
		bf.printOutput(result);
	}
	
	public void getUserInput() {
		fileName = new String();
		searchString = new String();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file name:");
		fileName = sc.nextLine();
		System.out.println("Enter what you are looking for");
		searchString = sc.nextLine();
		
		sc.close();
	}
	
	StringBuilder loadRecords() {
		try (Scanner fileScanner = new Scanner(new File(fileName))) {
	        while (fileScanner.hasNextLine()) {
	            fileContent.append(fileScanner.nextLine()).append("\n");
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		return fileContent;
	}
	
	@SuppressWarnings("unused")
	String[] searchRecords(StringBuilder fileContent) {
	    String[] results = new String[fileContent.length()];
	    int i = 0;
	    if (fileContent == null) {
	        return new String[0];
	    } 
	    else {
	        String[] fileData = fileContent.toString().split("\n");
	        for (String data : fileData) {
	            if (data.toLowerCase().contains(searchString.toLowerCase())) {
	                results[i] = data;
	                i++;
	            }
	        }
	        String[] finalResult = new String[i];
	        System.arraycopy(results, 0, finalResult, 0, i);
	        return finalResult;
	    }
	}
	
	public void printOutput(String[] results) {
	    if (results != null) {
	        System.out.printf("Found records: %d%n", results.length);
	        for (String result : results) {
	            System.out.println(result);
	        }
	    } 
	    else {
	        System.out.println("Found records: 0");	    	
	        System.out.println("Sorry " + searchString + " not found in " + fileName);
	    }
	}
}
