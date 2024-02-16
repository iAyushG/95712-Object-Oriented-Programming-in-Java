package exam2;

public abstract class Media {
	String title;
	String year;
	
	public Media(String title, String year) {
		this.title = title;
		this.year = year;
	}
	
	public abstract int enjoy();
}