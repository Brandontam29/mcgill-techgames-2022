import java.util.Date;
import java.text.SimpleDateFormat;

public class Song {
	String name;
	String author;
	String genre;
	String dateAdded;

	public Song(String name, String author, String genre) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.dateAdded = formatDate(new Date());
	}

	public String toJson() {
        String output = "{\"name\": \" " + this.getName() + "\" , ";
        output += " \"author\": \" " + this.getAuthor() + "\" ,";
        output += " \"genre\": \" " + this.getGenre() + "\" ,";
        output += " \"dateAdded\": \" " + this.getDateAdded() + "\" } ";

        return output;
    }
	
	private String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
