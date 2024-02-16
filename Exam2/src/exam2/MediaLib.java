package exam2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MediaLib {

	Media[] media; //to hold all types of media

	//please DO NOT change the main method
	public static void main(String[] args) {
		MediaLib mediaLib = new MediaLib();
		mediaLib.loadMedia("Media.txt");
		int index = 0;
		System.out.println("*** Welcome to MediaLib ***");
		for (Media m: mediaLib.media) {
			System.out.printf("%2d. %-10s %-20s \t %10s %n", ++index, m.getClass().getSimpleName(), m.title, m.year);
		}
		System.out.println("------------------------------");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the media number you would like to enjoy today?");
		int choice = input.nextInt();
		input.nextLine();
		input.close();
		mediaLib.selectMedia(choice);
	}

	
	//loadMedia reads the data from the file named filename 

	// and loads different types of media into media[] array

	void loadMedia(String filename) {

		//write your code here

		String[] mediaRows = null;

		

		try {

			Scanner file = new Scanner(new File(filename));

			StringBuilder sb = new StringBuilder();

			while (file.hasNextLine()) {

				sb.append(file.nextLine() + "\n");

			}

			

			mediaRows = sb.toString().split("\n");

			

			file.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		

		media = new Media[mediaRows.length];

		

		for(int i=0; i<mediaRows.length;i++) {

			if(mediaRows[i].split(",")[0].trim().equalsIgnoreCase(("movie"))) {

				Movie movie = new Movie(mediaRows[i].split(",")[1].trim(),mediaRows[i].split(",")[4].trim(),mediaRows[i].split(",")[2].trim(),Integer.valueOf(mediaRows[i].split(",")[3].trim()));

				media[i] = movie;

			}

			else if(mediaRows[i].split(",")[0].trim().equalsIgnoreCase(("book"))) {

				Book book = new Book(mediaRows[i].split(",")[1].trim(),mediaRows[i].split(",")[4].trim(),mediaRows[i].split(",")[2].trim(),Integer.valueOf(mediaRows[i].split(",")[3].trim()));

				media[i] = book;

			}

			else {

				EBook eBook = new EBook(mediaRows[i].split(",")[1].trim(),mediaRows[i].split(",")[4].trim(),mediaRows[i].split(",")[2].trim(),Integer.valueOf(mediaRows[i].split(",")[3].trim()),mediaRows[i].split(",")[5].trim(),Integer.valueOf(mediaRows[i].split(",")[6].trim()));

				media[i] = eBook;

			}

		}

	}

	

	//selectMedia takes the user choice, uses it to index into media[]

	//and invokes the media' enjoy().

	//For EBooks, it needs to invoke download() before invoking enjoy()

	void selectMedia(int choice) {
		//write your code here
		if(media[choice-1].getClass().getSimpleName().equalsIgnoreCase("movie") || media[choice-1].getClass().getSimpleName().equalsIgnoreCase("book")) {
			media[choice-1].enjoy();
		}
		else {
			media[choice-1].enjoy();
		}		
	}
}
//	//loadMedia reads the data from the file named filename 
//	// and loads different types of media into media[] array
//	void loadMedia(String filename) {
//		//write your code here
//		int mediaCount = 0;
//		int count = 0;
//		
//		try (Scanner scanner = new Scanner(new File(filename))) {
//			while (scanner.hasNextLine()) {
//				count++;
//			}
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		media = new Media[count];
//		
//		try (Scanner scanner = new Scanner(new File(filename))) {
//			while (scanner.hasNextLine()) {
//				String line = scanner.nextLine();
//				String[] tokens = line.split(", ");
//				
//				String mediaType = tokens[0].toLowerCase().trim();
//				
//				switch (mediaType) {
//				case "book":
//					media[mediaCount++] = new Book(tokens[1].trim(), tokens[4].trim(), tokens[2].trim(), Integer.parseInt(tokens[3].trim()));
//					break;
//				case "movie":
//					media[mediaCount++] = new Movie(tokens[1].trim(), tokens[4].trim(), tokens[2].trim(), Integer.parseInt(tokens[3].trim()));
//					break;
//				case "ebook":
//					media[mediaCount++] = new EBook(tokens[1].trim(), tokens[4].trim(), tokens[2].trim(), Integer.parseInt(tokens[3].trim()), 
//							                        tokens[5].trim(), Integer.parseInt(tokens[6].trim()));
//                    break;
//                default:
//                	System.out.println("Invalid media type: " + mediaType);
//                    break;
//				}
//			}
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//selectMedia takes the user choice, uses it to index into media[]
//	//and invokes the media' enjoy().
//	//For EBooks, it needs to invoke download() before invoking enjoy()
//	void selectMedia(int choice) {
//		//write your code here
//		if (choice < 1 || choice > media.length) {
//			System.out.println("Invalid choice. Please enter a valid media number");
//			return;
//		}
//		
//		Media selectedMedia = media[choice - 1];
//		
//		if (selectedMedia instanceof EBook) {
//			EBook selectedEBook = (EBook) selectedMedia;
//			selectedEBook.download();
//		}
//		
//		selectedMedia.enjoy();
//	}
//}