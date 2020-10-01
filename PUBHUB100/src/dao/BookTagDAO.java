package dao;


import java.util.List;
import model.Book;
import model.BookTag;

public interface BookTagDAO {
	public boolean addBookTag(String tagName, String isbn13);
	public boolean removeBookTag(String tagName, String isbn13);
	public List<BookTag> getBookTags(String isbn13);
	public List<Book> getBooksWithTag(String tagName);
}
