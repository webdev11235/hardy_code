package examples.pubhub.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;

public class TestTagDAO {
	public static void main(String[] args){
		BookTagDAO bookDao = new BookTagDAOImpl();
		List<Book> booksWithTag = bookDao.getBooksWithTag("dog");
		List<BookTag> bookTags = bookDao.getBookTags("2222222222222");
		
		/*for (Book book: booksWithTag) {
			System.out.println(book.getIsbn13());
		}*/
		for (BookTag bookTag: bookTags) {
			System.out.println(bookTag.getTagName());
		}
		
	  }
}
