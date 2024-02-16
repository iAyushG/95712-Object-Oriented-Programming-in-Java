package exam2;

public class Book extends Media {

	static final int PAGE_READING_TIME = 5;
	String author;
	int pages;
	
	public Book(String title, String year, String author, int pages) {
		super(title, year);
		this.author = author;
		this.pages = pages;
	}

	@Override
	public int enjoy() {
		System.out.println("Reading book: " + title + " by " + author + " for next " + pages * PAGE_READING_TIME);
		return pages * PAGE_READING_TIME;
	}
}