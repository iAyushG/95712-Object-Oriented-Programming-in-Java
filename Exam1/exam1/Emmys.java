/*
 * Name: Ayush Gupta
 * Andrew ID: ayushgu2
 */

package exam1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emmys {

	String[] filedata; //used to store rows of data read from the data file

	String[] series;	//names of series that received awards
	String[] networks;  //names of networks e.g. HBO on which series was aired
	int[][] awardTable; //table that has rows for series and columns for networks. 
						//Each cell [i,j] will show number of awards for i'th series on j'th network
						//i and j are as per their respective indices in series and networks arrays. 	

	//do not change this method
	public static void main(String[] args) {
		Emmys emmys = new Emmys();
		emmys.filedata = emmys.loadData("awards.csv");
		emmys.networks = emmys.getNetworks();
		emmys.series = emmys.getSeries();
		emmys.awardTable = emmys.buildAwardTable();
		emmys.printAwardTable();
	}

	/** loadData() takes file name and reads 
	 * each row as an element in an array of Strings.
	 * It returns that array.
	 * @param filename
	 * @return
	 */
	String[] loadData(String filename) {
		//write your code here
	    StringBuilder fileContent = new StringBuilder();
	    try (Scanner fileScanner = new Scanner(new File(filename))) {
	        while (fileScanner.hasNextLine()) {
	            fileContent.append(fileScanner.nextLine()).append("\n");
	        }
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    String[] lines = fileContent.toString().split("\n");
	    String[] filedata = new String[lines.length];
	    
	    for (int i = 0; i < lines.length; i++) {
	        filedata[i] = lines[i];
	    }
	    return filedata;
	}

	/** getNetworks returns an array 
	 * of unique network names read from filedata
	 * @return
	 */
	String[] getNetworks() {
		//write your code here
	    StringBuilder networkNames = new StringBuilder();
	    
	    for (String line : filedata) {
	        String[] parts = line.split(",");
	        if (parts.length > 4) {
	            String network = parts[4].trim();
	            if (!network.isEmpty() && networkNames.indexOf(network) == -1) {
	                networkNames.append(network).append(",");
	            }
	        }
	    }
	    
	    String[] uniqueNetworks = networkNames.toString().split(",");
	    networks = new String[uniqueNetworks.length];
	    
	    for (int i = 0; i < uniqueNetworks.length; i++) {
	    	networks[i] = uniqueNetworks[i];
	    }
	    return networks;
	}

	/** getSeries returns an array of
	 * unique series names read from filedata
	 * @return
	 */
	String[] getSeries() {
	    StringBuilder seriesNames = new StringBuilder();
	    
	    for (String line : filedata) {
	        String[] parts = line.split(",");
	        if (parts.length > 3) { 
	            String series = parts[3].trim();
	            if (!series.isEmpty() && seriesNames.indexOf(series) == -1) {
	                seriesNames.append(series).append(",");
	            }
	        }
	    }
	    
	    String[] uniqueSeries = seriesNames.toString().split(",");
	    series = new String[uniqueSeries.length];
	    
	    for (int i = 0; i < uniqueSeries.length; i++) {
	    	series[i] = uniqueSeries[i];
	    }
	    return series;
	}

	/** buildWardTable() builds a matrix of total awards
	 * for a series on a network. The rows represent the series
	 * and columns represent the network.
	 * @return
	 */
	int[][] buildAwardTable() {
	    int[][] awardTable = new int[series.length][networks.length];

	    for (int i = 0; i < filedata.length; i++) {
	        String[] words = filedata[i].split(",");
	        
	        if (words.length >= 4) {
	            String seriesName = words[3].trim();
	            String networkName = words[words.length - 1].trim();
	            
	            for (int j = 0; j < series.length; j++) {
	                for (int k = 0; k < networks.length; k++) {
	                    if (seriesName.equals(series[j]) && networkName.equals(networks[k])) {
	                        awardTable[j][k]++;
	                    }
	                }
	            }
	        }
	    }
	    return awardTable;
	}

	//do not change this method
	void printAwardTable() {
		System.out.println("************* EMMY Award Winners 2021 *************");
		System.out.printf("%45s", " ");
		for (String s : networks) System.out.printf("%10s\t", s);  	//print top row of networks
		System.out.println();
		int count = 0;
		for (int i = 0; i < awardTable.length; i++) {  			//for each series
			System.out.printf("%2d. %-45s", ++count, series[i]);				//print series name
			for (int j = 0; j < awardTable[i].length; j++) {	//print no. of awards
				System.out.printf("%s\t\t", (awardTable[i][j] == 0 ? "-": awardTable[i][j]));
			}
			System.out.println();
		}
	}
}