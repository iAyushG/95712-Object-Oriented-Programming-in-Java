package exam2;

public class EBook extends Book implements Downloadable {

	String format;
	int size;
	
	public EBook(String title, String year, String author, int pages, String format, int size) {
		super(title, year, author, pages);
		this.format = format;
		this.size = size;
	}

	@Override
	public int download() {
		System.out.println("Downloading eBook: " + title + " by " + author + " for next " + size / INTERNET_SPEED);
		return size / INTERNET_SPEED;
	}
	
	@Override
	public int enjoy() {
		System.out.println("Reading book: " + title + " by " + author + " for next " + pages * PAGE_READING_TIME);
		return pages * PAGE_READING_TIME;
	}
}