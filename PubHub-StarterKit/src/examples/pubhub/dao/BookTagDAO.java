package examples.pubhub.dao;


import java.util.List;
import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;

public interface BookTagDAO {
	public boolean addBookTag(String tagName, String isbn13);
	public boolean removeBookTag(String tagName, String isbn13);
	public List<BookTag> getBookTags(String isbn13);
	public List<Book> getBooksWithTag(String tagName);
}
